package org.tzi.use.parser.ocl;

import org.tzi.use.parser.Context;
import org.tzi.use.parser.SemanticException;
import org.tzi.use.uml.ocl.expr.ExpConstUReal;
import org.tzi.use.uml.ocl.expr.Expression;
import org.tzi.use.uml.ocl.type.Type;

import java.util.Set;

public class ASTURealLiteral extends ASTExpression {

    private ASTExpression eValue;
    private ASTExpression eUncertainty;

    public ASTURealLiteral(ASTExpression eValue, ASTExpression eUncertainty) {
        this.eUncertainty = eUncertainty;
        this.eValue = eValue;
    }

    @Override
    public Expression gen(Context ctx) throws SemanticException {
        Type valueType = eValue.gen(ctx).type();
        Type uncertaintyType = eUncertainty.gen(ctx).type();

        // Only integer or real are allowed.
        if ( !( valueType.isTypeOfInteger() || valueType.isTypeOfReal()) )
            throw new SemanticException("Value must be Integer or Real");

        if ( !(uncertaintyType.isTypeOfReal() || uncertaintyType.isTypeOfInteger()) )
            throw new SemanticException("Uncertainty must be Integer or Real");


        return new ExpConstUReal(eValue.gen(ctx), eUncertainty.gen(ctx));
    }

    @Override
    public void getFreeVariables(Set<String> freeVars) {
        eValue.getFreeVariables(freeVars);
        eUncertainty.getFreeVariables(freeVars);
    }

    @Override
    public String toString() {
        return "UReal(" + eValue.toString() + ", " + eUncertainty.toString() + ")";
    }
}
