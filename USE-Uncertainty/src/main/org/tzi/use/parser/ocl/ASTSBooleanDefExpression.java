package org.tzi.use.parser.ocl;

import org.tzi.use.parser.Context;
import org.tzi.use.parser.SemanticException;
import org.tzi.use.uml.ocl.expr.ExpDefSBoolean;
import org.tzi.use.uml.ocl.expr.Expression;


import java.util.Set;

public class ASTSBooleanDefExpression extends ASTExpression {

    private ASTExpression astBool;

    public ASTSBooleanDefExpression(ASTExpression eBool) {
        this.astBool = eBool;
    }

    @Override
    public Expression gen(Context ctx) throws SemanticException {
        Expression exprBool = astBool.gen(ctx);
        Expression result = null;

        try {
            result = new ExpDefSBoolean(exprBool);
        }
        catch (Exception ex) {
            throw new SemanticException(ex.getMessage());
        }

        return result;
    }

    @Override
    public void getFreeVariables(Set<String> freeVars) {
        astBool.getFreeVariables(freeVars);
    }
}
