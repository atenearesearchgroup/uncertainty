package org.tzi.use.uml.ocl.expr;

import org.tzi.use.uml.ocl.value.Value;

/**
 * OCL uSelect expression
 *
 * @author Víctor M. Ortiz
 */

public class ExpUSelect extends ExpQuery {

    /**
     * Constructs a select expression.
     * @param elemVarDecl  Vars declared in expression (may be null)
     * @param rangeExp     Expression with a collection of values
     * @param queryExp     Query about the collection
     * @throws ExpInvalidException
     */
    public ExpUSelect(VarDecl elemVarDecl,
                      Expression rangeExp,
                      Expression queryExp)
            throws ExpInvalidException
    {
        super(rangeExp.type(),
                elemVarDecl != null ? new VarDeclList(elemVarDecl) : new VarDeclList(true),
                rangeExp, queryExp);

        assertKindOfUBoolean();
    }

    @Override
    public Value eval(EvalContext ctx) {
        ctx.enter(this);
        Value res = evalUSelect(ctx);
        ctx.exit(this, res);
        return res;
    }

    @Override
    public String name() {
        return "uSelect";
    }

    @Override
    public void processWithVisitor(ExpressionVisitor visitor) {
        visitor.visitUSelect(this);
    }
}
