package org.tzi.use.parser.ocl;

import org.tzi.use.parser.Context;
import org.tzi.use.parser.SemanticException;
import org.tzi.use.uml.ocl.expr.ExpConstUBoolean;
import org.tzi.use.uml.ocl.expr.ExpInvalidException;
import org.tzi.use.uml.ocl.expr.Expression;

import java.util.Set;

public class ASTUBooleanLiteral extends ASTExpression {

    public ASTExpression eValue;
    public ASTExpression eProbability;

    public ASTUBooleanLiteral(ASTExpression eValue, ASTExpression eProbability) {
        this.eValue = eValue;
        this.eProbability = eProbability;
    }

    @Override
    public Expression gen(Context ctx) throws SemanticException {
        Expression result = null;
        Expression genValue = eValue.gen(ctx);
        Expression genProbability = eProbability.gen(ctx);

        try {
            result = new ExpConstUBoolean(genValue, genProbability);
        }
        catch (ExpInvalidException ex) {
            throw new SemanticException(ex.getMessage());
        }

        return result;
    }

    @Override
    public void getFreeVariables(Set<String> freeVars) {
        eValue.getFreeVariables(freeVars);
        eProbability.getFreeVariables(freeVars);
    }

    @Override
    public String toString() {
        return "UBoolean(" + eValue.toString() + ", " + eProbability.toString() + ")";
    }
}
