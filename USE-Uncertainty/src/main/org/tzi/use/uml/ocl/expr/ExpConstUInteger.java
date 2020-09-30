package org.tzi.use.uml.ocl.expr;

import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.uml.ocl.value.*;

public class ExpConstUInteger extends Expression {

    private Expression eValue;
    private Expression eUncertainty;

    public ExpConstUInteger(Expression eValue, Expression eUncertainty) throws ExpInvalidException {
        super(TypeFactory.mkUInteger());

        if (!eValue.type().isTypeOfInteger() && !eValue.type().isTypeOfVoidType())
            throw new ExpInvalidException("Value must be Integer");

        if (!(eUncertainty.type().isTypeOfInteger() || eUncertainty.type().isTypeOfReal() || eUncertainty.type().isTypeOfVoidType()))
            throw new ExpInvalidException("Uncertainty must be Integer or Real");

        this.eValue = eValue;
        this.eUncertainty = eUncertainty;
    }

    @Override
    public Value eval(EvalContext ctx) {
        Value value, uncertainty, result;
        double uncertaintyValue;

        ctx.enter(this);

        value = eValue.eval(ctx);
        uncertainty = eUncertainty.eval(ctx);

        if (value.isDefined() && uncertainty.isDefined()) {

            if (uncertainty.isInteger())
                uncertaintyValue = ((IntegerValue) uncertainty).value();
            else
                uncertaintyValue = ((RealValue) uncertainty).value();

            result = new UIntegerValue(((IntegerValue) value).value(), uncertaintyValue);
        }
        else
            result = UndefinedValue.instance;

        ctx.exit(this, result);

        return result;
    }

    @Override
    protected boolean childExpressionRequiresPreState() {
        return false;
    }

    @Override
    public StringBuilder toString(StringBuilder sb) {
        sb.append(TypeFactory.mkUInteger().toString());
        sb.append("(").append(eValue.toString()).append(", ");
        sb.append(eUncertainty.toString()).append(")");
        return sb;
    }

    @Override
    public void processWithVisitor(ExpressionVisitor visitor) {
        visitor.visitConstUInteger(this);
    }
}
