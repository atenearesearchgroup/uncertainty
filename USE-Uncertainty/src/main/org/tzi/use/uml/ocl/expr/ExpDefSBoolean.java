package org.tzi.use.uml.ocl.expr;

import org.tzi.use.uml.ocl.type.Type;
import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.uml.ocl.value.SBooleanValue;
import org.tzi.use.uml.ocl.value.Value;

public class ExpDefSBoolean extends Expression {

    private Expression eBool;

    public ExpDefSBoolean(Expression eBool) {
        super(TypeFactory.mkSBoolean());

        if (eBool.type().isKindOfUBoolean(Type.VoidHandling.EXCLUDE_VOID))
            throw new RuntimeException("Expression Boolean or UBoolean expected");

        this.eBool = eBool;
    }

    @Override
    public Value eval(EvalContext ctx) {
        Value boolValue = null;

        ctx.enter(this);
        boolValue = eBool.eval(ctx);

        return SBooleanValue.valueOf(boolValue);
    }

    @Override
    protected boolean childExpressionRequiresPreState() {
        return false;
    }

    @Override
    public StringBuilder toString(StringBuilder sb) {
        sb.append("SBoolean(")
                .append(eBool.toString())
                .append(")");
        return sb;
    }

    @Override
    public void processWithVisitor(ExpressionVisitor visitor) {
        visitor.visitDefSBoolean(this);
    }
}
