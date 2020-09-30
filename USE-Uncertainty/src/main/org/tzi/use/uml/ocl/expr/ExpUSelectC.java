package org.tzi.use.uml.ocl.expr;

import org.tzi.use.uml.ocl.value.Value;

public class ExpUSelectC extends ExpQuery {

    public ExpUSelectC(VarDecl elemVarDecl,
                       Expression rangeExp,
                       Expression queryExp,
                       Expression uncertaintyExp)
        throws ExpInvalidException
    {
        super(rangeExp.type(),
                elemVarDecl != null ? new VarDeclList(elemVarDecl) : new VarDeclList(true),
                rangeExp, queryExp, uncertaintyExp);

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
        return "uSelectC";
    }

    @Override
    public void processWithVisitor(ExpressionVisitor visitor) {
        visitor.visitUSelectC(this);
    }
}
