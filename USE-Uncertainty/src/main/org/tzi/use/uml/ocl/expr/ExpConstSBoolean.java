package org.tzi.use.uml.ocl.expr;

import org.tzi.use.uml.ocl.type.Type;
import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.uml.ocl.value.SBooleanValue;
import org.tzi.use.uml.ocl.value.UndefinedValue;
import org.tzi.use.uml.ocl.value.Value;

public class ExpConstSBoolean extends Expression {

    private Expression beliefExpression;
    private Expression disbeliefExpression;
    private Expression uncertaintyExpression;
    private Expression agentExpression;

    public ExpConstSBoolean(Expression beliefExpression, Expression disbeliefExpression, Expression uncertaintyExpression, Expression agentExpression) throws ExpInvalidException {
        super(TypeFactory.mkSBoolean());

        if (!beliefExpression.type().isKindOfReal(Type.VoidHandling.EXCLUDE_VOID))
            throw new ExpInvalidException("Belief  must be a kind of Real");

        if (!disbeliefExpression.type().isKindOfReal(Type.VoidHandling.EXCLUDE_VOID))
            throw new ExpInvalidException("Disbelief  must be a kind of Real");

        if (!uncertaintyExpression.type().isKindOfReal(Type.VoidHandling.EXCLUDE_VOID))
            throw new ExpInvalidException("Uncertainty  must be a kind of Real");

        if (!agentExpression.type().isKindOfReal(Type.VoidHandling.EXCLUDE_VOID))
            throw new ExpInvalidException("Agent  must be a kind of Real");

        this.beliefExpression = beliefExpression;
        this.disbeliefExpression = disbeliefExpression;
        this.uncertaintyExpression = uncertaintyExpression;
        this.agentExpression = agentExpression;
    }

    @Override
    public Value eval(EvalContext ctx) {
        Value belief, disbelief, uncertainty, agent;
        Value result = null;

        ctx.enter(this);
        belief = beliefExpression.eval(ctx);
        disbelief = disbeliefExpression.eval(ctx);
        uncertainty = uncertaintyExpression.eval(ctx);
        agent = agentExpression.eval(ctx);

        try {
            result = new SBooleanValue.Builder()
                    .belief(Double.parseDouble(belief.toString()))
                    .disbelief(Double.parseDouble(disbelief.toString()))
                    .uncertainty(Double.parseDouble(uncertainty.toString()))
                    .agent(Double.parseDouble(agent.toString()))
                    .build();

        }
        catch (Exception ex) {
            result = UndefinedValue.instance;
        }
        ctx.exit(this, result);

        return result;
    }

    @Override
    protected boolean childExpressionRequiresPreState() {
        return false;
    }

    @Override
    public StringBuilder toString(StringBuilder sb) {
        sb.append("SBoolean(")
                .append(beliefExpression.toString())
                .append(",")
                .append(disbeliefExpression.toString())
                .append(",")
                .append(uncertaintyExpression.toString())
                .append(",")
                .append(agentExpression.toString())
                .append(")");
        return sb;
    }

    @Override
    public void processWithVisitor(ExpressionVisitor visitor) {
        visitor.visitConstSBoolean(this);
    }
}
