package org.tzi.use.parser.ocl;

import org.tzi.use.parser.Context;
import org.tzi.use.parser.SemanticException;
import org.tzi.use.uml.ocl.expr.ExpConstSBoolean;
import org.tzi.use.uml.ocl.expr.Expression;

import java.util.Set;

public class ASTSBooleanLiteral extends ASTExpression {

    private ASTExpression beliefExpression;
    private ASTExpression disbeliefExpression;
    private ASTExpression uncertaintyExpression;
    private ASTExpression agentExpression;

    public ASTSBooleanLiteral(ASTExpression beliefExpression, ASTExpression disbeliefExpression, ASTExpression uncertaintyExpression, ASTExpression agentExpression) {
        this.beliefExpression = beliefExpression;
        this.disbeliefExpression = disbeliefExpression;
        this.uncertaintyExpression = uncertaintyExpression;
        this.agentExpression = agentExpression;
    }

    @Override
    public Expression gen(Context ctx) throws SemanticException {
        Expression result = null;
        Expression eBelief = beliefExpression.gen(ctx);
        Expression eDisbelief = disbeliefExpression.gen(ctx);
        Expression eUncertainty = uncertaintyExpression.gen(ctx);
        Expression eAgent = agentExpression.gen(ctx);

        try {
            result = new ExpConstSBoolean(eBelief, eDisbelief, eUncertainty, eAgent);
        }
        catch(Exception e) {
            throw new SemanticException(e.getMessage());
        }

        return result;
    }

    @Override
    public void getFreeVariables(Set<String> freeVars) {
        beliefExpression.getFreeVariables(freeVars);
        disbeliefExpression.getFreeVariables(freeVars);
        uncertaintyExpression.getFreeVariables(freeVars);
        agentExpression.getFreeVariables(freeVars);
    }

    @Override
    public String toString() {
        return "SBoolean(" + beliefExpression.toString() + "," + disbeliefExpression.toString() + "," +
                uncertaintyExpression.toString() + "," + agentExpression.toString() + ")";
    }
}
