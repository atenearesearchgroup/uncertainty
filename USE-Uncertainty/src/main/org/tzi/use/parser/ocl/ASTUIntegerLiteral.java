package org.tzi.use.parser.ocl;

import org.tzi.use.parser.Context;
import org.tzi.use.parser.SemanticException;
import org.tzi.use.uml.ocl.expr.ExpConstUInteger;
import org.tzi.use.uml.ocl.expr.ExpInvalidException;
import org.tzi.use.uml.ocl.expr.Expression;

import java.util.Set;

public class ASTUIntegerLiteral extends ASTExpression {

    private ASTExpression eValue;
    private ASTExpression eUncertainty;

    public ASTUIntegerLiteral(ASTExpression eValue, ASTExpression eUncertainty) {
        this.eValue = eValue;
        this.eUncertainty = eUncertainty;
    }

    @Override
    public Expression gen(Context ctx) throws SemanticException {
        Expression result = null;
        Expression value = eValue.gen(ctx);
        Expression uncertainty = eUncertainty.gen(ctx);

        try {
            result = new ExpConstUInteger(value, uncertainty);
        }
        catch (ExpInvalidException ex) {
            throw new SemanticException(ex.getMessage());
        }

        return result;
    }

    @Override
    public void getFreeVariables(Set<String> freeVars) {
        eValue.getFreeVariables(freeVars);
        eUncertainty.getFreeVariables(freeVars);
    }

    @Override
    public String toString() {
        return "UInteger(" + eValue.toString() + ", " + eUncertainty.toString() + ")";
    }
}
