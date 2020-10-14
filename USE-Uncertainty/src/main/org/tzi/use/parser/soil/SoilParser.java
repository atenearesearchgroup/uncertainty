// $ANTLR 3.4 Soil.g 2020-10-07 09:31:59

/*
 * USE - UML based specification environment
 * Copyright (C) 1999-2010 Mark Richters, University of Bremen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.  
 */
 
package org.tzi.use.parser.soil;

import org.tzi.use.parser.base.BaseParser;
import org.tzi.use.parser.use.*;
import org.tzi.use.parser.ocl.*;
import org.tzi.use.parser.soil.ast.*;

import java.util.Collections;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SoilParser extends BaseParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARROW", "AT", "BAR", "COLON", "COLON_COLON", "COLON_EQUAL", "COMMA", "DOT", "DOTDOT", "EQUAL", "ESC", "GREATER", "GREATER_EQUAL", "HASH", "HEX_DIGIT", "IDENT", "INT", "LBRACE", "LBRACK", "LESS", "LESS_EQUAL", "LPAREN", "MINUS", "ML_COMMENT", "NEWLINE", "NON_OCL_STRING", "NOT_EQUAL", "PLUS", "RANGE_OR_INT", "RBRACE", "RBRACK", "REAL", "RPAREN", "SEMI", "SLASH", "SL_COMMENT", "STAR", "STRING", "VOCAB", "WS", "'Bag'", "'Collection'", "'OrderedSet'", "'SBoolean'", "'Sequence'", "'Set'", "'Tuple'", "'UBoolean'", "'UInteger'", "'UReal'", "'UString'", "'Undefined'", "'allInstances'", "'and'", "'begin'", "'between'", "'byUseId'", "'declare'", "'delete'", "'destroy'", "'div'", "'do'", "'else'", "'end'", "'endif'", "'equals'", "'false'", "'for'", "'from'", "'if'", "'implies'", "'in'", "'insert'", "'into'", "'iterate'", "'let'", "'new'", "'not'", "'null'", "'oclAsType'", "'oclEmpty'", "'oclInState'", "'oclIsKindOf'", "'oclIsTypeOf'", "'oclUndefined'", "'or'", "'pre'", "'selectByKind'", "'selectByType'", "'then'", "'true'", "'while'", "'xor'"
    };

    public static final int EOF=-1;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int ARROW=4;
    public static final int AT=5;
    public static final int BAR=6;
    public static final int COLON=7;
    public static final int COLON_COLON=8;
    public static final int COLON_EQUAL=9;
    public static final int COMMA=10;
    public static final int DOT=11;
    public static final int DOTDOT=12;
    public static final int EQUAL=13;
    public static final int ESC=14;
    public static final int GREATER=15;
    public static final int GREATER_EQUAL=16;
    public static final int HASH=17;
    public static final int HEX_DIGIT=18;
    public static final int IDENT=19;
    public static final int INT=20;
    public static final int LBRACE=21;
    public static final int LBRACK=22;
    public static final int LESS=23;
    public static final int LESS_EQUAL=24;
    public static final int LPAREN=25;
    public static final int MINUS=26;
    public static final int ML_COMMENT=27;
    public static final int NEWLINE=28;
    public static final int NON_OCL_STRING=29;
    public static final int NOT_EQUAL=30;
    public static final int PLUS=31;
    public static final int RANGE_OR_INT=32;
    public static final int RBRACE=33;
    public static final int RBRACK=34;
    public static final int REAL=35;
    public static final int RPAREN=36;
    public static final int SEMI=37;
    public static final int SLASH=38;
    public static final int SL_COMMENT=39;
    public static final int STAR=40;
    public static final int STRING=41;
    public static final int VOCAB=42;
    public static final int WS=43;

    // delegates
    public BaseParser[] getDelegates() {
        return new BaseParser[] {};
    }

    // delegators


    public SoilParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public SoilParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return SoilParser.tokenNames; }
    public String getGrammarFileName() { return "Soil.g"; }



    // $ANTLR start "statOnly"
    // Soil.g:116:1: statOnly returns [ASTStatement n] : s= stat EOF ;
    public final ASTStatement statOnly() throws RecognitionException {
        ASTStatement n = null;


        SoilParser.stat_return s =null;


        try {
            // Soil.g:117:3: (s= stat EOF )
            // Soil.g:118:3: s= stat EOF
            {
            pushFollow(FOLLOW_stat_in_statOnly76);
            s=stat();

            state._fsp--;
            if (state.failed) return n;

            match(input,EOF,FOLLOW_EOF_in_statOnly80); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = (s!=null?s.n:null); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "statOnly"


    public static class stat_return extends ParserRuleReturnScope {
        public ASTStatement n;
    };


    // $ANTLR start "stat"
    // Soil.g:128:1: stat returns [ASTStatement n] : s= singleStat ( SEMI s2= singleStat )* ;
    public final SoilParser.stat_return stat() throws RecognitionException {
        SoilParser.stat_return retval = new SoilParser.stat_return();
        retval.start = input.LT(1);


        ASTStatement s =null;

        ASTStatement s2 =null;



          ASTSequenceStatement seq = new ASTSequenceStatement(((Token)retval.start));

        try {
            // Soil.g:132:3: (s= singleStat ( SEMI s2= singleStat )* )
            // Soil.g:133:3: s= singleStat ( SEMI s2= singleStat )*
            {
            pushFollow(FOLLOW_singleStat_in_stat115);
            s=singleStat();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {seq.addStatement(s);}

            // Soil.g:134:3: ( SEMI s2= singleStat )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==SEMI) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Soil.g:135:5: SEMI s2= singleStat
            	    {
            	    match(input,SEMI,FOLLOW_SEMI_in_stat127); if (state.failed) return retval;

            	    pushFollow(FOLLOW_singleStat_in_stat137);
            	    s2=singleStat();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {seq.addStatement(s2); }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            if ( state.backtracking==0 ) { 
                retval.n = seq.simplify();
              }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stat"



    // $ANTLR start "singleStat"
    // Soil.g:147:1: singleStat returns [ASTStatement n] : (emp= emptyStat | ( statStartingWithExpr )=>sse= statStartingWithExpr |vas= varAssignStat |ocs= objCreateStat |ods= objDestroyStat |lis= lnkInsStat |lds= lnkDelStat |ces= condExStat |its= iterStat |whs= whileStat |blk= blockStat );
    public final ASTStatement singleStat() throws RecognitionException {
        ASTStatement n = null;


        ASTEmptyStatement emp =null;

        SoilParser.statStartingWithExpr_return sse =null;

        ASTStatement vas =null;

        SoilParser.objCreateStat_return ocs =null;

        SoilParser.objDestroyStat_return ods =null;

        SoilParser.lnkInsStat_return lis =null;

        SoilParser.lnkDelStat_return lds =null;

        SoilParser.condExStat_return ces =null;

        SoilParser.iterStat_return its =null;

        SoilParser.whileStat_return whs =null;

        SoilParser.blockStat_return blk =null;


        try {
            // Soil.g:148:5: (emp= emptyStat | ( statStartingWithExpr )=>sse= statStartingWithExpr |vas= varAssignStat |ocs= objCreateStat |ods= objDestroyStat |lis= lnkInsStat |lds= lnkDelStat |ces= condExStat |its= iterStat |whs= whileStat |blk= blockStat )
            int alt2=11;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==EOF||LA2_0==SEMI||(LA2_0 >= 66 && LA2_0 <= 67)) ) {
                alt2=1;
            }
            else if ( (LA2_0==79) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==MINUS||LA2_0==PLUS||LA2_0==81) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==94) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==70) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==INT) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==REAL) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==STRING) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==54) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==53) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==51) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==52) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==47) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==HASH) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==IDENT) ) {
                int LA2_18 = input.LA(2);

                if ( (synpred1_Soil()) ) {
                    alt2=2;
                }
                else if ( (true) ) {
                    alt2=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 18, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==44||LA2_0==46||(LA2_0 >= 48 && LA2_0 <= 49)) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==84) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==45) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==88) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==55) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==82) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==50) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==STAR) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==AT) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==78) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==83||(LA2_0 >= 86 && LA2_0 <= 87)||(LA2_0 >= 91 && LA2_0 <= 92)) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==85) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==LPAREN) && (synpred1_Soil())) {
                alt2=2;
            }
            else if ( (LA2_0==73) ) {
                int LA2_32 = input.LA(2);

                if ( (synpred1_Soil()) ) {
                    alt2=2;
                }
                else if ( (true) ) {
                    alt2=8;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 32, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==80) ) {
                alt2=4;
            }
            else if ( (LA2_0==63) ) {
                alt2=5;
            }
            else if ( (LA2_0==76) ) {
                alt2=6;
            }
            else if ( (LA2_0==62) ) {
                alt2=7;
            }
            else if ( (LA2_0==71) ) {
                alt2=9;
            }
            else if ( (LA2_0==95) ) {
                alt2=10;
            }
            else if ( (LA2_0==58) ) {
                alt2=11;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Soil.g:149:5: emp= emptyStat
                    {
                    pushFollow(FOLLOW_emptyStat_in_singleStat177);
                    emp=emptyStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = emp; }

                    }
                    break;
                case 2 :
                    // Soil.g:151:5: ( statStartingWithExpr )=>sse= statStartingWithExpr
                    {
                    pushFollow(FOLLOW_statStartingWithExpr_in_singleStat203);
                    sse=statStartingWithExpr();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (sse!=null?sse.n:null); }

                    }
                    break;
                case 3 :
                    // Soil.g:152:5: vas= varAssignStat
                    {
                    pushFollow(FOLLOW_varAssignStat_in_singleStat215);
                    vas=varAssignStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = vas; }

                    }
                    break;
                case 4 :
                    // Soil.g:153:5: ocs= objCreateStat
                    {
                    pushFollow(FOLLOW_objCreateStat_in_singleStat229);
                    ocs=objCreateStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (ocs!=null?ocs.n:null); }

                    }
                    break;
                case 5 :
                    // Soil.g:154:5: ods= objDestroyStat
                    {
                    pushFollow(FOLLOW_objDestroyStat_in_singleStat243);
                    ods=objDestroyStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (ods!=null?ods.n:null); }

                    }
                    break;
                case 6 :
                    // Soil.g:155:5: lis= lnkInsStat
                    {
                    pushFollow(FOLLOW_lnkInsStat_in_singleStat256);
                    lis=lnkInsStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lis!=null?lis.n:null); }

                    }
                    break;
                case 7 :
                    // Soil.g:156:5: lds= lnkDelStat
                    {
                    pushFollow(FOLLOW_lnkDelStat_in_singleStat273);
                    lds=lnkDelStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lds!=null?lds.n:null); }

                    }
                    break;
                case 8 :
                    // Soil.g:157:5: ces= condExStat
                    {
                    pushFollow(FOLLOW_condExStat_in_singleStat290);
                    ces=condExStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (ces!=null?ces.n:null); }

                    }
                    break;
                case 9 :
                    // Soil.g:158:5: its= iterStat
                    {
                    pushFollow(FOLLOW_iterStat_in_singleStat307);
                    its=iterStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (its!=null?its.n:null); }

                    }
                    break;
                case 10 :
                    // Soil.g:160:5: whs= whileStat
                    {
                    pushFollow(FOLLOW_whileStat_in_singleStat329);
                    whs=whileStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (whs!=null?whs.n:null); }

                    }
                    break;
                case 11 :
                    // Soil.g:161:5: blk= blockStat
                    {
                    pushFollow(FOLLOW_blockStat_in_singleStat347);
                    blk=blockStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (blk!=null?blk.n:null); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "singleStat"



    // $ANTLR start "emptyStat"
    // Soil.g:168:1: emptyStat returns [ASTEmptyStatement n] : nothing ;
    public final ASTEmptyStatement emptyStat() throws RecognitionException {
        ASTEmptyStatement n = null;


        try {
            // Soil.g:169:3: ( nothing )
            // Soil.g:170:3: nothing
            {
            pushFollow(FOLLOW_nothing_in_emptyStat374);
            nothing();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTEmptyStatement(); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "emptyStat"


    public static class statStartingWithExpr_return extends ParserRuleReturnScope {
        public ASTStatement n;
    };


    // $ANTLR start "statStartingWithExpr"
    // Soil.g:175:1: statStartingWithExpr returns [ASTStatement n] : expr= inSoilExpression (aas= attAssignStat[$expr.n] )? ;
    public final SoilParser.statStartingWithExpr_return statStartingWithExpr() throws RecognitionException {
        SoilParser.statStartingWithExpr_return retval = new SoilParser.statStartingWithExpr_return();
        retval.start = input.LT(1);


        ASTExpression expr =null;

        ASTAttributeAssignmentStatement aas =null;


        try {
            // Soil.g:176:3: (expr= inSoilExpression (aas= attAssignStat[$expr.n] )? )
            // Soil.g:177:3: expr= inSoilExpression (aas= attAssignStat[$expr.n] )?
            {
            pushFollow(FOLLOW_inSoilExpression_in_statStartingWithExpr400);
            expr=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            // Soil.g:178:3: (aas= attAssignStat[$expr.n] )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DOT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Soil.g:179:5: aas= attAssignStat[$expr.n]
                    {
                    pushFollow(FOLLOW_attAssignStat_in_statStartingWithExpr414);
                    aas=attAssignStat(expr);

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n = aas; }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                if (aas == null) {
                  retval.n = new ASTOperationCallStatement(((Token)retval.start), expr); 
                }
              }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statStartingWithExpr"



    // $ANTLR start "varAssignStat"
    // Soil.g:191:1: varAssignStat returns [ASTStatement n] : varName= IDENT COLON_EQUAL rVal= rValue ;
    public final ASTStatement varAssignStat() throws RecognitionException {
        ASTStatement n = null;


        Token varName=null;
        ASTRValue rVal =null;


        try {
            // Soil.g:192:3: (varName= IDENT COLON_EQUAL rVal= rValue )
            // Soil.g:193:3: varName= IDENT COLON_EQUAL rVal= rValue
            {
            varName=(Token)match(input,IDENT,FOLLOW_IDENT_in_varAssignStat452); if (state.failed) return n;

            match(input,COLON_EQUAL,FOLLOW_COLON_EQUAL_in_varAssignStat456); if (state.failed) return n;

            pushFollow(FOLLOW_rValue_in_varAssignStat464);
            rVal=rValue();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {
                n = new ASTVariableAssignmentStatement(varName, (varName!=null?varName.getText():null), rVal);
              }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "varAssignStat"



    // $ANTLR start "attAssignStat"
    // Soil.g:205:1: attAssignStat[ASTExpression exp] returns [ASTAttributeAssignmentStatement n] : DOT attName= IDENT COLON_EQUAL r= rValue ;
    public final ASTAttributeAssignmentStatement attAssignStat(ASTExpression exp) throws RecognitionException {
        ASTAttributeAssignmentStatement n = null;


        Token attName=null;
        ASTRValue r =null;


        try {
            // Soil.g:206:3: ( DOT attName= IDENT COLON_EQUAL r= rValue )
            // Soil.g:207:3: DOT attName= IDENT COLON_EQUAL r= rValue
            {
            match(input,DOT,FOLLOW_DOT_in_attAssignStat488); if (state.failed) return n;

            attName=(Token)match(input,IDENT,FOLLOW_IDENT_in_attAssignStat497); if (state.failed) return n;

            match(input,COLON_EQUAL,FOLLOW_COLON_EQUAL_in_attAssignStat501); if (state.failed) return n;

            pushFollow(FOLLOW_rValue_in_attAssignStat509);
            r=rValue();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTAttributeAssignmentStatement(attName, exp, (attName!=null?attName.getText():null), r); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "attAssignStat"


    public static class objCreateStat_return extends ParserRuleReturnScope {
        public ASTStatement n;
    };


    // $ANTLR start "objCreateStat"
    // Soil.g:219:1: objCreateStat returns [ASTStatement n] : 'new' ident= simpleType ( LPAREN (objName= inSoilExpression )? RPAREN )? ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )? ;
    public final SoilParser.objCreateStat_return objCreateStat() throws RecognitionException {
        SoilParser.objCreateStat_return retval = new SoilParser.objCreateStat_return();
        retval.start = input.LT(1);


        ASTSimpleType ident =null;

        ASTExpression objName =null;

        SoilParser.rValListMin2WithOptionalQualifiers_return p =null;


        try {
            // Soil.g:220:3: ( 'new' ident= simpleType ( LPAREN (objName= inSoilExpression )? RPAREN )? ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )? )
            // Soil.g:221:3: 'new' ident= simpleType ( LPAREN (objName= inSoilExpression )? RPAREN )? ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )?
            {
            match(input,80,FOLLOW_80_in_objCreateStat535); if (state.failed) return retval;

            pushFollow(FOLLOW_simpleType_in_objCreateStat543);
            ident=simpleType();

            state._fsp--;
            if (state.failed) return retval;

            // Soil.g:223:3: ( LPAREN (objName= inSoilExpression )? RPAREN )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LPAREN) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Soil.g:224:5: LPAREN (objName= inSoilExpression )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_objCreateStat553); if (state.failed) return retval;

                    // Soil.g:225:7: (objName= inSoilExpression )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==AT||LA4_0==HASH||(LA4_0 >= IDENT && LA4_0 <= INT)||(LA4_0 >= LPAREN && LA4_0 <= MINUS)||LA4_0==PLUS||LA4_0==REAL||(LA4_0 >= STAR && LA4_0 <= STRING)||(LA4_0 >= 44 && LA4_0 <= 55)||LA4_0==70||LA4_0==73||(LA4_0 >= 78 && LA4_0 <= 79)||(LA4_0 >= 81 && LA4_0 <= 88)||(LA4_0 >= 91 && LA4_0 <= 92)||LA4_0==94) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // Soil.g:225:8: objName= inSoilExpression
                            {
                            pushFollow(FOLLOW_inSoilExpression_in_objCreateStat566);
                            objName=inSoilExpression();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_objCreateStat574); if (state.failed) return retval;

                    }
                    break;

            }


            // Soil.g:229:3: ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==59) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Soil.g:230:5: 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN
                    {
                    match(input,59,FOLLOW_59_in_objCreateStat592); if (state.failed) return retval;

                    match(input,LPAREN,FOLLOW_LPAREN_in_objCreateStat600); if (state.failed) return retval;

                    pushFollow(FOLLOW_rValListMin2WithOptionalQualifiers_in_objCreateStat614);
                    p=rValListMin2WithOptionalQualifiers();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,RPAREN,FOLLOW_RPAREN_in_objCreateStat622); if (state.failed) return retval;

                    if ( state.backtracking==0 ) { 
                        retval.n = new ASTNewLinkObjectStatement(((Token)retval.start), ident, (p!=null?p.participans:null), (p!=null?p.qualifiers:null), objName);
                        }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                if (retval.n == null) {
                  retval.n = new ASTNewObjectStatement(((Token)retval.start), ident, objName);
                }
              }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "objCreateStat"


    public static class objDestroyStat_return extends ParserRuleReturnScope {
        public ASTStatement n;
    };


    // $ANTLR start "objDestroyStat"
    // Soil.g:249:1: objDestroyStat returns [ASTStatement n] : 'destroy' el= exprListMin1 ;
    public final SoilParser.objDestroyStat_return objDestroyStat() throws RecognitionException {
        SoilParser.objDestroyStat_return retval = new SoilParser.objDestroyStat_return();
        retval.start = input.LT(1);


        List<ASTExpression> el =null;


        try {
            // Soil.g:250:3: ( 'destroy' el= exprListMin1 )
            // Soil.g:251:3: 'destroy' el= exprListMin1
            {
            match(input,63,FOLLOW_63_in_objDestroyStat658); if (state.failed) return retval;

            pushFollow(FOLLOW_exprListMin1_in_objDestroyStat666);
            el=exprListMin1();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {
                ASTSequenceStatement seq = new ASTSequenceStatement(((Token)retval.start));
                
                for (ASTExpression expression : el) {
                  seq.addStatement(
                    new ASTObjectDestructionStatement(((Token)retval.start), expression));
                }
                
                retval.n = seq.simplify();
              }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "objDestroyStat"


    public static class lnkInsStat_return extends ParserRuleReturnScope {
        public ASTLinkInsertionStatement n;
    };


    // $ANTLR start "lnkInsStat"
    // Soil.g:270:1: lnkInsStat returns [ASTLinkInsertionStatement n] : 'insert' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'into' ass= IDENT ;
    public final SoilParser.lnkInsStat_return lnkInsStat() throws RecognitionException {
        SoilParser.lnkInsStat_return retval = new SoilParser.lnkInsStat_return();
        retval.start = input.LT(1);


        Token ass=null;
        SoilParser.rValListMin2WithOptionalQualifiers_return p =null;


        try {
            // Soil.g:271:3: ( 'insert' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'into' ass= IDENT )
            // Soil.g:272:3: 'insert' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'into' ass= IDENT
            {
            match(input,76,FOLLOW_76_in_lnkInsStat692); if (state.failed) return retval;

            match(input,LPAREN,FOLLOW_LPAREN_in_lnkInsStat696); if (state.failed) return retval;

            pushFollow(FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkInsStat706);
            p=rValListMin2WithOptionalQualifiers();

            state._fsp--;
            if (state.failed) return retval;

            match(input,RPAREN,FOLLOW_RPAREN_in_lnkInsStat710); if (state.failed) return retval;

            match(input,77,FOLLOW_77_in_lnkInsStat714); if (state.failed) return retval;

            ass=(Token)match(input,IDENT,FOLLOW_IDENT_in_lnkInsStat722); if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n = new ASTLinkInsertionStatement(((Token)retval.start), (ass!=null?ass.getText():null), (p!=null?p.participans:null), (p!=null?p.qualifiers:null)); }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lnkInsStat"


    public static class rValListMin2WithOptionalQualifiers_return extends ParserRuleReturnScope {
        public List<ASTRValue> participans;
        public List<List<ASTRValue>> qualifiers;
    };


    // $ANTLR start "rValListMin2WithOptionalQualifiers"
    // Soil.g:282:1: rValListMin2WithOptionalQualifiers returns [List<ASTRValue> participans, List<List<ASTRValue>> qualifiers] : r= rValue ( LBRACE qualifierValues= rValList RBRACE )? COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )* ;
    public final SoilParser.rValListMin2WithOptionalQualifiers_return rValListMin2WithOptionalQualifiers() throws RecognitionException {
        SoilParser.rValListMin2WithOptionalQualifiers_return retval = new SoilParser.rValListMin2WithOptionalQualifiers_return();
        retval.start = input.LT(1);


        ASTRValue r =null;

        List<ASTRValue> qualifierValues =null;



          retval.participans = new ArrayList<ASTRValue>();
          retval.qualifiers = new ArrayList<List<ASTRValue>>();
          List<ASTRValue> currentQualifiers = Collections.emptyList();

        try {
            // Soil.g:288:3: (r= rValue ( LBRACE qualifierValues= rValList RBRACE )? COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )* )
            // Soil.g:289:3: r= rValue ( LBRACE qualifierValues= rValList RBRACE )? COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )*
            {
            pushFollow(FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers751);
            r=rValue();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.participans.add(r); }

            // Soil.g:290:3: ( LBRACE qualifierValues= rValList RBRACE )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LBRACE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Soil.g:291:4: LBRACE qualifierValues= rValList RBRACE
                    {
                    match(input,LBRACE,FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers762); if (state.failed) return retval;

                    pushFollow(FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers771);
                    qualifierValues=rValList();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {currentQualifiers = qualifierValues;}

                    match(input,RBRACE,FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers778); if (state.failed) return retval;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                retval.qualifiers.add(currentQualifiers);
                currentQualifiers = Collections.emptyList();
              }

            match(input,COMMA,FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers794); if (state.failed) return retval;

            pushFollow(FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers805);
            r=rValue();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.participans.add(r); }

            // Soil.g:303:3: ( LBRACE qualifierValues= rValList RBRACE )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LBRACE) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Soil.g:304:4: LBRACE qualifierValues= rValList RBRACE
                    {
                    match(input,LBRACE,FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers816); if (state.failed) return retval;

                    pushFollow(FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers825);
                    qualifierValues=rValList();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {currentQualifiers = qualifierValues;}

                    match(input,RBRACE,FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers832); if (state.failed) return retval;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                retval.qualifiers.add(currentQualifiers);
                currentQualifiers = Collections.emptyList();
              }

            // Soil.g:313:3: ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==COMMA) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Soil.g:314:5: COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )?
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers854); if (state.failed) return retval;

            	    pushFollow(FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers869);
            	    r=rValue();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { retval.participans.add(r); }

            	    // Soil.g:318:5: ( LBRACE qualifierValues= rValList RBRACE )?
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==LBRACE) ) {
            	        alt9=1;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // Soil.g:319:6: LBRACE qualifierValues= rValList RBRACE
            	            {
            	            match(input,LBRACE,FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers889); if (state.failed) return retval;

            	            pushFollow(FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers900);
            	            qualifierValues=rValList();

            	            state._fsp--;
            	            if (state.failed) return retval;

            	            if ( state.backtracking==0 ) {currentQualifiers = qualifierValues;}

            	            match(input,RBRACE,FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers909); if (state.failed) return retval;

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {
            	          retval.qualifiers.add(currentQualifiers);
            	          currentQualifiers = Collections.emptyList();
            	        }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rValListMin2WithOptionalQualifiers"


    public static class lnkDelStat_return extends ParserRuleReturnScope {
        public ASTLinkDeletionStatement n;
    };


    // $ANTLR start "lnkDelStat"
    // Soil.g:334:1: lnkDelStat returns [ASTLinkDeletionStatement n] : 'delete' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'from' ass= IDENT ;
    public final SoilParser.lnkDelStat_return lnkDelStat() throws RecognitionException {
        SoilParser.lnkDelStat_return retval = new SoilParser.lnkDelStat_return();
        retval.start = input.LT(1);


        Token ass=null;
        SoilParser.rValListMin2WithOptionalQualifiers_return p =null;


        try {
            // Soil.g:335:3: ( 'delete' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'from' ass= IDENT )
            // Soil.g:336:3: 'delete' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'from' ass= IDENT
            {
            match(input,62,FOLLOW_62_in_lnkDelStat950); if (state.failed) return retval;

            match(input,LPAREN,FOLLOW_LPAREN_in_lnkDelStat954); if (state.failed) return retval;

            pushFollow(FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkDelStat964);
            p=rValListMin2WithOptionalQualifiers();

            state._fsp--;
            if (state.failed) return retval;

            match(input,RPAREN,FOLLOW_RPAREN_in_lnkDelStat968); if (state.failed) return retval;

            match(input,72,FOLLOW_72_in_lnkDelStat972); if (state.failed) return retval;

            ass=(Token)match(input,IDENT,FOLLOW_IDENT_in_lnkDelStat981); if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n = new ASTLinkDeletionStatement(((Token)retval.start), (ass!=null?ass.getText():null), (p!=null?p.participans:null), (p!=null?p.qualifiers:null)); }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lnkDelStat"


    public static class condExStat_return extends ParserRuleReturnScope {
        public ASTConditionalExecutionStatement n;
    };


    // $ANTLR start "condExStat"
    // Soil.g:350:1: condExStat returns [ASTConditionalExecutionStatement n] : 'if' con= inSoilExpression 'then' ts= statOrImplicitBlock ( 'else' es= statOrImplicitBlock )? 'end' ;
    public final SoilParser.condExStat_return condExStat() throws RecognitionException {
        SoilParser.condExStat_return retval = new SoilParser.condExStat_return();
        retval.start = input.LT(1);


        ASTExpression con =null;

        ASTStatement ts =null;

        ASTStatement es =null;



          ASTStatement elseStat = new ASTEmptyStatement();

        try {
            // Soil.g:354:3: ( 'if' con= inSoilExpression 'then' ts= statOrImplicitBlock ( 'else' es= statOrImplicitBlock )? 'end' )
            // Soil.g:355:3: 'if' con= inSoilExpression 'then' ts= statOrImplicitBlock ( 'else' es= statOrImplicitBlock )? 'end'
            {
            match(input,73,FOLLOW_73_in_condExStat1012); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_condExStat1021);
            con=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            match(input,93,FOLLOW_93_in_condExStat1025); if (state.failed) return retval;

            pushFollow(FOLLOW_statOrImplicitBlock_in_condExStat1034);
            ts=statOrImplicitBlock();

            state._fsp--;
            if (state.failed) return retval;

            // Soil.g:359:3: ( 'else' es= statOrImplicitBlock )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==66) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Soil.g:360:5: 'else' es= statOrImplicitBlock
                    {
                    match(input,66,FOLLOW_66_in_condExStat1045); if (state.failed) return retval;

                    pushFollow(FOLLOW_statOrImplicitBlock_in_condExStat1057);
                    es=statOrImplicitBlock();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { elseStat = es; }

                    }
                    break;

            }


            match(input,67,FOLLOW_67_in_condExStat1069); if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n = new ASTConditionalExecutionStatement(((Token)retval.start), con, ts, elseStat); }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "condExStat"


    public static class iterStat_return extends ParserRuleReturnScope {
        public ASTIterationStatement n;
    };


    // $ANTLR start "iterStat"
    // Soil.g:371:1: iterStat returns [ASTIterationStatement n] : 'for' var= IDENT 'in' set= inSoilExpression 'do' s= statOrImplicitBlock 'end' ;
    public final SoilParser.iterStat_return iterStat() throws RecognitionException {
        SoilParser.iterStat_return retval = new SoilParser.iterStat_return();
        retval.start = input.LT(1);


        Token var=null;
        ASTExpression set =null;

        ASTStatement s =null;


        try {
            // Soil.g:372:3: ( 'for' var= IDENT 'in' set= inSoilExpression 'do' s= statOrImplicitBlock 'end' )
            // Soil.g:373:3: 'for' var= IDENT 'in' set= inSoilExpression 'do' s= statOrImplicitBlock 'end'
            {
            match(input,71,FOLLOW_71_in_iterStat1094); if (state.failed) return retval;

            var=(Token)match(input,IDENT,FOLLOW_IDENT_in_iterStat1102); if (state.failed) return retval;

            match(input,75,FOLLOW_75_in_iterStat1106); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_iterStat1114);
            set=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            match(input,65,FOLLOW_65_in_iterStat1118); if (state.failed) return retval;

            pushFollow(FOLLOW_statOrImplicitBlock_in_iterStat1126);
            s=statOrImplicitBlock();

            state._fsp--;
            if (state.failed) return retval;

            match(input,67,FOLLOW_67_in_iterStat1131); if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n = new ASTIterationStatement(((Token)retval.start), (var!=null?var.getText():null), set, s); }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "iterStat"


    public static class whileStat_return extends ParserRuleReturnScope {
        public ASTWhileStatement n;
    };


    // $ANTLR start "whileStat"
    // Soil.g:388:1: whileStat returns [ASTWhileStatement n] : 'while' cond= inSoilExpression 'do' s= statOrImplicitBlock 'end' ;
    public final SoilParser.whileStat_return whileStat() throws RecognitionException {
        SoilParser.whileStat_return retval = new SoilParser.whileStat_return();
        retval.start = input.LT(1);


        ASTExpression cond =null;

        ASTStatement s =null;


        try {
            // Soil.g:389:3: ( 'while' cond= inSoilExpression 'do' s= statOrImplicitBlock 'end' )
            // Soil.g:390:3: 'while' cond= inSoilExpression 'do' s= statOrImplicitBlock 'end'
            {
            match(input,95,FOLLOW_95_in_whileStat1157); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_whileStat1165);
            cond=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            match(input,65,FOLLOW_65_in_whileStat1169); if (state.failed) return retval;

            pushFollow(FOLLOW_statOrImplicitBlock_in_whileStat1177);
            s=statOrImplicitBlock();

            state._fsp--;
            if (state.failed) return retval;

            match(input,67,FOLLOW_67_in_whileStat1182); if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n = new ASTWhileStatement(((Token)retval.start), cond, s); }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "whileStat"


    public static class blockStat_return extends ParserRuleReturnScope {
        public ASTBlockStatement n;
    };


    // $ANTLR start "blockStat"
    // Soil.g:402:1: blockStat returns [ASTBlockStatement n] : 'begin' ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )? s= stat 'end' ;
    public final SoilParser.blockStat_return blockStat() throws RecognitionException {
        SoilParser.blockStat_return retval = new SoilParser.blockStat_return();
        retval.start = input.LT(1);


        ASTVariableDeclaration vd =null;

        ASTVariableDeclaration vd1 =null;

        SoilParser.stat_return s =null;



          retval.n = new ASTBlockStatement(((Token)retval.start), org.tzi.use.config.Options.explicitVariableDeclarations);

        try {
            // Soil.g:406:2: ( 'begin' ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )? s= stat 'end' )
            // Soil.g:407:2: 'begin' ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )? s= stat 'end'
            {
            match(input,58,FOLLOW_58_in_blockStat1212); if (state.failed) return retval;

            // Soil.g:408:2: ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==61) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Soil.g:408:4: 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI
                    {
                    match(input,61,FOLLOW_61_in_blockStat1217); if (state.failed) return retval;

                    pushFollow(FOLLOW_variableDeclaration_in_blockStat1223);
                    vd=variableDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd);}

                    // Soil.g:408:73: ( COMMA vd1= variableDeclaration )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==COMMA) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // Soil.g:408:75: COMMA vd1= variableDeclaration
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_blockStat1229); if (state.failed) return retval;

                    	    pushFollow(FOLLOW_variableDeclaration_in_blockStat1235);
                    	    vd1=variableDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd1);}

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    match(input,SEMI,FOLLOW_SEMI_in_blockStat1242); if (state.failed) return retval;

                    }
                    break;

            }


            pushFollow(FOLLOW_stat_in_blockStat1252);
            s=stat();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n.setBody((s!=null?s.n:null)); }

            match(input,67,FOLLOW_67_in_blockStat1257); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "blockStat"


    public static class implicitBlockStat_return extends ParserRuleReturnScope {
        public ASTBlockStatement n;
    };


    // $ANTLR start "implicitBlockStat"
    // Soil.g:417:1: implicitBlockStat returns [ASTBlockStatement n] : 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI s= stat ;
    public final SoilParser.implicitBlockStat_return implicitBlockStat() throws RecognitionException {
        SoilParser.implicitBlockStat_return retval = new SoilParser.implicitBlockStat_return();
        retval.start = input.LT(1);


        ASTVariableDeclaration vd =null;

        ASTVariableDeclaration vd1 =null;

        SoilParser.stat_return s =null;



          retval.n = new ASTBlockStatement(((Token)retval.start), false);

        try {
            // Soil.g:421:3: ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI s= stat )
            // Soil.g:422:3: 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI s= stat
            {
            match(input,61,FOLLOW_61_in_implicitBlockStat1283); if (state.failed) return retval;

            pushFollow(FOLLOW_variableDeclaration_in_implicitBlockStat1289);
            vd=variableDeclaration();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd);}

            // Soil.g:422:72: ( COMMA vd1= variableDeclaration )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==COMMA) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Soil.g:422:74: COMMA vd1= variableDeclaration
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_implicitBlockStat1295); if (state.failed) return retval;

            	    pushFollow(FOLLOW_variableDeclaration_in_implicitBlockStat1301);
            	    vd1=variableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd1);}

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match(input,SEMI,FOLLOW_SEMI_in_implicitBlockStat1308); if (state.failed) return retval;

            pushFollow(FOLLOW_stat_in_implicitBlockStat1316);
            s=stat();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n.setBody((s!=null?s.n:null)); }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "implicitBlockStat"



    // $ANTLR start "statOrImplicitBlock"
    // Soil.g:426:1: statOrImplicitBlock returns [ASTStatement n] : (s1= stat |s2= implicitBlockStat ) ;
    public final ASTStatement statOrImplicitBlock() throws RecognitionException {
        ASTStatement n = null;


        SoilParser.stat_return s1 =null;

        SoilParser.implicitBlockStat_return s2 =null;


        try {
            // Soil.g:427:3: ( (s1= stat |s2= implicitBlockStat ) )
            // Soil.g:428:3: (s1= stat |s2= implicitBlockStat )
            {
            // Soil.g:428:3: (s1= stat |s2= implicitBlockStat )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==AT||LA15_0==HASH||(LA15_0 >= IDENT && LA15_0 <= INT)||(LA15_0 >= LPAREN && LA15_0 <= MINUS)||LA15_0==PLUS||LA15_0==REAL||LA15_0==SEMI||(LA15_0 >= STAR && LA15_0 <= STRING)||(LA15_0 >= 44 && LA15_0 <= 55)||LA15_0==58||(LA15_0 >= 62 && LA15_0 <= 63)||(LA15_0 >= 66 && LA15_0 <= 67)||(LA15_0 >= 70 && LA15_0 <= 71)||LA15_0==73||LA15_0==76||(LA15_0 >= 78 && LA15_0 <= 88)||(LA15_0 >= 91 && LA15_0 <= 92)||(LA15_0 >= 94 && LA15_0 <= 95)) ) {
                alt15=1;
            }
            else if ( (LA15_0==61) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // Soil.g:428:4: s1= stat
                    {
                    pushFollow(FOLLOW_stat_in_statOrImplicitBlock1339);
                    s1=stat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (s1!=null?s1.n:null); }

                    }
                    break;
                case 2 :
                    // Soil.g:428:31: s2= implicitBlockStat
                    {
                    pushFollow(FOLLOW_implicitBlockStat_in_statOrImplicitBlock1349);
                    s2=implicitBlockStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (s2!=null?s2.n:null); }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "statOrImplicitBlock"



    // $ANTLR start "nothing"
    // Soil.g:442:1: nothing :;
    public final void nothing() throws RecognitionException {
        try {
            // Soil.g:443:1: ()
            // Soil.g:444:1: 
            {
            }

        }
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "nothing"



    // $ANTLR start "rValue"
    // Soil.g:450:1: rValue returns [ASTRValue n] : (e= inSoilExpression |oc= objCreateStat );
    public final ASTRValue rValue() throws RecognitionException {
        ASTRValue n = null;


        ASTExpression e =null;

        SoilParser.objCreateStat_return oc =null;


        try {
            // Soil.g:451:5: (e= inSoilExpression |oc= objCreateStat )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==AT||LA16_0==HASH||(LA16_0 >= IDENT && LA16_0 <= INT)||(LA16_0 >= LPAREN && LA16_0 <= MINUS)||LA16_0==PLUS||LA16_0==REAL||(LA16_0 >= STAR && LA16_0 <= STRING)||(LA16_0 >= 44 && LA16_0 <= 55)||LA16_0==70||LA16_0==73||(LA16_0 >= 78 && LA16_0 <= 79)||(LA16_0 >= 81 && LA16_0 <= 88)||(LA16_0 >= 91 && LA16_0 <= 92)||LA16_0==94) ) {
                alt16=1;
            }
            else if ( (LA16_0==80) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // Soil.g:452:5: e= inSoilExpression
                    {
                    pushFollow(FOLLOW_inSoilExpression_in_rValue1395);
                    e=inSoilExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTRValueExpressionOrOpCall(e); }

                    }
                    break;
                case 2 :
                    // Soil.g:453:5: oc= objCreateStat
                    {
                    pushFollow(FOLLOW_objCreateStat_in_rValue1407);
                    oc=objCreateStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { 
                        if ((oc!=null?oc.n:null) instanceof ASTNewLinkObjectStatement)
                        	n = new ASTRValueNewLinkObject((ASTNewLinkObjectStatement)(oc!=null?oc.n:null));
                        else
                        	n = new ASTRValueNewObject((ASTNewObjectStatement)(oc!=null?oc.n:null));
                      }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "rValue"



    // $ANTLR start "rValList"
    // Soil.g:466:1: rValList returns [List<ASTRValue> n] : ( nothing |rl= rValListMin1 );
    public final List<ASTRValue> rValList() throws RecognitionException {
        List<ASTRValue> n = null;


        List<ASTRValue> rl =null;


        try {
            // Soil.g:467:3: ( nothing |rl= rValListMin1 )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RBRACE) ) {
                alt17=1;
            }
            else if ( (LA17_0==AT||LA17_0==HASH||(LA17_0 >= IDENT && LA17_0 <= INT)||(LA17_0 >= LPAREN && LA17_0 <= MINUS)||LA17_0==PLUS||LA17_0==REAL||(LA17_0 >= STAR && LA17_0 <= STRING)||(LA17_0 >= 44 && LA17_0 <= 55)||LA17_0==70||LA17_0==73||(LA17_0 >= 78 && LA17_0 <= 88)||(LA17_0 >= 91 && LA17_0 <= 92)||LA17_0==94) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // Soil.g:468:3: nothing
                    {
                    pushFollow(FOLLOW_nothing_in_rValList1430);
                    nothing();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = Collections.<ASTRValue>emptyList(); }

                    }
                    break;
                case 2 :
                    // Soil.g:471:3: rl= rValListMin1
                    {
                    pushFollow(FOLLOW_rValListMin1_in_rValList1457);
                    rl=rValListMin1();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = rl; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "rValList"



    // $ANTLR start "rValListMin1"
    // Soil.g:479:1: rValListMin1 returns [List<ASTRValue> n] : r= rValue ( COMMA r= rValue )* ;
    public final List<ASTRValue> rValListMin1() throws RecognitionException {
        List<ASTRValue> n = null;


        ASTRValue r =null;



          n = new ArrayList<ASTRValue>();

        try {
            // Soil.g:483:3: (r= rValue ( COMMA r= rValue )* )
            // Soil.g:484:3: r= rValue ( COMMA r= rValue )*
            {
            pushFollow(FOLLOW_rValue_in_rValListMin11490);
            r=rValue();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add(r); }

            // Soil.g:486:3: ( COMMA r= rValue )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==COMMA) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Soil.g:487:5: COMMA r= rValue
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_rValListMin11504); if (state.failed) return n;

            	    pushFollow(FOLLOW_rValue_in_rValListMin11514);
            	    r=rValue();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n.add(r); }

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "rValListMin1"



    // $ANTLR start "rValListMin2"
    // Soil.g:497:1: rValListMin2 returns [List<ASTRValue> n] : r= rValue COMMA r= rValue ( COMMA r= rValue )* ;
    public final List<ASTRValue> rValListMin2() throws RecognitionException {
        List<ASTRValue> n = null;


        ASTRValue r =null;



          n = new ArrayList<ASTRValue>();

        try {
            // Soil.g:501:3: (r= rValue COMMA r= rValue ( COMMA r= rValue )* )
            // Soil.g:502:3: r= rValue COMMA r= rValue ( COMMA r= rValue )*
            {
            pushFollow(FOLLOW_rValue_in_rValListMin21553);
            r=rValue();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add(r); }

            match(input,COMMA,FOLLOW_COMMA_in_rValListMin21561); if (state.failed) return n;

            pushFollow(FOLLOW_rValue_in_rValListMin21569);
            r=rValue();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add(r); }

            // Soil.g:507:3: ( COMMA r= rValue )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMMA) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // Soil.g:508:5: COMMA r= rValue
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_rValListMin21583); if (state.failed) return n;

            	    pushFollow(FOLLOW_rValue_in_rValListMin21593);
            	    r=rValue();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n.add(r); }

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "rValListMin2"



    // $ANTLR start "inSoilExpression"
    // Soil.g:518:1: inSoilExpression returns [ASTExpression n] : e= expression ;
    public final ASTExpression inSoilExpression() throws RecognitionException {
        ASTExpression n = null;


        SoilParser.expression_return e =null;


        try {
            // Soil.g:519:3: (e= expression )
            // Soil.g:520:3: e= expression
            {
            pushFollow(FOLLOW_expression_in_inSoilExpression1627);
            e=expression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { if ((e!=null?e.n:null) != null) (e!=null?e.n:null).setStringRep((e!=null?input.toString(e.start,e.stop):null)); }

            if ( state.backtracking==0 ) { n = (e!=null?e.n:null); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "inSoilExpression"



    // $ANTLR start "exprList"
    // Soil.g:529:1: exprList returns [List<ASTExpression> n] : ( nothing |el= exprListMin1 );
    public final List<ASTExpression> exprList() throws RecognitionException {
        List<ASTExpression> n = null;


        List<ASTExpression> el =null;


        try {
            // Soil.g:530:3: ( nothing |el= exprListMin1 )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==EOF) ) {
                alt20=1;
            }
            else if ( (LA20_0==AT||LA20_0==HASH||(LA20_0 >= IDENT && LA20_0 <= INT)||(LA20_0 >= LPAREN && LA20_0 <= MINUS)||LA20_0==PLUS||LA20_0==REAL||(LA20_0 >= STAR && LA20_0 <= STRING)||(LA20_0 >= 44 && LA20_0 <= 55)||LA20_0==70||LA20_0==73||(LA20_0 >= 78 && LA20_0 <= 79)||(LA20_0 >= 81 && LA20_0 <= 88)||(LA20_0 >= 91 && LA20_0 <= 92)||LA20_0==94) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // Soil.g:531:3: nothing
                    {
                    pushFollow(FOLLOW_nothing_in_exprList1656);
                    nothing();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ArrayList<ASTExpression>(); }

                    }
                    break;
                case 2 :
                    // Soil.g:534:3: el= exprListMin1
                    {
                    pushFollow(FOLLOW_exprListMin1_in_exprList1674);
                    el=exprListMin1();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = el; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "exprList"



    // $ANTLR start "exprListMin1"
    // Soil.g:542:1: exprListMin1 returns [List<ASTExpression> n] : e= inSoilExpression ( COMMA e= inSoilExpression )* ;
    public final List<ASTExpression> exprListMin1() throws RecognitionException {
        List<ASTExpression> n = null;


        ASTExpression e =null;



          n = new ArrayList<ASTExpression>();

        try {
            // Soil.g:546:3: (e= inSoilExpression ( COMMA e= inSoilExpression )* )
            // Soil.g:547:3: e= inSoilExpression ( COMMA e= inSoilExpression )*
            {
            pushFollow(FOLLOW_inSoilExpression_in_exprListMin11707);
            e=inSoilExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            // Soil.g:549:3: ( COMMA e= inSoilExpression )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMMA) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Soil.g:550:5: COMMA e= inSoilExpression
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_exprListMin11722); if (state.failed) return n;

            	    pushFollow(FOLLOW_inSoilExpression_in_exprListMin11732);
            	    e=inSoilExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "exprListMin1"



    // $ANTLR start "exprListMin2"
    // Soil.g:560:1: exprListMin2 returns [List<ASTExpression> n] : e= inSoilExpression COMMA e= inSoilExpression ( COMMA e= inSoilExpression )* ;
    public final List<ASTExpression> exprListMin2() throws RecognitionException {
        List<ASTExpression> n = null;


        ASTExpression e =null;



          n = new ArrayList<ASTExpression>();

        try {
            // Soil.g:564:3: (e= inSoilExpression COMMA e= inSoilExpression ( COMMA e= inSoilExpression )* )
            // Soil.g:565:3: e= inSoilExpression COMMA e= inSoilExpression ( COMMA e= inSoilExpression )*
            {
            pushFollow(FOLLOW_inSoilExpression_in_exprListMin21772);
            e=inSoilExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            match(input,COMMA,FOLLOW_COMMA_in_exprListMin21780); if (state.failed) return n;

            pushFollow(FOLLOW_inSoilExpression_in_exprListMin21788);
            e=inSoilExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            // Soil.g:570:3: ( COMMA e= inSoilExpression )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==COMMA) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // Soil.g:571:5: COMMA e= inSoilExpression
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_exprListMin21802); if (state.failed) return n;

            	    pushFollow(FOLLOW_inSoilExpression_in_exprListMin21812);
            	    e=inSoilExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "exprListMin2"



    // $ANTLR start "identList"
    // Soil.g:581:1: identList returns [List<String> n] : ( nothing |il= identListMin1 );
    public final List<String> identList() throws RecognitionException {
        List<String> n = null;


        List<String> il =null;


        try {
            // Soil.g:582:3: ( nothing |il= identListMin1 )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==EOF||LA23_0==RBRACE||LA23_0==SEMI||(LA23_0 >= 66 && LA23_0 <= 67)) ) {
                alt23=1;
            }
            else if ( (LA23_0==IDENT) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // Soil.g:583:3: nothing
                    {
                    pushFollow(FOLLOW_nothing_in_identList1842);
                    nothing();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ArrayList<String>(); }

                    }
                    break;
                case 2 :
                    // Soil.g:586:3: il= identListMin1
                    {
                    pushFollow(FOLLOW_identListMin1_in_identList1859);
                    il=identListMin1();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = il; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "identList"



    // $ANTLR start "identListMin1"
    // Soil.g:594:1: identListMin1 returns [List<String> n] : id= IDENT ( COMMA id= IDENT )* ;
    public final List<String> identListMin1() throws RecognitionException {
        List<String> n = null;


        Token id=null;


          n = new ArrayList<String>();

        try {
            // Soil.g:598:3: (id= IDENT ( COMMA id= IDENT )* )
            // Soil.g:599:3: id= IDENT ( COMMA id= IDENT )*
            {
            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_identListMin11893); if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add((id!=null?id.getText():null)); }

            // Soil.g:601:3: ( COMMA id= IDENT )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==COMMA) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // Soil.g:602:5: COMMA id= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_identListMin11907); if (state.failed) return n;

            	    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_identListMin11917); if (state.failed) return n;

            	    if ( state.backtracking==0 ) {
            	        n.add((id!=null?id.getText():null)); }

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "identListMin1"



    // $ANTLR start "expressionOnly"
    // Soil.g:639:1: expressionOnly returns [ASTExpression n] : nExp= expression EOF ;
    public final ASTExpression expressionOnly() throws RecognitionException {
        ASTExpression n = null;


        SoilParser.expression_return nExp =null;


        try {
            // Soil.g:640:5: (nExp= expression EOF )
            // Soil.g:641:5: nExp= expression EOF
            {
            pushFollow(FOLLOW_expression_in_expressionOnly1957);
            nExp=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,EOF,FOLLOW_EOF_in_expressionOnly1959); if (state.failed) return n;

            if ( state.backtracking==0 ) {n = (nExp!=null?nExp.n:null);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "expressionOnly"


    public static class expression_return extends ParserRuleReturnScope {
        public ASTExpression n;
    };


    // $ANTLR start "expression"
    // Soil.g:648:1: expression returns [ASTExpression n] : ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )* nIdExp= identicalExpression ;
    public final SoilParser.expression_return expression() throws RecognitionException {
        SoilParser.expression_return retval = new SoilParser.expression_return();
        retval.start = input.LT(1);


        Token name=null;
        ASTType t =null;

        SoilParser.expression_return e1 =null;

        ASTExpression nIdExp =null;


         
          ASTLetExpression prevLet = null, firstLet = null;
          ASTExpression e2;
          Token tok = null;

        try {
            // Soil.g:654:5: ( ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )* nIdExp= identicalExpression )
            // Soil.g:655:5: ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )* nIdExp= identicalExpression
            {
            if ( state.backtracking==0 ) { tok = input.LT(1); /* remember start of expression */ }

            // Soil.g:656:5: ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==79) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // Soil.g:657:7: 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in'
            	    {
            	    match(input,79,FOLLOW_79_in_expression2007); if (state.failed) return retval;

            	    name=(Token)match(input,IDENT,FOLLOW_IDENT_in_expression2018); if (state.failed) return retval;

            	    // Soil.g:658:18: ( COLON t= type )?
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==COLON) ) {
            	        alt25=1;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // Soil.g:658:20: COLON t= type
            	            {
            	            match(input,COLON,FOLLOW_COLON_in_expression2022); if (state.failed) return retval;

            	            pushFollow(FOLLOW_type_in_expression2026);
            	            t=type();

            	            state._fsp--;
            	            if (state.failed) return retval;

            	            }
            	            break;

            	    }


            	    match(input,EQUAL,FOLLOW_EQUAL_in_expression2031); if (state.failed) return retval;

            	    pushFollow(FOLLOW_expression_in_expression2035);
            	    e1=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { ASTLetExpression nextLet = new ASTLetExpression(name, t, (e1!=null?e1.n:null));
            	             if ( firstLet == null ) 
            	                 firstLet = nextLet;
            	             if ( prevLet != null ) 
            	                 prevLet.setInExpr(nextLet);
            	             prevLet = nextLet;
            	          }

            	    // Soil.g:668:7: ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )*
            	    loop27:
            	    do {
            	        int alt27=2;
            	        int LA27_0 = input.LA(1);

            	        if ( (LA27_0==COMMA) ) {
            	            alt27=1;
            	        }


            	        switch (alt27) {
            	    	case 1 :
            	    	    // Soil.g:669:7: COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression
            	    	    {
            	    	    match(input,COMMA,FOLLOW_COMMA_in_expression2073); if (state.failed) return retval;

            	    	    name=(Token)match(input,IDENT,FOLLOW_IDENT_in_expression2085); if (state.failed) return retval;

            	    	    // Soil.g:670:20: ( COLON t= type )?
            	    	    int alt26=2;
            	    	    int LA26_0 = input.LA(1);

            	    	    if ( (LA26_0==COLON) ) {
            	    	        alt26=1;
            	    	    }
            	    	    switch (alt26) {
            	    	        case 1 :
            	    	            // Soil.g:670:22: COLON t= type
            	    	            {
            	    	            match(input,COLON,FOLLOW_COLON_in_expression2089); if (state.failed) return retval;

            	    	            pushFollow(FOLLOW_type_in_expression2093);
            	    	            t=type();

            	    	            state._fsp--;
            	    	            if (state.failed) return retval;

            	    	            }
            	    	            break;

            	    	    }


            	    	    match(input,EQUAL,FOLLOW_EQUAL_in_expression2098); if (state.failed) return retval;

            	    	    pushFollow(FOLLOW_expression_in_expression2102);
            	    	    e1=expression();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;

            	    	    if ( state.backtracking==0 ) { ASTLetExpression nextLet = new ASTLetExpression(name, t, (e1!=null?e1.n:null));
            	    	               if ( firstLet == null ) 
            	    	                   firstLet = nextLet;
            	    	               if ( prevLet != null ) 
            	    	                   prevLet.setInExpr(nextLet);
            	    	               prevLet = nextLet;
            	    	            }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop27;
            	        }
            	    } while (true);


            	    match(input,75,FOLLOW_75_in_expression2143); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            pushFollow(FOLLOW_identicalExpression_in_expression2159);
            nIdExp=identicalExpression();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { if ( nIdExp != null ) {
                	 retval.n = nIdExp;
                     retval.n.setStartToken(tok);
                  }
                  
                  if ( prevLet != null ) { 
                     prevLet.setInExpr(retval.n);
                     retval.n = firstLet;
                     retval.n.setStartToken(tok);
                  }
                }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"



    // $ANTLR start "paramList"
    // Soil.g:702:1: paramList returns [List<ASTVariableDeclaration> paramList] : LPAREN (v= variableDeclaration ( COMMA v= variableDeclaration )* )? RPAREN ;
    public final List<ASTVariableDeclaration> paramList() throws RecognitionException {
        List<ASTVariableDeclaration> paramList = null;


        ASTVariableDeclaration v =null;


         paramList = new ArrayList<ASTVariableDeclaration>(); 
        try {
            // Soil.g:704:5: ( LPAREN (v= variableDeclaration ( COMMA v= variableDeclaration )* )? RPAREN )
            // Soil.g:705:5: LPAREN (v= variableDeclaration ( COMMA v= variableDeclaration )* )? RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_paramList2192); if (state.failed) return paramList;

            // Soil.g:706:5: (v= variableDeclaration ( COMMA v= variableDeclaration )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==IDENT) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // Soil.g:707:7: v= variableDeclaration ( COMMA v= variableDeclaration )*
                    {
                    pushFollow(FOLLOW_variableDeclaration_in_paramList2209);
                    v=variableDeclaration();

                    state._fsp--;
                    if (state.failed) return paramList;

                    if ( state.backtracking==0 ) { paramList.add(v); }

                    // Soil.g:708:7: ( COMMA v= variableDeclaration )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==COMMA) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // Soil.g:708:9: COMMA v= variableDeclaration
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_paramList2221); if (state.failed) return paramList;

                    	    pushFollow(FOLLOW_variableDeclaration_in_paramList2225);
                    	    v=variableDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return paramList;

                    	    if ( state.backtracking==0 ) { paramList.add(v); }

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_paramList2245); if (state.failed) return paramList;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return paramList;
    }
    // $ANTLR end "paramList"



    // $ANTLR start "idList"
    // Soil.g:716:1: idList returns [List idList] : id0= IDENT ( COMMA idn= IDENT )* ;
    public final List idList() throws RecognitionException {
        List idList = null;


        Token id0=null;
        Token idn=null;

         idList = new ArrayList(); 
        try {
            // Soil.g:718:5: (id0= IDENT ( COMMA idn= IDENT )* )
            // Soil.g:719:5: id0= IDENT ( COMMA idn= IDENT )*
            {
            id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_idList2274); if (state.failed) return idList;

            if ( state.backtracking==0 ) { idList.add(id0); }

            // Soil.g:720:5: ( COMMA idn= IDENT )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==COMMA) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // Soil.g:720:7: COMMA idn= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_idList2284); if (state.failed) return idList;

            	    idn=(Token)match(input,IDENT,FOLLOW_IDENT_in_idList2288); if (state.failed) return idList;

            	    if ( state.backtracking==0 ) { idList.add(idn); }

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return idList;
    }
    // $ANTLR end "idList"



    // $ANTLR start "variableDeclaration"
    // Soil.g:728:1: variableDeclaration returns [ASTVariableDeclaration n] : name= IDENT COLON t= type ;
    public final ASTVariableDeclaration variableDeclaration() throws RecognitionException {
        ASTVariableDeclaration n = null;


        Token name=null;
        ASTType t =null;


        try {
            // Soil.g:729:5: (name= IDENT COLON t= type )
            // Soil.g:730:5: name= IDENT COLON t= type
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_variableDeclaration2319); if (state.failed) return n;

            match(input,COLON,FOLLOW_COLON_in_variableDeclaration2321); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_variableDeclaration2325);
            t=type();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTVariableDeclaration(name, t); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "variableDeclaration"



    // $ANTLR start "identicalExpression"
    // Soil.g:738:1: identicalExpression returns [ASTExpression n] : conImpExp= conditionalImpliesExpression ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )* ;
    public final ASTExpression identicalExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression conImpExp =null;

        ASTExpression n1 =null;


        try {
            // Soil.g:739:5: (conImpExp= conditionalImpliesExpression ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )* )
            // Soil.g:740:5: conImpExp= conditionalImpliesExpression ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )*
            {
            pushFollow(FOLLOW_conditionalImpliesExpression_in_identicalExpression2356);
            conImpExp=conditionalImpliesExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = conImpExp; }

            // Soil.g:741:5: ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==DOT) ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==69) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // Soil.g:742:9: DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_identicalExpression2374); if (state.failed) return n;

            	    op=(Token)match(input,69,FOLLOW_69_in_identicalExpression2378); if (state.failed) return n;

            	    match(input,LPAREN,FOLLOW_LPAREN_in_identicalExpression2380); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalImpliesExpression_in_identicalExpression2384);
            	    n1=conditionalImpliesExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    match(input,RPAREN,FOLLOW_RPAREN_in_identicalExpression2386); if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "identicalExpression"



    // $ANTLR start "conditionalImpliesExpression"
    // Soil.g:751:1: conditionalImpliesExpression returns [ASTExpression n] : nCndOrExp= conditionalOrExpression (op= 'implies' n1= conditionalOrExpression )* ;
    public final ASTExpression conditionalImpliesExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nCndOrExp =null;

        ASTExpression n1 =null;


        try {
            // Soil.g:752:5: (nCndOrExp= conditionalOrExpression (op= 'implies' n1= conditionalOrExpression )* )
            // Soil.g:753:5: nCndOrExp= conditionalOrExpression (op= 'implies' n1= conditionalOrExpression )*
            {
            pushFollow(FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression2429);
            nCndOrExp=conditionalOrExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nCndOrExp;}

            // Soil.g:754:5: (op= 'implies' n1= conditionalOrExpression )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==74) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // Soil.g:754:7: op= 'implies' n1= conditionalOrExpression
            	    {
            	    op=(Token)match(input,74,FOLLOW_74_in_conditionalImpliesExpression2442); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression2446);
            	    n1=conditionalOrExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "conditionalImpliesExpression"



    // $ANTLR start "conditionalOrExpression"
    // Soil.g:763:1: conditionalOrExpression returns [ASTExpression n] : nCndXorExp= conditionalXOrExpression (op= 'or' n1= conditionalXOrExpression )* ;
    public final ASTExpression conditionalOrExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nCndXorExp =null;

        ASTExpression n1 =null;


        try {
            // Soil.g:764:5: (nCndXorExp= conditionalXOrExpression (op= 'or' n1= conditionalXOrExpression )* )
            // Soil.g:765:5: nCndXorExp= conditionalXOrExpression (op= 'or' n1= conditionalXOrExpression )*
            {
            pushFollow(FOLLOW_conditionalXOrExpression_in_conditionalOrExpression2491);
            nCndXorExp=conditionalXOrExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nCndXorExp;}

            // Soil.g:766:5: (op= 'or' n1= conditionalXOrExpression )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==89) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Soil.g:766:7: op= 'or' n1= conditionalXOrExpression
            	    {
            	    op=(Token)match(input,89,FOLLOW_89_in_conditionalOrExpression2504); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalXOrExpression_in_conditionalOrExpression2508);
            	    n1=conditionalXOrExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "conditionalOrExpression"



    // $ANTLR start "conditionalXOrExpression"
    // Soil.g:775:1: conditionalXOrExpression returns [ASTExpression n] : nCndAndExp= conditionalAndExpression (op= 'xor' n1= conditionalAndExpression )* ;
    public final ASTExpression conditionalXOrExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nCndAndExp =null;

        ASTExpression n1 =null;


        try {
            // Soil.g:776:5: (nCndAndExp= conditionalAndExpression (op= 'xor' n1= conditionalAndExpression )* )
            // Soil.g:777:5: nCndAndExp= conditionalAndExpression (op= 'xor' n1= conditionalAndExpression )*
            {
            pushFollow(FOLLOW_conditionalAndExpression_in_conditionalXOrExpression2552);
            nCndAndExp=conditionalAndExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nCndAndExp;}

            // Soil.g:778:5: (op= 'xor' n1= conditionalAndExpression )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==96) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // Soil.g:778:7: op= 'xor' n1= conditionalAndExpression
            	    {
            	    op=(Token)match(input,96,FOLLOW_96_in_conditionalXOrExpression2565); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalAndExpression_in_conditionalXOrExpression2569);
            	    n1=conditionalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "conditionalXOrExpression"



    // $ANTLR start "conditionalAndExpression"
    // Soil.g:787:1: conditionalAndExpression returns [ASTExpression n] : nEqExp= equalityExpression (op= 'and' n1= equalityExpression )* ;
    public final ASTExpression conditionalAndExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nEqExp =null;

        ASTExpression n1 =null;


        try {
            // Soil.g:788:5: (nEqExp= equalityExpression (op= 'and' n1= equalityExpression )* )
            // Soil.g:789:5: nEqExp= equalityExpression (op= 'and' n1= equalityExpression )*
            {
            pushFollow(FOLLOW_equalityExpression_in_conditionalAndExpression2613);
            nEqExp=equalityExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nEqExp;}

            // Soil.g:790:5: (op= 'and' n1= equalityExpression )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==57) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // Soil.g:790:7: op= 'and' n1= equalityExpression
            	    {
            	    op=(Token)match(input,57,FOLLOW_57_in_conditionalAndExpression2626); if (state.failed) return n;

            	    pushFollow(FOLLOW_equalityExpression_in_conditionalAndExpression2630);
            	    n1=equalityExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "conditionalAndExpression"



    // $ANTLR start "equalityExpression"
    // Soil.g:799:1: equalityExpression returns [ASTExpression n] : nRelExp= relationalExpression ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )* ;
    public final ASTExpression equalityExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nRelExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // Soil.g:801:5: (nRelExp= relationalExpression ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )* )
            // Soil.g:802:5: nRelExp= relationalExpression ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )*
            {
            pushFollow(FOLLOW_relationalExpression_in_equalityExpression2678);
            nRelExp=relationalExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nRelExp;}

            // Soil.g:803:5: ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==EQUAL||LA37_0==NOT_EQUAL) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // Soil.g:803:7: ( EQUAL | NOT_EQUAL ) n1= relationalExpression
            	    {
            	    if ( state.backtracking==0 ) { op = input.LT(1); }

            	    if ( input.LA(1)==EQUAL||input.LA(1)==NOT_EQUAL ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return n;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression2707);
            	    n1=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "equalityExpression"



    // $ANTLR start "relationalExpression"
    // Soil.g:813:1: relationalExpression returns [ASTExpression n] : nAddiExp= additiveExpression ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )* ;
    public final ASTExpression relationalExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nAddiExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // Soil.g:815:5: (nAddiExp= additiveExpression ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )* )
            // Soil.g:816:5: nAddiExp= additiveExpression ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )*
            {
            pushFollow(FOLLOW_additiveExpression_in_relationalExpression2756);
            nAddiExp=additiveExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nAddiExp;}

            // Soil.g:817:5: ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0 >= GREATER && LA38_0 <= GREATER_EQUAL)||(LA38_0 >= LESS && LA38_0 <= LESS_EQUAL)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // Soil.g:817:7: ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression
            	    {
            	    if ( state.backtracking==0 ) { op = input.LT(1); }

            	    if ( (input.LA(1) >= GREATER && input.LA(1) <= GREATER_EQUAL)||(input.LA(1) >= LESS && input.LA(1) <= LESS_EQUAL) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return n;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_additiveExpression_in_relationalExpression2792);
            	    n1=additiveExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "relationalExpression"



    // $ANTLR start "additiveExpression"
    // Soil.g:827:1: additiveExpression returns [ASTExpression n] : nMulExp= multiplicativeExpression ( ( PLUS | MINUS ) n1= multiplicativeExpression )* ;
    public final ASTExpression additiveExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nMulExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // Soil.g:829:5: (nMulExp= multiplicativeExpression ( ( PLUS | MINUS ) n1= multiplicativeExpression )* )
            // Soil.g:830:5: nMulExp= multiplicativeExpression ( ( PLUS | MINUS ) n1= multiplicativeExpression )*
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression2842);
            nMulExp=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nMulExp;}

            // Soil.g:831:5: ( ( PLUS | MINUS ) n1= multiplicativeExpression )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==MINUS||LA39_0==PLUS) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // Soil.g:831:7: ( PLUS | MINUS ) n1= multiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) { op = input.LT(1); }

            	    if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return n;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression2870);
            	    n1=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "additiveExpression"



    // $ANTLR start "multiplicativeExpression"
    // Soil.g:842:1: multiplicativeExpression returns [ASTExpression n] : nUnExp= unaryExpression ( ( STAR | SLASH | 'div' ) n1= unaryExpression )* ;
    public final ASTExpression multiplicativeExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nUnExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // Soil.g:844:5: (nUnExp= unaryExpression ( ( STAR | SLASH | 'div' ) n1= unaryExpression )* )
            // Soil.g:845:5: nUnExp= unaryExpression ( ( STAR | SLASH | 'div' ) n1= unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression2920);
            nUnExp=unaryExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n = nUnExp;}

            // Soil.g:846:5: ( ( STAR | SLASH | 'div' ) n1= unaryExpression )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==SLASH||LA40_0==STAR||LA40_0==64) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // Soil.g:846:7: ( STAR | SLASH | 'div' ) n1= unaryExpression
            	    {
            	    if ( state.backtracking==0 ) { op = input.LT(1); }

            	    if ( input.LA(1)==SLASH||input.LA(1)==STAR||input.LA(1)==64 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return n;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression2952);
            	    n1=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "multiplicativeExpression"



    // $ANTLR start "unaryExpression"
    // Soil.g:858:1: unaryExpression returns [ASTExpression n] : ( ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression ) |nPosExp= postfixExpression );
    public final ASTExpression unaryExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nUnExp =null;

        ASTExpression nPosExp =null;


         Token op = null; 
        try {
            // Soil.g:860:7: ( ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression ) |nPosExp= postfixExpression )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==MINUS||LA41_0==PLUS||LA41_0==81) ) {
                alt41=1;
            }
            else if ( (LA41_0==AT||LA41_0==HASH||(LA41_0 >= IDENT && LA41_0 <= INT)||LA41_0==LPAREN||LA41_0==REAL||(LA41_0 >= STAR && LA41_0 <= STRING)||(LA41_0 >= 44 && LA41_0 <= 55)||LA41_0==70||LA41_0==73||LA41_0==78||(LA41_0 >= 82 && LA41_0 <= 88)||(LA41_0 >= 91 && LA41_0 <= 92)||LA41_0==94) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // Soil.g:861:7: ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression )
                    {
                    // Soil.g:861:7: ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression )
                    // Soil.g:861:9: ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression
                    {
                    if ( state.backtracking==0 ) { op = input.LT(1); }

                    if ( input.LA(1)==MINUS||input.LA(1)==PLUS||input.LA(1)==81 ) {
                        input.consume();
                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression3038);
                    nUnExp=unaryExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUnaryExpression(op, nUnExp); }

                    }


                    }
                    break;
                case 2 :
                    // Soil.g:865:7: nPosExp= postfixExpression
                    {
                    pushFollow(FOLLOW_postfixExpression_in_unaryExpression3058);
                    nPosExp=postfixExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nPosExp; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "unaryExpression"



    // $ANTLR start "postfixExpression"
    // Soil.g:873:1: postfixExpression returns [ASTExpression n] : nPrimExp= primaryExpression ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )* ;
    public final ASTExpression postfixExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nPrimExp =null;

        ASTExpression nPc =null;


         boolean arrow = false; 
        try {
            // Soil.g:875:5: (nPrimExp= primaryExpression ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )* )
            // Soil.g:876:5: nPrimExp= primaryExpression ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )*
            {
            pushFollow(FOLLOW_primaryExpression_in_postfixExpression3091);
            nPrimExp=primaryExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n = nPrimExp; }

            // Soil.g:877:5: ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==DOT) ) {
                    int LA43_2 = input.LA(2);

                    if ( (LA43_2==IDENT) ) {
                        int LA43_4 = input.LA(3);

                        if ( (LA43_4==EOF||(LA43_4 >= ARROW && LA43_4 <= BAR)||(LA43_4 >= COMMA && LA43_4 <= EQUAL)||(LA43_4 >= GREATER && LA43_4 <= GREATER_EQUAL)||(LA43_4 >= LBRACE && LA43_4 <= MINUS)||(LA43_4 >= NOT_EQUAL && LA43_4 <= PLUS)||(LA43_4 >= RBRACE && LA43_4 <= RBRACK)||(LA43_4 >= RPAREN && LA43_4 <= SLASH)||LA43_4==STAR||LA43_4==57||(LA43_4 >= 64 && LA43_4 <= 68)||(LA43_4 >= 74 && LA43_4 <= 75)||LA43_4==89||LA43_4==93||LA43_4==96) ) {
                            alt43=1;
                        }


                    }
                    else if ( (LA43_2==78||LA43_2==83||(LA43_2 >= 85 && LA43_2 <= 87)||(LA43_2 >= 91 && LA43_2 <= 92)) ) {
                        alt43=1;
                    }


                }
                else if ( (LA43_0==ARROW) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // Soil.g:878:6: ( ARROW | DOT ) nPc= propertyCall[$n, arrow]
            	    {
            	    // Soil.g:878:6: ( ARROW | DOT )
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==ARROW) ) {
            	        alt42=1;
            	    }
            	    else if ( (LA42_0==DOT) ) {
            	        alt42=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return n;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // Soil.g:878:8: ARROW
            	            {
            	            match(input,ARROW,FOLLOW_ARROW_in_postfixExpression3109); if (state.failed) return n;

            	            if ( state.backtracking==0 ) { arrow = true; }

            	            }
            	            break;
            	        case 2 :
            	            // Soil.g:878:34: DOT
            	            {
            	            match(input,DOT,FOLLOW_DOT_in_postfixExpression3115); if (state.failed) return n;

            	            if ( state.backtracking==0 ) { arrow = false; }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_propertyCall_in_postfixExpression3126);
            	    nPc=propertyCall(n, arrow);

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = nPc; }

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "postfixExpression"



    // $ANTLR start "primaryExpression"
    // Soil.g:894:1: primaryExpression returns [ASTExpression n] : (nLit= literal |nOr= objectReference |nPc= propertyCall[null, false] | LPAREN nExp= expression RPAREN |nIfExp= ifExpression |id1= IDENT DOT 'allInstances' ( AT 'pre' )? ( LPAREN RPAREN )? |id2= IDENT DOT 'byUseId' ( LPAREN idExp= expression RPAREN ) ( AT 'pre' )? );
    public final ASTExpression primaryExpression() throws RecognitionException {
        ASTExpression n = null;


        Token id1=null;
        Token id2=null;
        ASTExpression nLit =null;

        ASTExpression nOr =null;

        ASTExpression nPc =null;

        SoilParser.expression_return nExp =null;

        ASTExpression nIfExp =null;

        SoilParser.expression_return idExp =null;


        try {
            // Soil.g:895:7: (nLit= literal |nOr= objectReference |nPc= propertyCall[null, false] | LPAREN nExp= expression RPAREN |nIfExp= ifExpression |id1= IDENT DOT 'allInstances' ( AT 'pre' )? ( LPAREN RPAREN )? |id2= IDENT DOT 'byUseId' ( LPAREN idExp= expression RPAREN ) ( AT 'pre' )? )
            int alt47=7;
            switch ( input.LA(1) ) {
            case HASH:
            case INT:
            case REAL:
            case STAR:
            case STRING:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 70:
            case 82:
            case 84:
            case 88:
            case 94:
                {
                alt47=1;
                }
                break;
            case IDENT:
                {
                switch ( input.LA(2) ) {
                case COLON_COLON:
                    {
                    alt47=1;
                    }
                    break;
                case EOF:
                case ARROW:
                case AT:
                case BAR:
                case COMMA:
                case DOTDOT:
                case EQUAL:
                case GREATER:
                case GREATER_EQUAL:
                case LBRACE:
                case LBRACK:
                case LESS:
                case LESS_EQUAL:
                case LPAREN:
                case MINUS:
                case NOT_EQUAL:
                case PLUS:
                case RBRACE:
                case RBRACK:
                case RPAREN:
                case SEMI:
                case SLASH:
                case STAR:
                case 57:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 74:
                case 75:
                case 89:
                case 93:
                case 96:
                    {
                    alt47=3;
                    }
                    break;
                case DOT:
                    {
                    switch ( input.LA(3) ) {
                    case 56:
                        {
                        alt47=6;
                        }
                        break;
                    case 60:
                        {
                        alt47=7;
                        }
                        break;
                    case IDENT:
                    case 69:
                    case 78:
                    case 83:
                    case 85:
                    case 86:
                    case 87:
                    case 91:
                    case 92:
                        {
                        alt47=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return n;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 7, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 2, input);

                    throw nvae;

                }

                }
                break;
            case AT:
                {
                alt47=2;
                }
                break;
            case 78:
            case 83:
            case 85:
            case 86:
            case 87:
            case 91:
            case 92:
                {
                alt47=3;
                }
                break;
            case LPAREN:
                {
                alt47=4;
                }
                break;
            case 73:
                {
                alt47=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }

            switch (alt47) {
                case 1 :
                    // Soil.g:896:7: nLit= literal
                    {
                    pushFollow(FOLLOW_literal_in_primaryExpression3166);
                    nLit=literal();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nLit; }

                    }
                    break;
                case 2 :
                    // Soil.g:897:7: nOr= objectReference
                    {
                    pushFollow(FOLLOW_objectReference_in_primaryExpression3180);
                    nOr=objectReference();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nOr; }

                    }
                    break;
                case 3 :
                    // Soil.g:898:7: nPc= propertyCall[null, false]
                    {
                    pushFollow(FOLLOW_propertyCall_in_primaryExpression3192);
                    nPc=propertyCall(null, false);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nPc; }

                    }
                    break;
                case 4 :
                    // Soil.g:899:7: LPAREN nExp= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression3203); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_primaryExpression3207);
                    nExp=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression3209); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (nExp!=null?nExp.n:null); }

                    }
                    break;
                case 5 :
                    // Soil.g:900:7: nIfExp= ifExpression
                    {
                    pushFollow(FOLLOW_ifExpression_in_primaryExpression3221);
                    nIfExp=ifExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nIfExp; }

                    }
                    break;
                case 6 :
                    // Soil.g:901:7: id1= IDENT DOT 'allInstances' ( AT 'pre' )? ( LPAREN RPAREN )?
                    {
                    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_primaryExpression3233); if (state.failed) return n;

                    match(input,DOT,FOLLOW_DOT_in_primaryExpression3235); if (state.failed) return n;

                    match(input,56,FOLLOW_56_in_primaryExpression3237); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTAllInstancesExpression(id1); }

                    // Soil.g:903:9: ( AT 'pre' )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==AT) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // Soil.g:903:11: AT 'pre'
                            {
                            match(input,AT,FOLLOW_AT_in_primaryExpression3260); if (state.failed) return n;

                            match(input,90,FOLLOW_90_in_primaryExpression3262); if (state.failed) return n;

                            if ( state.backtracking==0 ) { n.setIsPre(); }

                            }
                            break;

                    }


                    // Soil.g:904:9: ( LPAREN RPAREN )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==LPAREN) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // Soil.g:904:11: LPAREN RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression3280); if (state.failed) return n;

                            match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression3282); if (state.failed) return n;

                            }
                            break;

                    }


                    }
                    break;
                case 7 :
                    // Soil.g:905:7: id2= IDENT DOT 'byUseId' ( LPAREN idExp= expression RPAREN ) ( AT 'pre' )?
                    {
                    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_primaryExpression3295); if (state.failed) return n;

                    match(input,DOT,FOLLOW_DOT_in_primaryExpression3297); if (state.failed) return n;

                    match(input,60,FOLLOW_60_in_primaryExpression3299); if (state.failed) return n;

                    // Soil.g:905:31: ( LPAREN idExp= expression RPAREN )
                    // Soil.g:905:33: LPAREN idExp= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression3303); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_primaryExpression3307);
                    idExp=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression3309); if (state.failed) return n;

                    }


                    if ( state.backtracking==0 ) { n = new ASTObjectByUseIdExpression(id2, (idExp!=null?idExp.n:null)); }

                    // Soil.g:907:7: ( AT 'pre' )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==AT) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // Soil.g:907:9: AT 'pre'
                            {
                            match(input,AT,FOLLOW_AT_in_primaryExpression3329); if (state.failed) return n;

                            match(input,90,FOLLOW_90_in_primaryExpression3331); if (state.failed) return n;

                            if ( state.backtracking==0 ) { n.setIsPre(); }

                            }
                            break;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "primaryExpression"



    // $ANTLR start "objectReference"
    // Soil.g:911:1: objectReference returns [ASTExpression n] : AT objectName= IDENT ;
    public final ASTExpression objectReference() throws RecognitionException {
        ASTExpression n = null;


        Token objectName=null;

        try {
            // Soil.g:912:3: ( AT objectName= IDENT )
            // Soil.g:913:3: AT objectName= IDENT
            {
            match(input,AT,FOLLOW_AT_in_objectReference3357); if (state.failed) return n;

            objectName=(Token)match(input,IDENT,FOLLOW_IDENT_in_objectReference3365); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTObjectReferenceExpression(objectName); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "objectReference"



    // $ANTLR start "propertyCall"
    // Soil.g:927:1: propertyCall[ASTExpression source, boolean followsArrow] returns [ASTExpression n] : ({...}?{...}?nExpQuery= queryExpression[source] |nExpIterate= iterateExpression[source] |nExpOperation= operationExpression[source, followsArrow] |nExpType= typeExpression[source, followsArrow] |nExpInState= inStateExpression[source, followsArrow] );
    public final ASTExpression propertyCall(ASTExpression source, boolean followsArrow) throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nExpQuery =null;

        ASTExpression nExpIterate =null;

        SoilParser.operationExpression_return nExpOperation =null;

        ASTTypeArgExpression nExpType =null;

        ASTInStateExpression nExpInState =null;


        try {
            // Soil.g:928:7: ({...}?{...}?nExpQuery= queryExpression[source] |nExpIterate= iterateExpression[source] |nExpOperation= operationExpression[source, followsArrow] |nExpType= typeExpression[source, followsArrow] |nExpInState= inStateExpression[source, followsArrow] )
            int alt48=5;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA48_1 = input.LA(2);

                if ( (((( input.LA(2) == LPAREN )&&( input.LA(2) == LPAREN ))&&( org.tzi.use.parser.base.ParserHelper.isQueryIdent(input.LT(1)) ))) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;

                }
                }
                break;
            case 78:
                {
                alt48=2;
                }
                break;
            case 83:
            case 86:
            case 87:
            case 91:
            case 92:
                {
                alt48=4;
                }
                break;
            case 85:
                {
                alt48=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }

            switch (alt48) {
                case 1 :
                    // Soil.g:932:7: {...}?{...}?nExpQuery= queryExpression[source]
                    {
                    if ( !(( org.tzi.use.parser.base.ParserHelper.isQueryIdent(input.LT(1)) )) ) {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        throw new FailedPredicateException(input, "propertyCall", " org.tzi.use.parser.base.ParserHelper.isQueryIdent(input.LT(1)) ");
                    }

                    if ( !(( input.LA(2) == LPAREN )) ) {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        throw new FailedPredicateException(input, "propertyCall", " input.LA(2) == LPAREN ");
                    }

                    pushFollow(FOLLOW_queryExpression_in_propertyCall3430);
                    nExpQuery=queryExpression(source);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nExpQuery; }

                    }
                    break;
                case 2 :
                    // Soil.g:935:7: nExpIterate= iterateExpression[source]
                    {
                    pushFollow(FOLLOW_iterateExpression_in_propertyCall3443);
                    nExpIterate=iterateExpression(source);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nExpIterate; }

                    }
                    break;
                case 3 :
                    // Soil.g:936:7: nExpOperation= operationExpression[source, followsArrow]
                    {
                    pushFollow(FOLLOW_operationExpression_in_propertyCall3456);
                    nExpOperation=operationExpression(source, followsArrow);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (nExpOperation!=null?nExpOperation.n:null); }

                    }
                    break;
                case 4 :
                    // Soil.g:937:7: nExpType= typeExpression[source, followsArrow]
                    {
                    pushFollow(FOLLOW_typeExpression_in_propertyCall3469);
                    nExpType=typeExpression(source, followsArrow);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nExpType; }

                    }
                    break;
                case 5 :
                    // Soil.g:938:7: nExpInState= inStateExpression[source, followsArrow]
                    {
                    pushFollow(FOLLOW_inStateExpression_in_propertyCall3482);
                    nExpInState=inStateExpression(source, followsArrow);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nExpInState; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "propertyCall"



    // $ANTLR start "queryExpression"
    // Soil.g:947:1: queryExpression[ASTExpression range] returns [ASTExpression n] : op= IDENT LPAREN (decls= elemVarsDeclaration BAR )? nExp= expression ( COMMA uncerExp= additiveExpression )? RPAREN ;
    public final ASTExpression queryExpression(ASTExpression range) throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTElemVarsDeclaration decls =null;

        SoilParser.expression_return nExp =null;

        ASTExpression uncerExp =null;



                ASTElemVarsDeclaration decl = new ASTElemVarsDeclaration();
                ASTExpression uncer = null;
            
        try {
            // Soil.g:951:6: (op= IDENT LPAREN (decls= elemVarsDeclaration BAR )? nExp= expression ( COMMA uncerExp= additiveExpression )? RPAREN )
            // Soil.g:952:5: op= IDENT LPAREN (decls= elemVarsDeclaration BAR )? nExp= expression ( COMMA uncerExp= additiveExpression )? RPAREN
            {
            op=(Token)match(input,IDENT,FOLLOW_IDENT_in_queryExpression3517); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_queryExpression3524); if (state.failed) return n;

            // Soil.g:954:5: (decls= elemVarsDeclaration BAR )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==IDENT) ) {
                int LA49_1 = input.LA(2);

                if ( ((LA49_1 >= BAR && LA49_1 <= COLON)) ) {
                    alt49=1;
                }
                else if ( (LA49_1==COMMA) ) {
                    int LA49_4 = input.LA(3);

                    if ( (LA49_4==IDENT) ) {
                        int LA49_5 = input.LA(4);

                        if ( ((LA49_5 >= BAR && LA49_5 <= COLON)||LA49_5==COMMA) ) {
                            alt49=1;
                        }
                    }
                }
            }
            switch (alt49) {
                case 1 :
                    // Soil.g:954:7: decls= elemVarsDeclaration BAR
                    {
                    pushFollow(FOLLOW_elemVarsDeclaration_in_queryExpression3535);
                    decls=elemVarsDeclaration();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) {decl = decls;}

                    match(input,BAR,FOLLOW_BAR_in_queryExpression3539); if (state.failed) return n;

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_queryExpression3550);
            nExp=expression();

            state._fsp--;
            if (state.failed) return n;

            // Soil.g:956:5: ( COMMA uncerExp= additiveExpression )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==COMMA) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // Soil.g:956:7: COMMA uncerExp= additiveExpression
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_queryExpression3558); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_queryExpression3562);
                    uncerExp=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { uncer = uncerExp;}

                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_queryExpression3573); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTQueryExpression(op, range, decl, (nExp!=null?nExp.n:null), uncer); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "queryExpression"



    // $ANTLR start "iterateExpression"
    // Soil.g:969:1: iterateExpression[ASTExpression range] returns [ASTExpression n] : i= 'iterate' LPAREN decls= elemVarsDeclaration SEMI init= variableInitialization BAR nExp= expression RPAREN ;
    public final ASTExpression iterateExpression(ASTExpression range) throws RecognitionException {
        ASTExpression n = null;


        Token i=null;
        ASTElemVarsDeclaration decls =null;

        ASTVariableInitialization init =null;

        SoilParser.expression_return nExp =null;


        try {
            // Soil.g:969:65: (i= 'iterate' LPAREN decls= elemVarsDeclaration SEMI init= variableInitialization BAR nExp= expression RPAREN )
            // Soil.g:970:5: i= 'iterate' LPAREN decls= elemVarsDeclaration SEMI init= variableInitialization BAR nExp= expression RPAREN
            {
            i=(Token)match(input,78,FOLLOW_78_in_iterateExpression3605); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_iterateExpression3611); if (state.failed) return n;

            pushFollow(FOLLOW_elemVarsDeclaration_in_iterateExpression3619);
            decls=elemVarsDeclaration();

            state._fsp--;
            if (state.failed) return n;

            match(input,SEMI,FOLLOW_SEMI_in_iterateExpression3621); if (state.failed) return n;

            pushFollow(FOLLOW_variableInitialization_in_iterateExpression3629);
            init=variableInitialization();

            state._fsp--;
            if (state.failed) return n;

            match(input,BAR,FOLLOW_BAR_in_iterateExpression3631); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_iterateExpression3639);
            nExp=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_iterateExpression3645); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTIterateExpression(i, range, decls, init, (nExp!=null?nExp.n:null)); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "iterateExpression"


    public static class operationExpression_return extends ParserRuleReturnScope {
        public ASTOperationExpression n;
    };


    // $ANTLR start "operationExpression"
    // Soil.g:991:1: operationExpression[ASTExpression source, boolean followsArrow] returns [ASTOperationExpression n] : name= IDENT ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )? ( AT 'pre' )? ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )? ;
    public final SoilParser.operationExpression_return operationExpression(ASTExpression source, boolean followsArrow) throws RecognitionException {
        SoilParser.operationExpression_return retval = new SoilParser.operationExpression_return();
        retval.start = input.LT(1);


        Token name=null;
        SoilParser.expression_return rolename =null;

        SoilParser.expression_return e =null;


        try {
            // Soil.g:993:5: (name= IDENT ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )? ( AT 'pre' )? ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )? )
            // Soil.g:994:5: name= IDENT ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )? ( AT 'pre' )? ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )?
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_operationExpression3689); if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n = new ASTOperationExpression(name, source, followsArrow); }

            // Soil.g:1000:5: ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==LBRACK) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // Soil.g:1000:7: LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )?
                    {
                    match(input,LBRACK,FOLLOW_LBRACK_in_operationExpression3711); if (state.failed) return retval;

                    pushFollow(FOLLOW_expression_in_operationExpression3724);
                    rolename=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.addExplicitRolenameOrQualifier((rolename!=null?rolename.n:null)); }

                    // Soil.g:1002:9: ( COMMA rolename= expression )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==COMMA) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // Soil.g:1002:10: COMMA rolename= expression
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_operationExpression3737); if (state.failed) return retval;

                    	    pushFollow(FOLLOW_expression_in_operationExpression3741);
                    	    rolename=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) { retval.n.addExplicitRolenameOrQualifier((rolename!=null?rolename.n:null)); }

                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    match(input,RBRACK,FOLLOW_RBRACK_in_operationExpression3753); if (state.failed) return retval;

                    // Soil.g:1005:7: ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==LBRACK) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // Soil.g:1005:9: LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK
                            {
                            match(input,LBRACK,FOLLOW_LBRACK_in_operationExpression3770); if (state.failed) return retval;

                            pushFollow(FOLLOW_expression_in_operationExpression3785);
                            rolename=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            if ( state.backtracking==0 ) { retval.n.addQualifier((rolename!=null?rolename.n:null)); }

                            // Soil.g:1007:11: ( COMMA rolename= expression )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==COMMA) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // Soil.g:1007:12: COMMA rolename= expression
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_operationExpression3800); if (state.failed) return retval;

                            	    pushFollow(FOLLOW_expression_in_operationExpression3804);
                            	    rolename=expression();

                            	    state._fsp--;
                            	    if (state.failed) return retval;

                            	    if ( state.backtracking==0 ) { retval.n.addQualifier((rolename!=null?rolename.n:null)); }

                            	    }
                            	    break;

                            	default :
                            	    break loop52;
                                }
                            } while (true);


                            match(input,RBRACK,FOLLOW_RBRACK_in_operationExpression3818); if (state.failed) return retval;

                            }
                            break;

                    }


                    }
                    break;

            }


            // Soil.g:1012:5: ( AT 'pre' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==AT) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // Soil.g:1012:7: AT 'pre'
                    {
                    match(input,AT,FOLLOW_AT_in_operationExpression3843); if (state.failed) return retval;

                    match(input,90,FOLLOW_90_in_operationExpression3845); if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.setIsPre(); }

                    }
                    break;

            }


            // Soil.g:1014:5: ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==LPAREN) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // Soil.g:1015:7: LPAREN (e= expression ( COMMA e= expression )* )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_operationExpression3870); if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.hasParentheses(); }

                    // Soil.g:1016:7: (e= expression ( COMMA e= expression )* )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==AT||LA57_0==HASH||(LA57_0 >= IDENT && LA57_0 <= INT)||(LA57_0 >= LPAREN && LA57_0 <= MINUS)||LA57_0==PLUS||LA57_0==REAL||(LA57_0 >= STAR && LA57_0 <= STRING)||(LA57_0 >= 44 && LA57_0 <= 55)||LA57_0==70||LA57_0==73||(LA57_0 >= 78 && LA57_0 <= 79)||(LA57_0 >= 81 && LA57_0 <= 88)||(LA57_0 >= 91 && LA57_0 <= 92)||LA57_0==94) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // Soil.g:1017:7: e= expression ( COMMA e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_operationExpression3891);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            if ( state.backtracking==0 ) { retval.n.addArg((e!=null?e.n:null)); }

                            // Soil.g:1018:7: ( COMMA e= expression )*
                            loop56:
                            do {
                                int alt56=2;
                                int LA56_0 = input.LA(1);

                                if ( (LA56_0==COMMA) ) {
                                    alt56=1;
                                }


                                switch (alt56) {
                            	case 1 :
                            	    // Soil.g:1018:9: COMMA e= expression
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_operationExpression3903); if (state.failed) return retval;

                            	    pushFollow(FOLLOW_expression_in_operationExpression3907);
                            	    e=expression();

                            	    state._fsp--;
                            	    if (state.failed) return retval;

                            	    if ( state.backtracking==0 ) { retval.n.addArg((e!=null?e.n:null)); }

                            	    }
                            	    break;

                            	default :
                            	    break loop56;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_operationExpression3927); if (state.failed) return retval;

                    }
                    break;

            }


            if ( state.backtracking==0 ) { retval.n.setStartToken(((Token)retval.start)); }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "operationExpression"



    // $ANTLR start "inStateExpression"
    // Soil.g:1025:1: inStateExpression[ASTExpression source, boolean followsArrow] returns [ASTInStateExpression n] : opToken= 'oclInState' LPAREN s= IDENT RPAREN ;
    public final ASTInStateExpression inStateExpression(ASTExpression source, boolean followsArrow) throws RecognitionException {
        ASTInStateExpression n = null;


        Token opToken=null;
        Token s=null;

        try {
            // Soil.g:1026:35: (opToken= 'oclInState' LPAREN s= IDENT RPAREN )
            // Soil.g:1027:4: opToken= 'oclInState' LPAREN s= IDENT RPAREN
            {
            opToken=(Token)match(input,85,FOLLOW_85_in_inStateExpression3964); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_inStateExpression3969); if (state.failed) return n;

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_inStateExpression3978); if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_inStateExpression3983); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTInStateExpression(opToken, source, s, followsArrow); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "inStateExpression"



    // $ANTLR start "typeExpression"
    // Soil.g:1039:1: typeExpression[ASTExpression source, boolean followsArrow] returns [ASTTypeArgExpression n] : ( 'oclAsType' | 'oclIsKindOf' | 'oclIsTypeOf' | 'selectByType' | 'selectByKind' ) LPAREN t= type RPAREN ;
    public final ASTTypeArgExpression typeExpression(ASTExpression source, boolean followsArrow) throws RecognitionException {
        ASTTypeArgExpression n = null;


        ASTType t =null;


         Token opToken = null; 
        try {
            // Soil.g:1042:2: ( ( 'oclAsType' | 'oclIsKindOf' | 'oclIsTypeOf' | 'selectByType' | 'selectByKind' ) LPAREN t= type RPAREN )
            // Soil.g:1043:2: ( 'oclAsType' | 'oclIsKindOf' | 'oclIsTypeOf' | 'selectByType' | 'selectByKind' ) LPAREN t= type RPAREN
            {
            if ( state.backtracking==0 ) { opToken = input.LT(1); }

            if ( input.LA(1)==83||(input.LA(1) >= 86 && input.LA(1) <= 87)||(input.LA(1) >= 91 && input.LA(1) <= 92) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,LPAREN,FOLLOW_LPAREN_in_typeExpression4043); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_typeExpression4047);
            t=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_typeExpression4049); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTTypeArgExpression(opToken, source, t, followsArrow); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "typeExpression"



    // $ANTLR start "elemVarsDeclaration"
    // Soil.g:1054:1: elemVarsDeclaration returns [ASTElemVarsDeclaration n] :var1= IDENT ( COLON t= type )? ( COMMA varN= IDENT ( COLON tN= type )? )* ;
    public final ASTElemVarsDeclaration elemVarsDeclaration() throws RecognitionException {
        ASTElemVarsDeclaration n = null;


        Token var1=null;
        Token varN=null;
        ASTType t =null;

        ASTType tN =null;


        try {
            // Soil.g:1055:1: (var1= IDENT ( COLON t= type )? ( COMMA varN= IDENT ( COLON tN= type )? )* )
            // Soil.g:1056:1: var1= IDENT ( COLON t= type )? ( COMMA varN= IDENT ( COLON tN= type )? )*
            {
            if ( state.backtracking==0 ) { n = new ASTElemVarsDeclaration(); }

            var1=(Token)match(input,IDENT,FOLLOW_IDENT_in_elemVarsDeclaration4087); if (state.failed) return n;

            // Soil.g:1057:17: ( COLON t= type )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==COLON) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // Soil.g:1057:18: COLON t= type
                    {
                    match(input,COLON,FOLLOW_COLON_in_elemVarsDeclaration4090); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_elemVarsDeclaration4094);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {n.addDeclaration(var1, t);}

            // Soil.g:1058:4: ( COMMA varN= IDENT ( COLON tN= type )? )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==COMMA) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // Soil.g:1058:5: COMMA varN= IDENT ( COLON tN= type )?
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_elemVarsDeclaration4104); if (state.failed) return n;

            	    varN=(Token)match(input,IDENT,FOLLOW_IDENT_in_elemVarsDeclaration4110); if (state.failed) return n;

            	    // Soil.g:1058:24: ( COLON tN= type )?
            	    int alt60=2;
            	    int LA60_0 = input.LA(1);

            	    if ( (LA60_0==COLON) ) {
            	        alt60=1;
            	    }
            	    switch (alt60) {
            	        case 1 :
            	            // Soil.g:1058:25: COLON tN= type
            	            {
            	            match(input,COLON,FOLLOW_COLON_in_elemVarsDeclaration4113); if (state.failed) return n;

            	            pushFollow(FOLLOW_type_in_elemVarsDeclaration4119);
            	            tN=type();

            	            state._fsp--;
            	            if (state.failed) return n;

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {n.addDeclaration(varN, tN); }

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "elemVarsDeclaration"



    // $ANTLR start "variableInitialization"
    // Soil.g:1066:1: variableInitialization returns [ASTVariableInitialization n] : name= IDENT COLON t= type EQUAL e= expression ;
    public final ASTVariableInitialization variableInitialization() throws RecognitionException {
        ASTVariableInitialization n = null;


        Token name=null;
        ASTType t =null;

        SoilParser.expression_return e =null;


        try {
            // Soil.g:1067:5: (name= IDENT COLON t= type EQUAL e= expression )
            // Soil.g:1068:5: name= IDENT COLON t= type EQUAL e= expression
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_variableInitialization4147); if (state.failed) return n;

            match(input,COLON,FOLLOW_COLON_in_variableInitialization4149); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_variableInitialization4153);
            t=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,EQUAL,FOLLOW_EQUAL_in_variableInitialization4155); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_variableInitialization4159);
            e=expression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTVariableInitialization(name, t, (e!=null?e.n:null)); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "variableInitialization"



    // $ANTLR start "ifExpression"
    // Soil.g:1077:1: ifExpression returns [ASTExpression n] : i= 'if' cond= expression 'then' t= expression 'else' e= expression 'endif' ;
    public final ASTExpression ifExpression() throws RecognitionException {
        ASTExpression n = null;


        Token i=null;
        SoilParser.expression_return cond =null;

        SoilParser.expression_return t =null;

        SoilParser.expression_return e =null;


        try {
            // Soil.g:1078:5: (i= 'if' cond= expression 'then' t= expression 'else' e= expression 'endif' )
            // Soil.g:1079:5: i= 'if' cond= expression 'then' t= expression 'else' e= expression 'endif'
            {
            i=(Token)match(input,73,FOLLOW_73_in_ifExpression4191); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_ifExpression4195);
            cond=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,93,FOLLOW_93_in_ifExpression4197); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_ifExpression4201);
            t=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,66,FOLLOW_66_in_ifExpression4203); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_ifExpression4207);
            e=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,68,FOLLOW_68_in_ifExpression4209); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTIfExpression(i, (cond!=null?cond.n:null), (t!=null?t.n:null), (e!=null?e.n:null)); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "ifExpression"



    // $ANTLR start "literal"
    // Soil.g:1098:1: literal returns [ASTExpression n] : (t= 'true' |f= 'false' |i= INT |r= REAL |s= STRING | 'UString' LPAREN usve= additiveExpression COMMA usue= additiveExpression RPAREN | 'UReal' LPAREN urve= additiveExpression COMMA urue= additiveExpression RPAREN | 'UBoolean' LPAREN ubve= conditionalImpliesExpression COMMA ubpe= additiveExpression RPAREN | 'UInteger' LPAREN uive= additiveExpression COMMA uiue= additiveExpression RPAREN | 'SBoolean' LPAREN ubve= additiveExpression COMMA udve= additiveExpression COMMA uuve= additiveExpression COMMA uave= additiveExpression RPAREN | HASH enumLit= IDENT |enumName= IDENT '::' enumLit= IDENT |nColIt= collectionLiteral |nEColIt= emptyCollectionLiteral |nUndLit= undefinedLiteral |nTupleLit= tupleLiteral |un= STAR );
    public final ASTExpression literal() throws RecognitionException {
        ASTExpression n = null;


        Token t=null;
        Token f=null;
        Token i=null;
        Token r=null;
        Token s=null;
        Token enumLit=null;
        Token enumName=null;
        Token un=null;
        ASTExpression usve =null;

        ASTExpression usue =null;

        ASTExpression urve =null;

        ASTExpression urue =null;

        ASTExpression ubve =null;

        ASTExpression ubpe =null;

        ASTExpression uive =null;

        ASTExpression uiue =null;

        ASTExpression udve =null;

        ASTExpression uuve =null;

        ASTExpression uave =null;

        ASTCollectionLiteral nColIt =null;

        ASTEmptyCollectionLiteral nEColIt =null;

        ASTUndefinedLiteral nUndLit =null;

        ASTTupleLiteral nTupleLit =null;


        try {
            // Soil.g:1099:7: (t= 'true' |f= 'false' |i= INT |r= REAL |s= STRING | 'UString' LPAREN usve= additiveExpression COMMA usue= additiveExpression RPAREN | 'UReal' LPAREN urve= additiveExpression COMMA urue= additiveExpression RPAREN | 'UBoolean' LPAREN ubve= conditionalImpliesExpression COMMA ubpe= additiveExpression RPAREN | 'UInteger' LPAREN uive= additiveExpression COMMA uiue= additiveExpression RPAREN | 'SBoolean' LPAREN ubve= additiveExpression COMMA udve= additiveExpression COMMA uuve= additiveExpression COMMA uave= additiveExpression RPAREN | HASH enumLit= IDENT |enumName= IDENT '::' enumLit= IDENT |nColIt= collectionLiteral |nEColIt= emptyCollectionLiteral |nUndLit= undefinedLiteral |nTupleLit= tupleLiteral |un= STAR )
            int alt62=17;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt62=1;
                }
                break;
            case 70:
                {
                alt62=2;
                }
                break;
            case INT:
                {
                alt62=3;
                }
                break;
            case REAL:
                {
                alt62=4;
                }
                break;
            case STRING:
                {
                alt62=5;
                }
                break;
            case 54:
                {
                alt62=6;
                }
                break;
            case 53:
                {
                alt62=7;
                }
                break;
            case 51:
                {
                alt62=8;
                }
                break;
            case 52:
                {
                alt62=9;
                }
                break;
            case 47:
                {
                alt62=10;
                }
                break;
            case HASH:
                {
                alt62=11;
                }
                break;
            case IDENT:
                {
                alt62=12;
                }
                break;
            case 44:
            case 46:
            case 48:
            case 49:
                {
                int LA62_13 = input.LA(2);

                if ( (LA62_13==LPAREN) ) {
                    alt62=14;
                }
                else if ( (LA62_13==LBRACE) ) {
                    alt62=13;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 13, input);

                    throw nvae;

                }
                }
                break;
            case 45:
            case 84:
                {
                alt62=14;
                }
                break;
            case 55:
            case 82:
            case 88:
                {
                alt62=15;
                }
                break;
            case 50:
                {
                alt62=16;
                }
                break;
            case STAR:
                {
                alt62=17;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }

            switch (alt62) {
                case 1 :
                    // Soil.g:1100:7: t= 'true'
                    {
                    t=(Token)match(input,94,FOLLOW_94_in_literal4248); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTBooleanLiteral(true); }

                    }
                    break;
                case 2 :
                    // Soil.g:1101:7: f= 'false'
                    {
                    f=(Token)match(input,70,FOLLOW_70_in_literal4262); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTBooleanLiteral(false); }

                    }
                    break;
                case 3 :
                    // Soil.g:1102:7: i= INT
                    {
                    i=(Token)match(input,INT,FOLLOW_INT_in_literal4275); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTIntegerLiteral(i); }

                    }
                    break;
                case 4 :
                    // Soil.g:1103:7: r= REAL
                    {
                    r=(Token)match(input,REAL,FOLLOW_REAL_in_literal4290); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTRealLiteral(r); }

                    }
                    break;
                case 5 :
                    // Soil.g:1104:7: s= STRING
                    {
                    s=(Token)match(input,STRING,FOLLOW_STRING_in_literal4304); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTStringLiteral(s); }

                    }
                    break;
                case 6 :
                    // Soil.g:1105:7: 'UString' LPAREN usve= additiveExpression COMMA usue= additiveExpression RPAREN
                    {
                    match(input,54,FOLLOW_54_in_literal4314); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal4316); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal4320);
                    usve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal4322); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal4326);
                    usue=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal4328); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUStringLiteral(usve,usue); }

                    }
                    break;
                case 7 :
                    // Soil.g:1106:7: 'UReal' LPAREN urve= additiveExpression COMMA urue= additiveExpression RPAREN
                    {
                    match(input,53,FOLLOW_53_in_literal4338); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal4340); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal4344);
                    urve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal4346); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal4350);
                    urue=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal4352); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTURealLiteral(urve,urue); }

                    }
                    break;
                case 8 :
                    // Soil.g:1107:7: 'UBoolean' LPAREN ubve= conditionalImpliesExpression COMMA ubpe= additiveExpression RPAREN
                    {
                    match(input,51,FOLLOW_51_in_literal4362); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal4364); if (state.failed) return n;

                    pushFollow(FOLLOW_conditionalImpliesExpression_in_literal4368);
                    ubve=conditionalImpliesExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal4370); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal4374);
                    ubpe=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal4376); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUBooleanLiteral(ubve, ubpe); }

                    }
                    break;
                case 9 :
                    // Soil.g:1108:7: 'UInteger' LPAREN uive= additiveExpression COMMA uiue= additiveExpression RPAREN
                    {
                    match(input,52,FOLLOW_52_in_literal4386); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal4388); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal4392);
                    uive=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal4394); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal4398);
                    uiue=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal4400); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUIntegerLiteral(uive, uiue); }

                    }
                    break;
                case 10 :
                    // Soil.g:1109:7: 'SBoolean' LPAREN ubve= additiveExpression COMMA udve= additiveExpression COMMA uuve= additiveExpression COMMA uave= additiveExpression RPAREN
                    {
                    match(input,47,FOLLOW_47_in_literal4410); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal4412); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal4416);
                    ubve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal4418); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal4422);
                    udve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal4424); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal4428);
                    uuve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal4430); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal4434);
                    uave=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal4436); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTSBooleanLiteral(ubve, udve, uuve, uave); }

                    }
                    break;
                case 11 :
                    // Soil.g:1111:7: HASH enumLit= IDENT
                    {
                    match(input,HASH,FOLLOW_HASH_in_literal4453); if (state.failed) return n;

                    enumLit=(Token)match(input,IDENT,FOLLOW_IDENT_in_literal4457); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTEnumLiteral(enumLit);}

                    }
                    break;
                case 12 :
                    // Soil.g:1112:7: enumName= IDENT '::' enumLit= IDENT
                    {
                    enumName=(Token)match(input,IDENT,FOLLOW_IDENT_in_literal4469); if (state.failed) return n;

                    match(input,COLON_COLON,FOLLOW_COLON_COLON_in_literal4471); if (state.failed) return n;

                    enumLit=(Token)match(input,IDENT,FOLLOW_IDENT_in_literal4475); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTEnumLiteral(enumName, enumLit); }

                    }
                    break;
                case 13 :
                    // Soil.g:1113:7: nColIt= collectionLiteral
                    {
                    pushFollow(FOLLOW_collectionLiteral_in_literal4487);
                    nColIt=collectionLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nColIt; }

                    }
                    break;
                case 14 :
                    // Soil.g:1114:7: nEColIt= emptyCollectionLiteral
                    {
                    pushFollow(FOLLOW_emptyCollectionLiteral_in_literal4499);
                    nEColIt=emptyCollectionLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nEColIt; }

                    }
                    break;
                case 15 :
                    // Soil.g:1115:7: nUndLit= undefinedLiteral
                    {
                    pushFollow(FOLLOW_undefinedLiteral_in_literal4511);
                    nUndLit=undefinedLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) {n = nUndLit; }

                    }
                    break;
                case 16 :
                    // Soil.g:1116:7: nTupleLit= tupleLiteral
                    {
                    pushFollow(FOLLOW_tupleLiteral_in_literal4523);
                    nTupleLit=tupleLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) {n = nTupleLit; }

                    }
                    break;
                case 17 :
                    // Soil.g:1117:7: un= STAR
                    {
                    un=(Token)match(input,STAR,FOLLOW_STAR_in_literal4535); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUnlimitedNaturalLiteral(un); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "literal"



    // $ANTLR start "collectionLiteral"
    // Soil.g:1125:1: collectionLiteral returns [ASTCollectionLiteral n] : ( 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LBRACE (ci= collectionItem ( COMMA ci= collectionItem )* )? RBRACE ;
    public final ASTCollectionLiteral collectionLiteral() throws RecognitionException {
        ASTCollectionLiteral n = null;


        ASTCollectionItem ci =null;


         Token op = null; 
        try {
            // Soil.g:1127:5: ( ( 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LBRACE (ci= collectionItem ( COMMA ci= collectionItem )* )? RBRACE )
            // Soil.g:1128:5: ( 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LBRACE (ci= collectionItem ( COMMA ci= collectionItem )* )? RBRACE
            {
            if ( state.backtracking==0 ) { op = input.LT(1); }

            if ( input.LA(1)==44||input.LA(1)==46||(input.LA(1) >= 48 && input.LA(1) <= 49) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            if ( state.backtracking==0 ) { n = new ASTCollectionLiteral(op); }

            match(input,LBRACE,FOLLOW_LBRACE_in_collectionLiteral4602); if (state.failed) return n;

            // Soil.g:1132:5: (ci= collectionItem ( COMMA ci= collectionItem )* )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==AT||LA64_0==HASH||(LA64_0 >= IDENT && LA64_0 <= INT)||(LA64_0 >= LPAREN && LA64_0 <= MINUS)||LA64_0==PLUS||LA64_0==REAL||(LA64_0 >= STAR && LA64_0 <= STRING)||(LA64_0 >= 44 && LA64_0 <= 55)||LA64_0==70||LA64_0==73||(LA64_0 >= 78 && LA64_0 <= 79)||(LA64_0 >= 81 && LA64_0 <= 88)||(LA64_0 >= 91 && LA64_0 <= 92)||LA64_0==94) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // Soil.g:1133:7: ci= collectionItem ( COMMA ci= collectionItem )*
                    {
                    pushFollow(FOLLOW_collectionItem_in_collectionLiteral4619);
                    ci=collectionItem();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n.addItem(ci); }

                    // Soil.g:1134:7: ( COMMA ci= collectionItem )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==COMMA) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // Soil.g:1134:9: COMMA ci= collectionItem
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_collectionLiteral4632); if (state.failed) return n;

                    	    pushFollow(FOLLOW_collectionItem_in_collectionLiteral4636);
                    	    ci=collectionItem();

                    	    state._fsp--;
                    	    if (state.failed) return n;

                    	    if ( state.backtracking==0 ) { n.addItem(ci); }

                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_collectionLiteral4655); if (state.failed) return n;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "collectionLiteral"



    // $ANTLR start "collectionItem"
    // Soil.g:1143:1: collectionItem returns [ASTCollectionItem n] : e= expression ( DOTDOT e= expression )? ;
    public final ASTCollectionItem collectionItem() throws RecognitionException {
        ASTCollectionItem n = null;


        SoilParser.expression_return e =null;


         n = new ASTCollectionItem(); 
        try {
            // Soil.g:1145:5: (e= expression ( DOTDOT e= expression )? )
            // Soil.g:1146:5: e= expression ( DOTDOT e= expression )?
            {
            pushFollow(FOLLOW_expression_in_collectionItem4684);
            e=expression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.setFirst((e!=null?e.n:null)); }

            // Soil.g:1147:5: ( DOTDOT e= expression )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==DOTDOT) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // Soil.g:1147:7: DOTDOT e= expression
                    {
                    match(input,DOTDOT,FOLLOW_DOTDOT_in_collectionItem4695); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_collectionItem4699);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n.setSecond((e!=null?e.n:null)); }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "collectionItem"



    // $ANTLR start "emptyCollectionLiteral"
    // Soil.g:1157:1: emptyCollectionLiteral returns [ASTEmptyCollectionLiteral n] : ( 'oclEmpty' LPAREN t= collectionType RPAREN |t= collectionType LBRACE RBRACE );
    public final ASTEmptyCollectionLiteral emptyCollectionLiteral() throws RecognitionException {
        ASTEmptyCollectionLiteral n = null;


        ASTCollectionType t =null;


        try {
            // Soil.g:1158:5: ( 'oclEmpty' LPAREN t= collectionType RPAREN |t= collectionType LBRACE RBRACE )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==84) ) {
                alt66=1;
            }
            else if ( ((LA66_0 >= 44 && LA66_0 <= 46)||(LA66_0 >= 48 && LA66_0 <= 49)) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }
            switch (alt66) {
                case 1 :
                    // Soil.g:1159:5: 'oclEmpty' LPAREN t= collectionType RPAREN
                    {
                    match(input,84,FOLLOW_84_in_emptyCollectionLiteral4728); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_emptyCollectionLiteral4730); if (state.failed) return n;

                    pushFollow(FOLLOW_collectionType_in_emptyCollectionLiteral4734);
                    t=collectionType();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_emptyCollectionLiteral4736); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTEmptyCollectionLiteral(t); }

                    }
                    break;
                case 2 :
                    // Soil.g:1162:5: t= collectionType LBRACE RBRACE
                    {
                    pushFollow(FOLLOW_collectionType_in_emptyCollectionLiteral4752);
                    t=collectionType();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,LBRACE,FOLLOW_LBRACE_in_emptyCollectionLiteral4754); if (state.failed) return n;

                    match(input,RBRACE,FOLLOW_RBRACE_in_emptyCollectionLiteral4756); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTEmptyCollectionLiteral(t); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "emptyCollectionLiteral"



    // $ANTLR start "undefinedLiteral"
    // Soil.g:1173:1: undefinedLiteral returns [ASTUndefinedLiteral n] : ( 'oclUndefined' LPAREN t= type RPAREN | 'Undefined' | 'null' LPAREN t= type RPAREN | 'null' );
    public final ASTUndefinedLiteral undefinedLiteral() throws RecognitionException {
        ASTUndefinedLiteral n = null;


        ASTType t =null;


        try {
            // Soil.g:1174:5: ( 'oclUndefined' LPAREN t= type RPAREN | 'Undefined' | 'null' LPAREN t= type RPAREN | 'null' )
            int alt67=4;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt67=1;
                }
                break;
            case 55:
                {
                alt67=2;
                }
                break;
            case 82:
                {
                int LA67_3 = input.LA(2);

                if ( (LA67_3==LPAREN) ) {
                    alt67=3;
                }
                else if ( (LA67_3==EOF||LA67_3==ARROW||LA67_3==BAR||(LA67_3 >= COMMA && LA67_3 <= EQUAL)||(LA67_3 >= GREATER && LA67_3 <= GREATER_EQUAL)||LA67_3==LBRACE||(LA67_3 >= LESS && LA67_3 <= LESS_EQUAL)||LA67_3==MINUS||(LA67_3 >= NOT_EQUAL && LA67_3 <= PLUS)||(LA67_3 >= RBRACE && LA67_3 <= RBRACK)||(LA67_3 >= RPAREN && LA67_3 <= SLASH)||LA67_3==STAR||LA67_3==57||(LA67_3 >= 64 && LA67_3 <= 68)||(LA67_3 >= 74 && LA67_3 <= 75)||LA67_3==89||LA67_3==93||LA67_3==96) ) {
                    alt67=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }

            switch (alt67) {
                case 1 :
                    // Soil.g:1175:5: 'oclUndefined' LPAREN t= type RPAREN
                    {
                    match(input,88,FOLLOW_88_in_undefinedLiteral4786); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_undefinedLiteral4788); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_undefinedLiteral4792);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_undefinedLiteral4794); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUndefinedLiteral(t); }

                    }
                    break;
                case 2 :
                    // Soil.g:1178:5: 'Undefined'
                    {
                    match(input,55,FOLLOW_55_in_undefinedLiteral4808); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUndefinedLiteral(); }

                    }
                    break;
                case 3 :
                    // Soil.g:1181:5: 'null' LPAREN t= type RPAREN
                    {
                    match(input,82,FOLLOW_82_in_undefinedLiteral4822); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_undefinedLiteral4824); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_undefinedLiteral4828);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_undefinedLiteral4830); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUndefinedLiteral(t); }

                    }
                    break;
                case 4 :
                    // Soil.g:1184:5: 'null'
                    {
                    match(input,82,FOLLOW_82_in_undefinedLiteral4844); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUndefinedLiteral(); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "undefinedLiteral"



    // $ANTLR start "tupleLiteral"
    // Soil.g:1194:1: tupleLiteral returns [ASTTupleLiteral n] : 'Tuple' LBRACE ti= tupleItem ( COMMA ti= tupleItem )* RBRACE ;
    public final ASTTupleLiteral tupleLiteral() throws RecognitionException {
        ASTTupleLiteral n = null;


        ASTTupleItem ti =null;


         List tiList = new ArrayList(); 
        try {
            // Soil.g:1196:5: ( 'Tuple' LBRACE ti= tupleItem ( COMMA ti= tupleItem )* RBRACE )
            // Soil.g:1197:5: 'Tuple' LBRACE ti= tupleItem ( COMMA ti= tupleItem )* RBRACE
            {
            match(input,50,FOLLOW_50_in_tupleLiteral4883); if (state.failed) return n;

            match(input,LBRACE,FOLLOW_LBRACE_in_tupleLiteral4889); if (state.failed) return n;

            pushFollow(FOLLOW_tupleItem_in_tupleLiteral4897);
            ti=tupleItem();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { tiList.add(ti); }

            // Soil.g:1200:5: ( COMMA ti= tupleItem )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==COMMA) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // Soil.g:1200:7: COMMA ti= tupleItem
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_tupleLiteral4908); if (state.failed) return n;

            	    pushFollow(FOLLOW_tupleItem_in_tupleLiteral4912);
            	    ti=tupleItem();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { tiList.add(ti); }

            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_tupleLiteral4923); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTTupleLiteral(tiList); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "tupleLiteral"



    // $ANTLR start "tupleItem"
    // Soil.g:1208:1: tupleItem returns [ASTTupleItem n] : name= IDENT ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression ) ;
    public final ASTTupleItem tupleItem() throws RecognitionException {
        ASTTupleItem n = null;


        Token name=null;
        ASTType t =null;

        SoilParser.expression_return e =null;


        try {
            // Soil.g:1209:5: (name= IDENT ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression ) )
            // Soil.g:1210:5: name= IDENT ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression )
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_tupleItem4954); if (state.failed) return n;

            // Soil.g:1211:5: ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==COLON) ) {
                int LA69_1 = input.LA(2);

                if ( (synpred2_Soil()) ) {
                    alt69=1;
                }
                else if ( (true) ) {
                    alt69=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA69_0==EQUAL) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }
            switch (alt69) {
                case 1 :
                    // Soil.g:1214:7: ( COLON type EQUAL )=> COLON t= type EQUAL e= expression
                    {
                    match(input,COLON,FOLLOW_COLON_in_tupleItem4993); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_tupleItem4997);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,EQUAL,FOLLOW_EQUAL_in_tupleItem4999); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_tupleItem5003);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTTupleItem(name, t, (e!=null?e.n:null)); }

                    }
                    break;
                case 2 :
                    // Soil.g:1217:7: ( COLON | EQUAL ) e= expression
                    {
                    if ( input.LA(1)==COLON||input.LA(1)==EQUAL ) {
                        input.consume();
                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    pushFollow(FOLLOW_expression_in_tupleItem5035);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTTupleItem(name, (e!=null?e.n:null)); }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "tupleItem"



    // $ANTLR start "type"
    // Soil.g:1229:1: type returns [ASTType n] : (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType ) ;
    public final ASTType type() throws RecognitionException {
        ASTType n = null;


        ASTSimpleType nTSimple =null;

        ASTCollectionType nTCollection =null;

        ASTTupleType nTTuple =null;

        ASTType nTUncertainty =null;


         Token tok = null; 
        try {
            // Soil.g:1231:5: ( (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType ) )
            // Soil.g:1232:5: (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType )
            {
            if ( state.backtracking==0 ) { tok = input.LT(1); /* remember start of type */ }

            // Soil.g:1233:5: (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType )
            int alt70=4;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt70=1;
                }
                break;
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
                {
                alt70=2;
                }
                break;
            case 50:
                {
                alt70=3;
                }
                break;
            case 47:
            case 51:
            case 52:
            case 53:
            case 54:
                {
                alt70=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }

            switch (alt70) {
                case 1 :
                    // Soil.g:1234:7: nTSimple= simpleType
                    {
                    pushFollow(FOLLOW_simpleType_in_type5101);
                    nTSimple=simpleType();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nTSimple; if (n != null) n.setStartToken(tok); }

                    }
                    break;
                case 2 :
                    // Soil.g:1235:7: nTCollection= collectionType
                    {
                    pushFollow(FOLLOW_collectionType_in_type5113);
                    nTCollection=collectionType();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nTCollection; if (n != null) n.setStartToken(tok); }

                    }
                    break;
                case 3 :
                    // Soil.g:1236:7: nTTuple= tupleType
                    {
                    pushFollow(FOLLOW_tupleType_in_type5125);
                    nTTuple=tupleType();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nTTuple; if (n != null) n.setStartToken(tok); }

                    }
                    break;
                case 4 :
                    // Soil.g:1237:7: nTUncertainty= uncertaintyType
                    {
                    pushFollow(FOLLOW_uncertaintyType_in_type5137);
                    nTUncertainty=uncertaintyType();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nTUncertainty; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "type"



    // $ANTLR start "uncertaintyType"
    // Soil.g:1241:1: uncertaintyType returns [ASTType n] : name= ( 'UReal' | 'UInteger' | 'UBoolean' | 'UString' | 'SBoolean' ) ;
    public final ASTType uncertaintyType() throws RecognitionException {
        ASTType n = null;


        Token name=null;

        try {
            // Soil.g:1242:5: (name= ( 'UReal' | 'UInteger' | 'UBoolean' | 'UString' | 'SBoolean' ) )
            // Soil.g:1243:5: name= ( 'UReal' | 'UInteger' | 'UBoolean' | 'UString' | 'SBoolean' )
            {
            name=(Token)input.LT(1);

            if ( input.LA(1)==47||(input.LA(1) >= 51 && input.LA(1) <= 54) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            if ( state.backtracking==0 ) { n = new ASTSimpleType(name); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "uncertaintyType"



    // $ANTLR start "typeOnly"
    // Soil.g:1247:1: typeOnly returns [ASTType n] : nT= type EOF ;
    public final ASTType typeOnly() throws RecognitionException {
        ASTType n = null;


        ASTType nT =null;


        try {
            // Soil.g:1248:5: (nT= type EOF )
            // Soil.g:1249:5: nT= type EOF
            {
            pushFollow(FOLLOW_type_in_typeOnly5206);
            nT=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,EOF,FOLLOW_EOF_in_typeOnly5208); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = nT; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "typeOnly"



    // $ANTLR start "simpleType"
    // Soil.g:1259:1: simpleType returns [ASTSimpleType n] : name= IDENT ;
    public final ASTSimpleType simpleType() throws RecognitionException {
        ASTSimpleType n = null;


        Token name=null;

        try {
            // Soil.g:1260:5: (name= IDENT )
            // Soil.g:1261:5: name= IDENT
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_simpleType5236); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTSimpleType(name); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "simpleType"



    // $ANTLR start "collectionType"
    // Soil.g:1269:1: collectionType returns [ASTCollectionType n] : ( 'Collection' | 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LPAREN elemType= type RPAREN ;
    public final ASTCollectionType collectionType() throws RecognitionException {
        ASTCollectionType n = null;


        ASTType elemType =null;


         Token op = null; 
        try {
            // Soil.g:1271:5: ( ( 'Collection' | 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LPAREN elemType= type RPAREN )
            // Soil.g:1272:5: ( 'Collection' | 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LPAREN elemType= type RPAREN
            {
            if ( state.backtracking==0 ) { op = input.LT(1); }

            if ( (input.LA(1) >= 44 && input.LA(1) <= 46)||(input.LA(1) >= 48 && input.LA(1) <= 49) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,LPAREN,FOLLOW_LPAREN_in_collectionType5301); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_collectionType5305);
            elemType=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_collectionType5307); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTCollectionType(op, elemType); n.setStartToken(op);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "collectionType"



    // $ANTLR start "tupleType"
    // Soil.g:1282:1: tupleType returns [ASTTupleType n] : 'Tuple' LPAREN tp= tuplePart ( COMMA tp= tuplePart )* RPAREN ;
    public final ASTTupleType tupleType() throws RecognitionException {
        ASTTupleType n = null;


        ASTTuplePart tp =null;


         List tpList = new ArrayList(); 
        try {
            // Soil.g:1284:5: ( 'Tuple' LPAREN tp= tuplePart ( COMMA tp= tuplePart )* RPAREN )
            // Soil.g:1285:5: 'Tuple' LPAREN tp= tuplePart ( COMMA tp= tuplePart )* RPAREN
            {
            match(input,50,FOLLOW_50_in_tupleType5341); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_tupleType5343); if (state.failed) return n;

            pushFollow(FOLLOW_tuplePart_in_tupleType5352);
            tp=tuplePart();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { tpList.add(tp); }

            // Soil.g:1287:5: ( COMMA tp= tuplePart )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==COMMA) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // Soil.g:1287:7: COMMA tp= tuplePart
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_tupleType5363); if (state.failed) return n;

            	    pushFollow(FOLLOW_tuplePart_in_tupleType5367);
            	    tp=tuplePart();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { tpList.add(tp); }

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);


            match(input,RPAREN,FOLLOW_RPAREN_in_tupleType5379); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTTupleType(tpList); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "tupleType"



    // $ANTLR start "tuplePart"
    // Soil.g:1296:1: tuplePart returns [ASTTuplePart n] : name= IDENT COLON t= type ;
    public final ASTTuplePart tuplePart() throws RecognitionException {
        ASTTuplePart n = null;


        Token name=null;
        ASTType t =null;


        try {
            // Soil.g:1297:5: (name= IDENT COLON t= type )
            // Soil.g:1298:5: name= IDENT COLON t= type
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_tuplePart5411); if (state.failed) return n;

            match(input,COLON,FOLLOW_COLON_in_tuplePart5413); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_tuplePart5417);
            t=type();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTTuplePart(name, t); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return n;
    }
    // $ANTLR end "tuplePart"

    // $ANTLR start synpred1_Soil
    public final void synpred1_Soil_fragment() throws RecognitionException {
        // Soil.g:151:5: ( statStartingWithExpr )
        // Soil.g:151:6: statStartingWithExpr
        {
        pushFollow(FOLLOW_statStartingWithExpr_in_synpred1_Soil195);
        statStartingWithExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_Soil

    // $ANTLR start synpred2_Soil
    public final void synpred2_Soil_fragment() throws RecognitionException {
        // Soil.g:1214:7: ( COLON type EQUAL )
        // Soil.g:1214:8: COLON type EQUAL
        {
        match(input,COLON,FOLLOW_COLON_in_synpred2_Soil4984); if (state.failed) return ;

        pushFollow(FOLLOW_type_in_synpred2_Soil4986);
        type();

        state._fsp--;
        if (state.failed) return ;

        match(input,EQUAL,FOLLOW_EQUAL_in_synpred2_Soil4988); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_Soil

    // Delegated rules

    public final boolean synpred2_Soil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Soil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Soil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Soil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_stat_in_statOnly76 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_statOnly80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleStat_in_stat115 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_SEMI_in_stat127 = new BitSet(new long[]{0xC4FFF308861A0020L,0x00000000D9FFD2C0L});
    public static final BitSet FOLLOW_singleStat_in_stat137 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_emptyStat_in_singleStat177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statStartingWithExpr_in_singleStat203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varAssignStat_in_singleStat215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCreateStat_in_singleStat229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objDestroyStat_in_singleStat243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lnkInsStat_in_singleStat256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lnkDelStat_in_singleStat273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condExStat_in_singleStat290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iterStat_in_singleStat307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStat_in_singleStat329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStat_in_singleStat347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nothing_in_emptyStat374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inSoilExpression_in_statStartingWithExpr400 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_attAssignStat_in_statStartingWithExpr414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_varAssignStat452 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_EQUAL_in_varAssignStat456 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValue_in_varAssignStat464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_attAssignStat488 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_attAssignStat497 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_EQUAL_in_attAssignStat501 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValue_in_attAssignStat509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_objCreateStat535 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_simpleType_in_objCreateStat543 = new BitSet(new long[]{0x0800000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_objCreateStat553 = new BitSet(new long[]{0x00FFF318861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_inSoilExpression_in_objCreateStat566 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_objCreateStat574 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_objCreateStat592 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_objCreateStat600 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValListMin2WithOptionalQualifiers_in_objCreateStat614 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_objCreateStat622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_objDestroyStat658 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_exprListMin1_in_objDestroyStat666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_lnkInsStat692 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_lnkInsStat696 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkInsStat706 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_lnkInsStat710 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_lnkInsStat714 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_lnkInsStat722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers751 = new BitSet(new long[]{0x0000000000200400L});
    public static final BitSet FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers762 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers771 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers778 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers794 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers805 = new BitSet(new long[]{0x0000000000200402L});
    public static final BitSet FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers816 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers825 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers832 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers854 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers869 = new BitSet(new long[]{0x0000000000200402L});
    public static final BitSet FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers889 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers900 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers909 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_62_in_lnkDelStat950 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_lnkDelStat954 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkDelStat964 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_lnkDelStat968 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_lnkDelStat972 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_lnkDelStat981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_condExStat1012 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_inSoilExpression_in_condExStat1021 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_condExStat1025 = new BitSet(new long[]{0xE4FFF308861A0020L,0x00000000D9FFD2C0L});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_condExStat1034 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_66_in_condExStat1045 = new BitSet(new long[]{0xE4FFF308861A0020L,0x00000000D9FFD2C0L});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_condExStat1057 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_condExStat1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_iterStat1094 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_iterStat1102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_iterStat1106 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_inSoilExpression_in_iterStat1114 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_iterStat1118 = new BitSet(new long[]{0xE4FFF308861A0020L,0x00000000D9FFD2C0L});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_iterStat1126 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_iterStat1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_whileStat1157 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_inSoilExpression_in_whileStat1165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_whileStat1169 = new BitSet(new long[]{0xE4FFF308861A0020L,0x00000000D9FFD2C0L});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_whileStat1177 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_whileStat1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_blockStat1212 = new BitSet(new long[]{0xE4FFF308861A0020L,0x00000000D9FFD2C0L});
    public static final BitSet FOLLOW_61_in_blockStat1217 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_blockStat1223 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_COMMA_in_blockStat1229 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_blockStat1235 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_SEMI_in_blockStat1242 = new BitSet(new long[]{0xC4FFF308861A0020L,0x00000000D9FFD2C0L});
    public static final BitSet FOLLOW_stat_in_blockStat1252 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_blockStat1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_implicitBlockStat1283 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_implicitBlockStat1289 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_COMMA_in_implicitBlockStat1295 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_implicitBlockStat1301 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_SEMI_in_implicitBlockStat1308 = new BitSet(new long[]{0xC4FFF308861A0020L,0x00000000D9FFD2C0L});
    public static final BitSet FOLLOW_stat_in_implicitBlockStat1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_statOrImplicitBlock1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicitBlockStat_in_statOrImplicitBlock1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inSoilExpression_in_rValue1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCreateStat_in_rValue1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nothing_in_rValList1430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rValListMin1_in_rValList1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rValue_in_rValListMin11490 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin11504 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValue_in_rValListMin11514 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rValue_in_rValListMin21553 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin21561 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValue_in_rValListMin21569 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin21583 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FFC240L});
    public static final BitSet FOLLOW_rValue_in_rValListMin21593 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_expression_in_inSoilExpression1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nothing_in_exprList1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exprListMin1_in_exprList1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin11707 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_exprListMin11722 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin11732 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin21772 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_exprListMin21780 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin21788 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_exprListMin21802 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin21812 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_nothing_in_identList1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identListMin1_in_identList1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_identListMin11893 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_identListMin11907 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_identListMin11917 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_expression_in_expressionOnly1957 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expressionOnly1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_expression2007 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_expression2018 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_COLON_in_expression2022 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_expression2026 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_expression2031 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_expression2035 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000800L});
    public static final BitSet FOLLOW_COMMA_in_expression2073 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_expression2085 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_COLON_in_expression2089 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_expression2093 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_expression2098 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_expression2102 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_expression2143 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_identicalExpression_in_expression2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_paramList2192 = new BitSet(new long[]{0x0000001000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_paramList2209 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_paramList2221 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_paramList2225 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_RPAREN_in_paramList2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_idList2274 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_idList2284 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_idList2288 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_IDENT_in_variableDeclaration2319 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_variableDeclaration2321 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_variableDeclaration2325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalImpliesExpression_in_identicalExpression2356 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_DOT_in_identicalExpression2374 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_identicalExpression2378 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_identicalExpression2380 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_conditionalImpliesExpression_in_identicalExpression2384 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_identicalExpression2386 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression2429 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_conditionalImpliesExpression2442 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression2446 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_conditionalXOrExpression_in_conditionalOrExpression2491 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_conditionalOrExpression2504 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_conditionalXOrExpression_in_conditionalOrExpression2508 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalXOrExpression2552 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_conditionalXOrExpression2565 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalXOrExpression2569 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_equalityExpression_in_conditionalAndExpression2613 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_conditionalAndExpression2626 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_equalityExpression_in_conditionalAndExpression2630 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression2678 = new BitSet(new long[]{0x0000000040002002L});
    public static final BitSet FOLLOW_set_in_equalityExpression2697 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression2707 = new BitSet(new long[]{0x0000000040002002L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression2756 = new BitSet(new long[]{0x0000000001818002L});
    public static final BitSet FOLLOW_set_in_relationalExpression2774 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression2792 = new BitSet(new long[]{0x0000000001818002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression2842 = new BitSet(new long[]{0x0000000084000002L});
    public static final BitSet FOLLOW_set_in_additiveExpression2860 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression2870 = new BitSet(new long[]{0x0000000084000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression2920 = new BitSet(new long[]{0x0000014000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression2938 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression2952 = new BitSet(new long[]{0x0000014000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_set_in_unaryExpression3014 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression3038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression3058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpression_in_postfixExpression3091 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_ARROW_in_postfixExpression3109 = new BitSet(new long[]{0x0000000000080000L,0x0000000018E84000L});
    public static final BitSet FOLLOW_DOT_in_postfixExpression3115 = new BitSet(new long[]{0x0000000000080000L,0x0000000018E84000L});
    public static final BitSet FOLLOW_propertyCall_in_postfixExpression3126 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_literal_in_primaryExpression3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectReference_in_primaryExpression3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyCall_in_primaryExpression3192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression3203 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_primaryExpression3207 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifExpression_in_primaryExpression3221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primaryExpression3233 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_DOT_in_primaryExpression3235 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_primaryExpression3237 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_AT_in_primaryExpression3260 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_primaryExpression3262 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression3280 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression3282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primaryExpression3295 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_DOT_in_primaryExpression3297 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_primaryExpression3299 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression3303 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_primaryExpression3307 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression3309 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AT_in_primaryExpression3329 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_primaryExpression3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_objectReference3357 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_objectReference3365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_queryExpression_in_propertyCall3430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iterateExpression_in_propertyCall3443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationExpression_in_propertyCall3456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeExpression_in_propertyCall3469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inStateExpression_in_propertyCall3482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_queryExpression3517 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_queryExpression3524 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_elemVarsDeclaration_in_queryExpression3535 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_BAR_in_queryExpression3539 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_queryExpression3550 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_queryExpression3558 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_queryExpression3562 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_queryExpression3573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_iterateExpression3605 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_iterateExpression3611 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_elemVarsDeclaration_in_iterateExpression3619 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMI_in_iterateExpression3621 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableInitialization_in_iterateExpression3629 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_BAR_in_iterateExpression3631 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_iterateExpression3639 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_iterateExpression3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_operationExpression3689 = new BitSet(new long[]{0x0000000002400022L});
    public static final BitSet FOLLOW_LBRACK_in_operationExpression3711 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_operationExpression3724 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_COMMA_in_operationExpression3737 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_operationExpression3741 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_RBRACK_in_operationExpression3753 = new BitSet(new long[]{0x0000000002400022L});
    public static final BitSet FOLLOW_LBRACK_in_operationExpression3770 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_operationExpression3785 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_COMMA_in_operationExpression3800 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_operationExpression3804 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_RBRACK_in_operationExpression3818 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_AT_in_operationExpression3843 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_operationExpression3845 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_operationExpression3870 = new BitSet(new long[]{0x00FFF318861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_operationExpression3891 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_operationExpression3903 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_operationExpression3907 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_RPAREN_in_operationExpression3927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_inStateExpression3964 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_inStateExpression3969 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_inStateExpression3978 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_inStateExpression3983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeExpression4019 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_typeExpression4043 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_typeExpression4047 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_typeExpression4049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_elemVarsDeclaration4087 = new BitSet(new long[]{0x0000000000000482L});
    public static final BitSet FOLLOW_COLON_in_elemVarsDeclaration4090 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_elemVarsDeclaration4094 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_elemVarsDeclaration4104 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_elemVarsDeclaration4110 = new BitSet(new long[]{0x0000000000000482L});
    public static final BitSet FOLLOW_COLON_in_elemVarsDeclaration4113 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_elemVarsDeclaration4119 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_IDENT_in_variableInitialization4147 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_variableInitialization4149 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_variableInitialization4153 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_variableInitialization4155 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_variableInitialization4159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ifExpression4191 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_ifExpression4195 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_ifExpression4197 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_ifExpression4201 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ifExpression4203 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_ifExpression4207 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ifExpression4209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_literal4248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_literal4262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_literal4275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_literal4290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_literal4304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_literal4314 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal4316 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_literal4320 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal4322 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_literal4326 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal4328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_literal4338 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal4340 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_literal4344 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal4346 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_literal4350 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal4352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_literal4362 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal4364 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_conditionalImpliesExpression_in_literal4368 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal4370 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_literal4374 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal4376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_literal4386 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal4388 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_literal4392 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal4394 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_literal4398 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal4400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_literal4410 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal4412 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_literal4416 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal4418 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_literal4422 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal4424 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_literal4428 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal4430 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FE4240L});
    public static final BitSet FOLLOW_additiveExpression_in_literal4434 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal4436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HASH_in_literal4453 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_literal4457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_literal4469 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_COLON_in_literal4471 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_literal4475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionLiteral_in_literal4487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emptyCollectionLiteral_in_literal4499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_undefinedLiteral_in_literal4511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleLiteral_in_literal4523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_literal4535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionLiteral4573 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LBRACE_in_collectionLiteral4602 = new BitSet(new long[]{0x00FFF30A861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_collectionItem_in_collectionLiteral4619 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_COMMA_in_collectionLiteral4632 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_collectionItem_in_collectionLiteral4636 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_RBRACE_in_collectionLiteral4655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_collectionItem4684 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_DOTDOT_in_collectionItem4695 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_collectionItem4699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_emptyCollectionLiteral4728 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_emptyCollectionLiteral4730 = new BitSet(new long[]{0x0003700000000000L});
    public static final BitSet FOLLOW_collectionType_in_emptyCollectionLiteral4734 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_emptyCollectionLiteral4736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_emptyCollectionLiteral4752 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LBRACE_in_emptyCollectionLiteral4754 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_emptyCollectionLiteral4756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_undefinedLiteral4786 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_undefinedLiteral4788 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_undefinedLiteral4792 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_undefinedLiteral4794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_undefinedLiteral4808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_undefinedLiteral4822 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_undefinedLiteral4824 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_undefinedLiteral4828 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_undefinedLiteral4830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_undefinedLiteral4844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_tupleLiteral4883 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LBRACE_in_tupleLiteral4889 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tupleItem_in_tupleLiteral4897 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_COMMA_in_tupleLiteral4908 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tupleItem_in_tupleLiteral4912 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_RBRACE_in_tupleLiteral4923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_tupleItem4954 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_COLON_in_tupleItem4993 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_tupleItem4997 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_tupleItem4999 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_tupleItem5003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tupleItem5025 = new BitSet(new long[]{0x00FFF308861A0020L,0x0000000059FEC240L});
    public static final BitSet FOLLOW_expression_in_tupleItem5035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleType_in_type5101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_type5113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleType_in_type5125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_uncertaintyType_in_type5137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_uncertaintyType5168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeOnly5206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_typeOnly5208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_simpleType5236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType5274 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_collectionType5301 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_collectionType5305 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_collectionType5307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_tupleType5341 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_tupleType5343 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tuplePart_in_tupleType5352 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_tupleType5363 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tuplePart_in_tupleType5367 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tupleType5379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_tuplePart5411 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_tuplePart5413 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_tuplePart5417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statStartingWithExpr_in_synpred1_Soil195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_synpred2_Soil4984 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_synpred2_Soil4986 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_synpred2_Soil4988 = new BitSet(new long[]{0x0000000000000002L});

}