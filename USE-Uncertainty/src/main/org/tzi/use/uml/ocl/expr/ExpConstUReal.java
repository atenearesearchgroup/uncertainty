package org.tzi.use.uml.ocl.expr;

import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.uml.ocl.value.RealValue;
import org.tzi.use.uml.ocl.value.URealValue;
import org.tzi.use.uml.ocl.value.UndefinedValue;
import org.tzi.use.uml.ocl.value.Value;

public class ExpConstUReal extends Expression {
    private Expression eValue;
    private Expression eUncertainty;

    public ExpConstUReal(Expression eValue, Expression eUncertainty) {
        super(TypeFactory.mkUReal());
        this.eValue = eValue;
        this.eUncertainty = eUncertainty;
    }

    public String value() {
        return eValue.toString();
    }

    public String uncertainty() {
        return eUncertainty.toString();
    }

    @Override
    public Value eval(EvalContext ctx) {
        Value res = null;
        Value value, uncertainty;

        ctx.enter(this);;
        value = eValue.eval(ctx);
        uncertainty = eUncertainty.eval(ctx);

        if (value.isUndefined() || uncertainty.isUndefined())
            res = UndefinedValue.instance;
        else
            res = new URealValue(
                    Double.valueOf(value.toString()),
                    Double.valueOf(uncertainty.toString())
            );

        ctx.exit(this, res);

        return res;
    }

    @Override
    protected boolean childExpressionRequiresPreState() {
        return false;
    }

    @Override
    public StringBuilder toString(StringBuilder sb) {
        sb.append("UReal(")
                .append(eValue.toString())
                .append(",")
                .append(eUncertainty.toString())
                .append(")");
        return sb;
    }

    @Override
    public void processWithVisitor(ExpressionVisitor visitor) {
        visitor.visitConstUReal(this);
    }

}
