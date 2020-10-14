// $ANTLR 3.4 TestSuite.g 2020-10-07 09:32:05
 
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
 
package org.tzi.use.parser.testsuite;

import org.tzi.use.parser.base.BaseParser;
import org.tzi.use.parser.soil.*;
import org.tzi.use.parser.soil.ast.*;
import org.tzi.use.parser.ocl.*;
import java.util.Collections;
import java.util.Arrays;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TestSuiteParser extends BaseParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARROW", "AT", "BAR", "COLON", "COLON_COLON", "COLON_EQUAL", "COMMA", "DOT", "DOTDOT", "EQUAL", "ESC", "GREATER", "GREATER_EQUAL", "HASH", "HEX_DIGIT", "IDENT", "INT", "LBRACE", "LBRACK", "LESS", "LESS_EQUAL", "LPAREN", "MINUS", "ML_COMMENT", "NEWLINE", "NON_OCL_STRING", "NOT_EQUAL", "PLUS", "RANGE_OR_INT", "RBRACE", "RBRACK", "REAL", "RPAREN", "SEMI", "SLASH", "SL_COMMENT", "STAR", "STRING", "VOCAB", "WS", "'!'", "'Bag'", "'Collection'", "'OrderedSet'", "'SBoolean'", "'Sequence'", "'Set'", "'Tuple'", "'UBoolean'", "'UInteger'", "'UReal'", "'UString'", "'Undefined'", "'allInstances'", "'and'", "'assert'", "'assign'", "'begin'", "'beginVariation'", "'between'", "'byUseId'", "'create'", "'declare'", "'delete'", "'destroy'", "'div'", "'do'", "'else'", "'end'", "'endVariation'", "'endif'", "'equals'", "'execute'", "'false'", "'for'", "'from'", "'if'", "'implies'", "'in'", "'insert'", "'into'", "'inv'", "'invalid'", "'invs'", "'iterate'", "'let'", "'model'", "'new'", "'not'", "'null'", "'oclAsType'", "'oclEmpty'", "'oclInState'", "'oclIsKindOf'", "'oclIsTypeOf'", "'oclUndefined'", "'openter'", "'opexit'", "'or'", "'post'", "'pre'", "'selectByKind'", "'selectByType'", "'set'", "'setup'", "'testcase'", "'testsuite'", "'then'", "'true'", "'valid'", "'while'", "'xor'"
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
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__99=99;
    public static final int T__100=100;
    public static final int T__101=101;
    public static final int T__102=102;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__110=110;
    public static final int T__111=111;
    public static final int T__112=112;
    public static final int T__113=113;
    public static final int T__114=114;
    public static final int T__115=115;
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


    public TestSuiteParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public TestSuiteParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return TestSuiteParser.tokenNames; }
    public String getGrammarFileName() { return "TestSuite.g"; }



    // $ANTLR start "testSuite"
    // TestSuite.g:90:1: testSuite returns [ASTTestSuite suite] : 'testsuite' suiteName= IDENT 'for' 'model' modelFile= filename ( 'setup' ( '!' c= shellCommandOnly )* 'end' )? tests= testCases EOF ;
    public final ASTTestSuite testSuite() throws RecognitionException {
        ASTTestSuite suite = null;


        Token suiteName=null;
        String modelFile =null;

        ASTStatement c =null;

        List tests =null;



          List setupStatements = new ArrayList();

        try {
            // TestSuite.g:94:3: ( 'testsuite' suiteName= IDENT 'for' 'model' modelFile= filename ( 'setup' ( '!' c= shellCommandOnly )* 'end' )? tests= testCases EOF )
            // TestSuite.g:95:3: 'testsuite' suiteName= IDENT 'for' 'model' modelFile= filename ( 'setup' ( '!' c= shellCommandOnly )* 'end' )? tests= testCases EOF
            {
            match(input,110,FOLLOW_110_in_testSuite61); if (state.failed) return suite;

            suiteName=(Token)match(input,IDENT,FOLLOW_IDENT_in_testSuite71); if (state.failed) return suite;

            if ( state.backtracking==0 ) { suite = new ASTTestSuite(suiteName); }

            match(input,78,FOLLOW_78_in_testSuite82); if (state.failed) return suite;

            match(input,90,FOLLOW_90_in_testSuite84); if (state.failed) return suite;

            pushFollow(FOLLOW_filename_in_testSuite93);
            modelFile=filename();

            state._fsp--;
            if (state.failed) return suite;

            if ( state.backtracking==0 ) { suite.setModelFile(suiteName); }

            // TestSuite.g:101:3: ( 'setup' ( '!' c= shellCommandOnly )* 'end' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==108) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // TestSuite.g:101:4: 'setup' ( '!' c= shellCommandOnly )* 'end'
                    {
                    match(input,108,FOLLOW_108_in_testSuite105); if (state.failed) return suite;

                    // TestSuite.g:102:4: ( '!' c= shellCommandOnly )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==44) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // TestSuite.g:102:5: '!' c= shellCommandOnly
                    	    {
                    	    match(input,44,FOLLOW_44_in_testSuite112); if (state.failed) return suite;

                    	    pushFollow(FOLLOW_shellCommandOnly_in_testSuite118);
                    	    c=shellCommandOnly();

                    	    state._fsp--;
                    	    if (state.failed) return suite;

                    	    if ( state.backtracking==0 ) { setupStatements.add(c); }

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    match(input,72,FOLLOW_72_in_testSuite124); if (state.failed) return suite;

                    if ( state.backtracking==0 ) { suite.setSetupStatements(setupStatements); }

                    }
                    break;

            }


            pushFollow(FOLLOW_testCases_in_testSuite145);
            tests=testCases();

            state._fsp--;
            if (state.failed) return suite;

            if ( state.backtracking==0 ) { suite.setTestCases(tests); }

            match(input,EOF,FOLLOW_EOF_in_testSuite154); if (state.failed) return suite;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return suite;
    }
    // $ANTLR end "testSuite"



    // $ANTLR start "filename"
    // TestSuite.g:110:1: filename returns [String filename] : name= IDENT '.' suffix= IDENT ;
    public final String filename() throws RecognitionException {
        String filename = null;


        Token name=null;
        Token suffix=null;

        try {
            // TestSuite.g:111:4: (name= IDENT '.' suffix= IDENT )
            // TestSuite.g:112:4: name= IDENT '.' suffix= IDENT
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_filename172); if (state.failed) return filename;

            match(input,DOT,FOLLOW_DOT_in_filename174); if (state.failed) return filename;

            suffix=(Token)match(input,IDENT,FOLLOW_IDENT_in_filename178); if (state.failed) return filename;

            if ( state.backtracking==0 ) {filename = (name!=null?name.getText():null) + "." + (suffix!=null?suffix.getText():null);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return filename;
    }
    // $ANTLR end "filename"



    // $ANTLR start "testCases"
    // TestSuite.g:115:1: testCases returns [List testCases] : (test= testCase )+ ;
    public final List testCases() throws RecognitionException {
        List testCases = null;


        ASTTestCase test =null;


         testCases = new ArrayList(); 
        try {
            // TestSuite.g:117:3: ( (test= testCase )+ )
            // TestSuite.g:118:3: (test= testCase )+
            {
            // TestSuite.g:118:3: (test= testCase )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==109) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // TestSuite.g:118:4: test= testCase
            	    {
            	    pushFollow(FOLLOW_testCase_in_testCases205);
            	    test=testCase();

            	    state._fsp--;
            	    if (state.failed) return testCases;

            	    if ( state.backtracking==0 ) { testCases.add(test); }

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return testCases;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
        return testCases;
    }
    // $ANTLR end "testCases"



    // $ANTLR start "testCase"
    // TestSuite.g:121:1: testCase returns [ASTTestCase n] : 'testcase' name= IDENT ( '!' c= shellCommandOnly |a= assertStatement |b= 'beginVariation' |e= 'endVariation' )* 'end' ;
    public final ASTTestCase testCase() throws RecognitionException {
        ASTTestCase n = null;


        Token name=null;
        Token b=null;
        Token e=null;
        ASTStatement c =null;

        ASTAssert a =null;


        try {
            // TestSuite.g:122:3: ( 'testcase' name= IDENT ( '!' c= shellCommandOnly |a= assertStatement |b= 'beginVariation' |e= 'endVariation' )* 'end' )
            // TestSuite.g:123:3: 'testcase' name= IDENT ( '!' c= shellCommandOnly |a= assertStatement |b= 'beginVariation' |e= 'endVariation' )* 'end'
            {
            match(input,109,FOLLOW_109_in_testCase224); if (state.failed) return n;

            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_testCase228); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTTestCase(name); }

            // TestSuite.g:124:3: ( '!' c= shellCommandOnly |a= assertStatement |b= 'beginVariation' |e= 'endVariation' )*
            loop4:
            do {
                int alt4=5;
                switch ( input.LA(1) ) {
                case 44:
                    {
                    alt4=1;
                    }
                    break;
                case 59:
                    {
                    alt4=2;
                    }
                    break;
                case 62:
                    {
                    alt4=3;
                    }
                    break;
                case 73:
                    {
                    alt4=4;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // TestSuite.g:125:7: '!' c= shellCommandOnly
            	    {
            	    match(input,44,FOLLOW_44_in_testCase242); if (state.failed) return n;

            	    pushFollow(FOLLOW_shellCommandOnly_in_testCase248);
            	    c=shellCommandOnly();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n.addStatement(c); }

            	    }
            	    break;
            	case 2 :
            	    // TestSuite.g:127:7: a= assertStatement
            	    {
            	    pushFollow(FOLLOW_assertStatement_in_testCase267);
            	    a=assertStatement();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n.addStatement(a); }

            	    }
            	    break;
            	case 3 :
            	    // TestSuite.g:129:7: b= 'beginVariation'
            	    {
            	    b=(Token)match(input,62,FOLLOW_62_in_testCase285); if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n.addStatement(new ASTVariationStart(b)); }

            	    }
            	    break;
            	case 4 :
            	    // TestSuite.g:131:7: e= 'endVariation'
            	    {
            	    e=(Token)match(input,73,FOLLOW_73_in_testCase303); if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n.addStatement(new ASTVariationEnd(e)); }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match(input,72,FOLLOW_72_in_testCase315); if (state.failed) return n;

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
    // $ANTLR end "testCase"



    // $ANTLR start "assertStatement"
    // TestSuite.g:136:1: assertStatement returns [ASTAssert n] : s= 'assert' ( 'valid' | 'invalid' ) (exp= expression | 'invs' | 'invs' classname= IDENT | 'inv' classname= IDENT COLON_COLON invname= IDENT |pre= assertionStatementPre[s=$s, valid=valid] |post= assertionStatementPost[s=$s, valid=valid] ) ( COMMA msg= STRING )? ;
    public final ASTAssert assertStatement() throws RecognitionException {
        ASTAssert n = null;


        Token s=null;
        Token classname=null;
        Token invname=null;
        Token msg=null;
        TestSuiteParser.expression_return exp =null;

        ASTAssertPre pre =null;

        ASTAssertPost post =null;


         boolean valid = true; 
        try {
            // TestSuite.g:138:3: (s= 'assert' ( 'valid' | 'invalid' ) (exp= expression | 'invs' | 'invs' classname= IDENT | 'inv' classname= IDENT COLON_COLON invname= IDENT |pre= assertionStatementPre[s=$s, valid=valid] |post= assertionStatementPost[s=$s, valid=valid] ) ( COMMA msg= STRING )? )
            // TestSuite.g:139:3: s= 'assert' ( 'valid' | 'invalid' ) (exp= expression | 'invs' | 'invs' classname= IDENT | 'inv' classname= IDENT COLON_COLON invname= IDENT |pre= assertionStatementPre[s=$s, valid=valid] |post= assertionStatementPost[s=$s, valid=valid] ) ( COMMA msg= STRING )?
            {
            s=(Token)match(input,59,FOLLOW_59_in_assertStatement336); if (state.failed) return n;

            // TestSuite.g:140:3: ( 'valid' | 'invalid' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==113) ) {
                alt5=1;
            }
            else if ( (LA5_0==86) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // TestSuite.g:140:4: 'valid'
                    {
                    match(input,113,FOLLOW_113_in_assertStatement341); if (state.failed) return n;

                    if ( state.backtracking==0 ) { valid = true; }

                    }
                    break;
                case 2 :
                    // TestSuite.g:140:32: 'invalid'
                    {
                    match(input,86,FOLLOW_86_in_assertStatement347); if (state.failed) return n;

                    if ( state.backtracking==0 ) {valid = false; }

                    }
                    break;

            }


            // TestSuite.g:141:3: (exp= expression | 'invs' | 'invs' classname= IDENT | 'inv' classname= IDENT COLON_COLON invname= IDENT |pre= assertionStatementPre[s=$s, valid=valid] |post= assertionStatementPost[s=$s, valid=valid] )
            int alt6=6;
            switch ( input.LA(1) ) {
            case AT:
            case HASH:
            case IDENT:
            case INT:
            case LPAREN:
            case MINUS:
            case PLUS:
            case REAL:
            case STAR:
            case STRING:
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
            case 56:
            case 77:
            case 80:
            case 88:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 105:
            case 106:
            case 112:
                {
                alt6=1;
                }
                break;
            case 87:
                {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==IDENT) ) {
                    alt6=3;
                }
                else if ( (LA6_2==COMMA||LA6_2==44||LA6_2==59||LA6_2==62||(LA6_2 >= 72 && LA6_2 <= 73)) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;

                }
                }
                break;
            case 85:
                {
                alt6=4;
                }
                break;
            case 104:
                {
                alt6=5;
                }
                break;
            case 103:
                {
                alt6=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // TestSuite.g:142:7: exp= expression
                    {
                    pushFollow(FOLLOW_expression_in_assertStatement366);
                    exp=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTAssertOclExpression((exp!=null?exp.n:null).getStartToken(), input.LT(-1), valid, (exp!=null?exp.n:null)); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:144:7: 'invs'
                    {
                    match(input,87,FOLLOW_87_in_assertStatement382); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTAssertGlobalInvariants(s, input.LT(-1), valid); }

                    }
                    break;
                case 3 :
                    // TestSuite.g:146:7: 'invs' classname= IDENT
                    {
                    match(input,87,FOLLOW_87_in_assertStatement398); if (state.failed) return n;

                    classname=(Token)match(input,IDENT,FOLLOW_IDENT_in_assertStatement402); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTAssertClassInvariants(s, input.LT(-1), valid, classname); }

                    }
                    break;
                case 4 :
                    // TestSuite.g:148:7: 'inv' classname= IDENT COLON_COLON invname= IDENT
                    {
                    match(input,85,FOLLOW_85_in_assertStatement418); if (state.failed) return n;

                    classname=(Token)match(input,IDENT,FOLLOW_IDENT_in_assertStatement422); if (state.failed) return n;

                    match(input,COLON_COLON,FOLLOW_COLON_COLON_in_assertStatement424); if (state.failed) return n;

                    invname=(Token)match(input,IDENT,FOLLOW_IDENT_in_assertStatement428); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTAssertSingleInvariant(s, input.LT(-1), valid, classname, invname); }

                    }
                    break;
                case 5 :
                    // TestSuite.g:150:7: pre= assertionStatementPre[s=$s, valid=valid]
                    {
                    pushFollow(FOLLOW_assertionStatementPre_in_assertStatement448);
                    pre=assertionStatementPre(s=s, valid=valid);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) {n = pre; }

                    }
                    break;
                case 6 :
                    // TestSuite.g:152:7: post= assertionStatementPost[s=$s, valid=valid]
                    {
                    pushFollow(FOLLOW_assertionStatementPost_in_assertStatement469);
                    post=assertionStatementPost(s=s, valid=valid);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) {n = post; }

                    }
                    break;

            }


            // TestSuite.g:154:3: ( COMMA msg= STRING )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==COMMA) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // TestSuite.g:155:5: COMMA msg= STRING
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_assertStatement486); if (state.failed) return n;

                    msg=(Token)match(input,STRING,FOLLOW_STRING_in_assertStatement490); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n.setMessage(msg); }

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
    // $ANTLR end "assertStatement"



    // $ANTLR start "assertionStatementPre"
    // TestSuite.g:159:1: assertionStatementPre[Token s, boolean valid] returns [ASTAssertPre n] : 'pre' objExp= expression opName= IDENT LPAREN (e= expression ( COMMA e= expression )* )? RPAREN ( COLON_COLON name= IDENT )? ;
    public final ASTAssertPre assertionStatementPre(Token s, boolean valid) throws RecognitionException {
        ASTAssertPre n = null;


        Token opName=null;
        Token name=null;
        TestSuiteParser.expression_return objExp =null;

        TestSuiteParser.expression_return e =null;


        try {
            // TestSuite.g:160:3: ( 'pre' objExp= expression opName= IDENT LPAREN (e= expression ( COMMA e= expression )* )? RPAREN ( COLON_COLON name= IDENT )? )
            // TestSuite.g:161:3: 'pre' objExp= expression opName= IDENT LPAREN (e= expression ( COMMA e= expression )* )? RPAREN ( COLON_COLON name= IDENT )?
            {
            match(input,104,FOLLOW_104_in_assertionStatementPre513); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_assertionStatementPre517);
            objExp=expression();

            state._fsp--;
            if (state.failed) return n;

            opName=(Token)match(input,IDENT,FOLLOW_IDENT_in_assertionStatementPre521); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTAssertPre(s, null, valid, (objExp!=null?objExp.n:null), opName); }

            match(input,LPAREN,FOLLOW_LPAREN_in_assertionStatementPre527); if (state.failed) return n;

            // TestSuite.g:163:5: (e= expression ( COMMA e= expression )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==AT||LA9_0==HASH||(LA9_0 >= IDENT && LA9_0 <= INT)||(LA9_0 >= LPAREN && LA9_0 <= MINUS)||LA9_0==PLUS||LA9_0==REAL||(LA9_0 >= STAR && LA9_0 <= STRING)||(LA9_0 >= 45 && LA9_0 <= 56)||LA9_0==77||LA9_0==80||(LA9_0 >= 88 && LA9_0 <= 89)||(LA9_0 >= 92 && LA9_0 <= 99)||(LA9_0 >= 105 && LA9_0 <= 106)||LA9_0==112) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // TestSuite.g:163:7: e= expression ( COMMA e= expression )*
                    {
                    pushFollow(FOLLOW_expression_in_assertionStatementPre538);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n.addArg((e!=null?e.n:null)); }

                    // TestSuite.g:163:41: ( COMMA e= expression )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==COMMA) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // TestSuite.g:163:43: COMMA e= expression
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_assertionStatementPre544); if (state.failed) return n;

                    	    pushFollow(FOLLOW_expression_in_assertionStatementPre548);
                    	    e=expression();

                    	    state._fsp--;
                    	    if (state.failed) return n;

                    	    if ( state.backtracking==0 ) { n.addArg((e!=null?e.n:null)); }

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_assertionStatementPre561); if (state.failed) return n;

            // TestSuite.g:164:10: ( COLON_COLON name= IDENT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==COLON_COLON) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // TestSuite.g:164:11: COLON_COLON name= IDENT
                    {
                    match(input,COLON_COLON,FOLLOW_COLON_COLON_in_assertionStatementPre564); if (state.failed) return n;

                    name=(Token)match(input,IDENT,FOLLOW_IDENT_in_assertionStatementPre568); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n.setConditionName(name); }

                    }
                    break;

            }


            if ( state.backtracking==0 ) { n.setEnd(input.LT(-1)); }

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
    // $ANTLR end "assertionStatementPre"



    // $ANTLR start "assertionStatementPost"
    // TestSuite.g:168:1: assertionStatementPost[Token s, boolean valid] returns [ASTAssertPost n] : 'post' (name= IDENT )? ;
    public final ASTAssertPost assertionStatementPost(Token s, boolean valid) throws RecognitionException {
        ASTAssertPost n = null;


        Token name=null;

        try {
            // TestSuite.g:169:3: ( 'post' (name= IDENT )? )
            // TestSuite.g:170:3: 'post' (name= IDENT )?
            {
            match(input,103,FOLLOW_103_in_assertionStatementPost593); if (state.failed) return n;

            if ( state.backtracking==0 ) { n = new ASTAssertPost(s, null, valid); }

            // TestSuite.g:171:3: (name= IDENT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENT) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // TestSuite.g:171:4: name= IDENT
                    {
                    name=(Token)match(input,IDENT,FOLLOW_IDENT_in_assertionStatementPost602); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n.setConditionName(name); }

                    }
                    break;

            }


            if ( state.backtracking==0 ) { n.setEnd(input.LT(-1)); }

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
    // $ANTLR end "assertionStatementPost"



    // $ANTLR start "expressionOnly"
    // TestSuite.g:201:1: expressionOnly returns [ASTExpression n] : nExp= expression EOF ;
    public final ASTExpression expressionOnly() throws RecognitionException {
        ASTExpression n = null;


        TestSuiteParser.expression_return nExp =null;


        try {
            // TestSuite.g:202:5: (nExp= expression EOF )
            // TestSuite.g:203:5: nExp= expression EOF
            {
            pushFollow(FOLLOW_expression_in_expressionOnly638);
            nExp=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,EOF,FOLLOW_EOF_in_expressionOnly640); if (state.failed) return n;

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
    // TestSuite.g:210:1: expression returns [ASTExpression n] : ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )* nIdExp= identicalExpression ;
    public final TestSuiteParser.expression_return expression() throws RecognitionException {
        TestSuiteParser.expression_return retval = new TestSuiteParser.expression_return();
        retval.start = input.LT(1);


        Token name=null;
        ASTType t =null;

        TestSuiteParser.expression_return e1 =null;

        ASTExpression nIdExp =null;


         
          ASTLetExpression prevLet = null, firstLet = null;
          ASTExpression e2;
          Token tok = null;

        try {
            // TestSuite.g:216:5: ( ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )* nIdExp= identicalExpression )
            // TestSuite.g:217:5: ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )* nIdExp= identicalExpression
            {
            if ( state.backtracking==0 ) { tok = input.LT(1); /* remember start of expression */ }

            // TestSuite.g:218:5: ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==89) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // TestSuite.g:219:7: 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in'
            	    {
            	    match(input,89,FOLLOW_89_in_expression688); if (state.failed) return retval;

            	    name=(Token)match(input,IDENT,FOLLOW_IDENT_in_expression699); if (state.failed) return retval;

            	    // TestSuite.g:220:18: ( COLON t= type )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==COLON) ) {
            	        alt12=1;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // TestSuite.g:220:20: COLON t= type
            	            {
            	            match(input,COLON,FOLLOW_COLON_in_expression703); if (state.failed) return retval;

            	            pushFollow(FOLLOW_type_in_expression707);
            	            t=type();

            	            state._fsp--;
            	            if (state.failed) return retval;

            	            }
            	            break;

            	    }


            	    match(input,EQUAL,FOLLOW_EQUAL_in_expression712); if (state.failed) return retval;

            	    pushFollow(FOLLOW_expression_in_expression716);
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

            	    // TestSuite.g:230:7: ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )*
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==COMMA) ) {
            	            alt14=1;
            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // TestSuite.g:231:7: COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression
            	    	    {
            	    	    match(input,COMMA,FOLLOW_COMMA_in_expression754); if (state.failed) return retval;

            	    	    name=(Token)match(input,IDENT,FOLLOW_IDENT_in_expression766); if (state.failed) return retval;

            	    	    // TestSuite.g:232:20: ( COLON t= type )?
            	    	    int alt13=2;
            	    	    int LA13_0 = input.LA(1);

            	    	    if ( (LA13_0==COLON) ) {
            	    	        alt13=1;
            	    	    }
            	    	    switch (alt13) {
            	    	        case 1 :
            	    	            // TestSuite.g:232:22: COLON t= type
            	    	            {
            	    	            match(input,COLON,FOLLOW_COLON_in_expression770); if (state.failed) return retval;

            	    	            pushFollow(FOLLOW_type_in_expression774);
            	    	            t=type();

            	    	            state._fsp--;
            	    	            if (state.failed) return retval;

            	    	            }
            	    	            break;

            	    	    }


            	    	    match(input,EQUAL,FOLLOW_EQUAL_in_expression779); if (state.failed) return retval;

            	    	    pushFollow(FOLLOW_expression_in_expression783);
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
            	    	    break loop14;
            	        }
            	    } while (true);


            	    match(input,82,FOLLOW_82_in_expression824); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            pushFollow(FOLLOW_identicalExpression_in_expression840);
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
    // TestSuite.g:264:1: paramList returns [List<ASTVariableDeclaration> paramList] : LPAREN (v= variableDeclaration ( COMMA v= variableDeclaration )* )? RPAREN ;
    public final List<ASTVariableDeclaration> paramList() throws RecognitionException {
        List<ASTVariableDeclaration> paramList = null;


        ASTVariableDeclaration v =null;


         paramList = new ArrayList<ASTVariableDeclaration>(); 
        try {
            // TestSuite.g:266:5: ( LPAREN (v= variableDeclaration ( COMMA v= variableDeclaration )* )? RPAREN )
            // TestSuite.g:267:5: LPAREN (v= variableDeclaration ( COMMA v= variableDeclaration )* )? RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_paramList873); if (state.failed) return paramList;

            // TestSuite.g:268:5: (v= variableDeclaration ( COMMA v= variableDeclaration )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==IDENT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // TestSuite.g:269:7: v= variableDeclaration ( COMMA v= variableDeclaration )*
                    {
                    pushFollow(FOLLOW_variableDeclaration_in_paramList890);
                    v=variableDeclaration();

                    state._fsp--;
                    if (state.failed) return paramList;

                    if ( state.backtracking==0 ) { paramList.add(v); }

                    // TestSuite.g:270:7: ( COMMA v= variableDeclaration )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==COMMA) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // TestSuite.g:270:9: COMMA v= variableDeclaration
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_paramList902); if (state.failed) return paramList;

                    	    pushFollow(FOLLOW_variableDeclaration_in_paramList906);
                    	    v=variableDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return paramList;

                    	    if ( state.backtracking==0 ) { paramList.add(v); }

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_paramList926); if (state.failed) return paramList;

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
    // TestSuite.g:278:1: idList returns [List idList] : id0= IDENT ( COMMA idn= IDENT )* ;
    public final List idList() throws RecognitionException {
        List idList = null;


        Token id0=null;
        Token idn=null;

         idList = new ArrayList(); 
        try {
            // TestSuite.g:280:5: (id0= IDENT ( COMMA idn= IDENT )* )
            // TestSuite.g:281:5: id0= IDENT ( COMMA idn= IDENT )*
            {
            id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_idList955); if (state.failed) return idList;

            if ( state.backtracking==0 ) { idList.add(id0); }

            // TestSuite.g:282:5: ( COMMA idn= IDENT )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==COMMA) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // TestSuite.g:282:7: COMMA idn= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_idList965); if (state.failed) return idList;

            	    idn=(Token)match(input,IDENT,FOLLOW_IDENT_in_idList969); if (state.failed) return idList;

            	    if ( state.backtracking==0 ) { idList.add(idn); }

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
        return idList;
    }
    // $ANTLR end "idList"



    // $ANTLR start "variableDeclaration"
    // TestSuite.g:290:1: variableDeclaration returns [ASTVariableDeclaration n] : name= IDENT COLON t= type ;
    public final ASTVariableDeclaration variableDeclaration() throws RecognitionException {
        ASTVariableDeclaration n = null;


        Token name=null;
        ASTType t =null;


        try {
            // TestSuite.g:291:5: (name= IDENT COLON t= type )
            // TestSuite.g:292:5: name= IDENT COLON t= type
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_variableDeclaration1000); if (state.failed) return n;

            match(input,COLON,FOLLOW_COLON_in_variableDeclaration1002); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_variableDeclaration1006);
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
    // TestSuite.g:300:1: identicalExpression returns [ASTExpression n] : conImpExp= conditionalImpliesExpression ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )* ;
    public final ASTExpression identicalExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression conImpExp =null;

        ASTExpression n1 =null;


        try {
            // TestSuite.g:301:5: (conImpExp= conditionalImpliesExpression ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )* )
            // TestSuite.g:302:5: conImpExp= conditionalImpliesExpression ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )*
            {
            pushFollow(FOLLOW_conditionalImpliesExpression_in_identicalExpression1037);
            conImpExp=conditionalImpliesExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = conImpExp; }

            // TestSuite.g:303:5: ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==DOT) ) {
                    int LA19_2 = input.LA(2);

                    if ( (LA19_2==75) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // TestSuite.g:304:9: DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_identicalExpression1055); if (state.failed) return n;

            	    op=(Token)match(input,75,FOLLOW_75_in_identicalExpression1059); if (state.failed) return n;

            	    match(input,LPAREN,FOLLOW_LPAREN_in_identicalExpression1061); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalImpliesExpression_in_identicalExpression1065);
            	    n1=conditionalImpliesExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    match(input,RPAREN,FOLLOW_RPAREN_in_identicalExpression1067); if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

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
    // $ANTLR end "identicalExpression"



    // $ANTLR start "conditionalImpliesExpression"
    // TestSuite.g:313:1: conditionalImpliesExpression returns [ASTExpression n] : nCndOrExp= conditionalOrExpression (op= 'implies' n1= conditionalOrExpression )* ;
    public final ASTExpression conditionalImpliesExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nCndOrExp =null;

        ASTExpression n1 =null;


        try {
            // TestSuite.g:314:5: (nCndOrExp= conditionalOrExpression (op= 'implies' n1= conditionalOrExpression )* )
            // TestSuite.g:315:5: nCndOrExp= conditionalOrExpression (op= 'implies' n1= conditionalOrExpression )*
            {
            pushFollow(FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression1110);
            nCndOrExp=conditionalOrExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nCndOrExp;}

            // TestSuite.g:316:5: (op= 'implies' n1= conditionalOrExpression )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==81) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // TestSuite.g:316:7: op= 'implies' n1= conditionalOrExpression
            	    {
            	    op=(Token)match(input,81,FOLLOW_81_in_conditionalImpliesExpression1123); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression1127);
            	    n1=conditionalOrExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // TestSuite.g:325:1: conditionalOrExpression returns [ASTExpression n] : nCndXorExp= conditionalXOrExpression (op= 'or' n1= conditionalXOrExpression )* ;
    public final ASTExpression conditionalOrExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nCndXorExp =null;

        ASTExpression n1 =null;


        try {
            // TestSuite.g:326:5: (nCndXorExp= conditionalXOrExpression (op= 'or' n1= conditionalXOrExpression )* )
            // TestSuite.g:327:5: nCndXorExp= conditionalXOrExpression (op= 'or' n1= conditionalXOrExpression )*
            {
            pushFollow(FOLLOW_conditionalXOrExpression_in_conditionalOrExpression1172);
            nCndXorExp=conditionalXOrExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nCndXorExp;}

            // TestSuite.g:328:5: (op= 'or' n1= conditionalXOrExpression )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==102) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // TestSuite.g:328:7: op= 'or' n1= conditionalXOrExpression
            	    {
            	    op=(Token)match(input,102,FOLLOW_102_in_conditionalOrExpression1185); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalXOrExpression_in_conditionalOrExpression1189);
            	    n1=conditionalXOrExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

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
    // $ANTLR end "conditionalOrExpression"



    // $ANTLR start "conditionalXOrExpression"
    // TestSuite.g:337:1: conditionalXOrExpression returns [ASTExpression n] : nCndAndExp= conditionalAndExpression (op= 'xor' n1= conditionalAndExpression )* ;
    public final ASTExpression conditionalXOrExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nCndAndExp =null;

        ASTExpression n1 =null;


        try {
            // TestSuite.g:338:5: (nCndAndExp= conditionalAndExpression (op= 'xor' n1= conditionalAndExpression )* )
            // TestSuite.g:339:5: nCndAndExp= conditionalAndExpression (op= 'xor' n1= conditionalAndExpression )*
            {
            pushFollow(FOLLOW_conditionalAndExpression_in_conditionalXOrExpression1233);
            nCndAndExp=conditionalAndExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nCndAndExp;}

            // TestSuite.g:340:5: (op= 'xor' n1= conditionalAndExpression )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==115) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // TestSuite.g:340:7: op= 'xor' n1= conditionalAndExpression
            	    {
            	    op=(Token)match(input,115,FOLLOW_115_in_conditionalXOrExpression1246); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalAndExpression_in_conditionalXOrExpression1250);
            	    n1=conditionalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

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
    // $ANTLR end "conditionalXOrExpression"



    // $ANTLR start "conditionalAndExpression"
    // TestSuite.g:349:1: conditionalAndExpression returns [ASTExpression n] : nEqExp= equalityExpression (op= 'and' n1= equalityExpression )* ;
    public final ASTExpression conditionalAndExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nEqExp =null;

        ASTExpression n1 =null;


        try {
            // TestSuite.g:350:5: (nEqExp= equalityExpression (op= 'and' n1= equalityExpression )* )
            // TestSuite.g:351:5: nEqExp= equalityExpression (op= 'and' n1= equalityExpression )*
            {
            pushFollow(FOLLOW_equalityExpression_in_conditionalAndExpression1294);
            nEqExp=equalityExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nEqExp;}

            // TestSuite.g:352:5: (op= 'and' n1= equalityExpression )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==58) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // TestSuite.g:352:7: op= 'and' n1= equalityExpression
            	    {
            	    op=(Token)match(input,58,FOLLOW_58_in_conditionalAndExpression1307); if (state.failed) return n;

            	    pushFollow(FOLLOW_equalityExpression_in_conditionalAndExpression1311);
            	    n1=equalityExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // TestSuite.g:361:1: equalityExpression returns [ASTExpression n] : nRelExp= relationalExpression ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )* ;
    public final ASTExpression equalityExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nRelExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // TestSuite.g:363:5: (nRelExp= relationalExpression ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )* )
            // TestSuite.g:364:5: nRelExp= relationalExpression ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )*
            {
            pushFollow(FOLLOW_relationalExpression_in_equalityExpression1359);
            nRelExp=relationalExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nRelExp;}

            // TestSuite.g:365:5: ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==EQUAL||LA24_0==NOT_EQUAL) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // TestSuite.g:365:7: ( EQUAL | NOT_EQUAL ) n1= relationalExpression
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


            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression1388);
            	    n1=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

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
    // $ANTLR end "equalityExpression"



    // $ANTLR start "relationalExpression"
    // TestSuite.g:375:1: relationalExpression returns [ASTExpression n] : nAddiExp= additiveExpression ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )* ;
    public final ASTExpression relationalExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nAddiExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // TestSuite.g:377:5: (nAddiExp= additiveExpression ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )* )
            // TestSuite.g:378:5: nAddiExp= additiveExpression ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )*
            {
            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1437);
            nAddiExp=additiveExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nAddiExp;}

            // TestSuite.g:379:5: ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0 >= GREATER && LA25_0 <= GREATER_EQUAL)||(LA25_0 >= LESS && LA25_0 <= LESS_EQUAL)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // TestSuite.g:379:7: ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression
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


            	    pushFollow(FOLLOW_additiveExpression_in_relationalExpression1473);
            	    n1=additiveExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // TestSuite.g:389:1: additiveExpression returns [ASTExpression n] : nMulExp= multiplicativeExpression ( ( PLUS | MINUS ) n1= multiplicativeExpression )* ;
    public final ASTExpression additiveExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nMulExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // TestSuite.g:391:5: (nMulExp= multiplicativeExpression ( ( PLUS | MINUS ) n1= multiplicativeExpression )* )
            // TestSuite.g:392:5: nMulExp= multiplicativeExpression ( ( PLUS | MINUS ) n1= multiplicativeExpression )*
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1523);
            nMulExp=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nMulExp;}

            // TestSuite.g:393:5: ( ( PLUS | MINUS ) n1= multiplicativeExpression )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==MINUS||LA26_0==PLUS) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // TestSuite.g:393:7: ( PLUS | MINUS ) n1= multiplicativeExpression
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


            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1551);
            	    n1=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // TestSuite.g:404:1: multiplicativeExpression returns [ASTExpression n] : nUnExp= unaryExpression ( ( STAR | SLASH | 'div' ) n1= unaryExpression )* ;
    public final ASTExpression multiplicativeExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nUnExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // TestSuite.g:406:5: (nUnExp= unaryExpression ( ( STAR | SLASH | 'div' ) n1= unaryExpression )* )
            // TestSuite.g:407:5: nUnExp= unaryExpression ( ( STAR | SLASH | 'div' ) n1= unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1601);
            nUnExp=unaryExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n = nUnExp;}

            // TestSuite.g:408:5: ( ( STAR | SLASH | 'div' ) n1= unaryExpression )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==SLASH||LA27_0==STAR||LA27_0==69) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // TestSuite.g:408:7: ( STAR | SLASH | 'div' ) n1= unaryExpression
            	    {
            	    if ( state.backtracking==0 ) { op = input.LT(1); }

            	    if ( input.LA(1)==SLASH||input.LA(1)==STAR||input.LA(1)==69 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return n;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1633);
            	    n1=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // TestSuite.g:420:1: unaryExpression returns [ASTExpression n] : ( ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression ) |nPosExp= postfixExpression );
    public final ASTExpression unaryExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nUnExp =null;

        ASTExpression nPosExp =null;


         Token op = null; 
        try {
            // TestSuite.g:422:7: ( ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression ) |nPosExp= postfixExpression )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==MINUS||LA28_0==PLUS||LA28_0==92) ) {
                alt28=1;
            }
            else if ( (LA28_0==AT||LA28_0==HASH||(LA28_0 >= IDENT && LA28_0 <= INT)||LA28_0==LPAREN||LA28_0==REAL||(LA28_0 >= STAR && LA28_0 <= STRING)||(LA28_0 >= 45 && LA28_0 <= 56)||LA28_0==77||LA28_0==80||LA28_0==88||(LA28_0 >= 93 && LA28_0 <= 99)||(LA28_0 >= 105 && LA28_0 <= 106)||LA28_0==112) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }
            switch (alt28) {
                case 1 :
                    // TestSuite.g:423:7: ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression )
                    {
                    // TestSuite.g:423:7: ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression )
                    // TestSuite.g:423:9: ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression
                    {
                    if ( state.backtracking==0 ) { op = input.LT(1); }

                    if ( input.LA(1)==MINUS||input.LA(1)==PLUS||input.LA(1)==92 ) {
                        input.consume();
                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression1719);
                    nUnExp=unaryExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUnaryExpression(op, nUnExp); }

                    }


                    }
                    break;
                case 2 :
                    // TestSuite.g:427:7: nPosExp= postfixExpression
                    {
                    pushFollow(FOLLOW_postfixExpression_in_unaryExpression1739);
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
    // TestSuite.g:435:1: postfixExpression returns [ASTExpression n] : nPrimExp= primaryExpression ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )* ;
    public final ASTExpression postfixExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nPrimExp =null;

        ASTExpression nPc =null;


         boolean arrow = false; 
        try {
            // TestSuite.g:437:5: (nPrimExp= primaryExpression ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )* )
            // TestSuite.g:438:5: nPrimExp= primaryExpression ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )*
            {
            pushFollow(FOLLOW_primaryExpression_in_postfixExpression1772);
            nPrimExp=primaryExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n = nPrimExp; }

            // TestSuite.g:439:5: ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==DOT) ) {
                    int LA30_2 = input.LA(2);

                    if ( (LA30_2==IDENT) ) {
                        int LA30_4 = input.LA(3);

                        if ( (LA30_4==EOF||(LA30_4 >= ARROW && LA30_4 <= BAR)||(LA30_4 >= COMMA && LA30_4 <= EQUAL)||(LA30_4 >= GREATER && LA30_4 <= GREATER_EQUAL)||LA30_4==IDENT||(LA30_4 >= LBRACE && LA30_4 <= MINUS)||(LA30_4 >= NOT_EQUAL && LA30_4 <= PLUS)||(LA30_4 >= RBRACE && LA30_4 <= RBRACK)||(LA30_4 >= RPAREN && LA30_4 <= SLASH)||LA30_4==STAR||LA30_4==44||(LA30_4 >= 58 && LA30_4 <= 60)||LA30_4==62||LA30_4==65||(LA30_4 >= 67 && LA30_4 <= 74)||LA30_4==76||(LA30_4 >= 81 && LA30_4 <= 83)||LA30_4==89||LA30_4==102||LA30_4==107||LA30_4==111||LA30_4==115) ) {
                            alt30=1;
                        }


                    }
                    else if ( (LA30_2==88||LA30_2==94||(LA30_2 >= 96 && LA30_2 <= 98)||(LA30_2 >= 105 && LA30_2 <= 106)) ) {
                        alt30=1;
                    }


                }
                else if ( (LA30_0==ARROW) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // TestSuite.g:440:6: ( ARROW | DOT ) nPc= propertyCall[$n, arrow]
            	    {
            	    // TestSuite.g:440:6: ( ARROW | DOT )
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==ARROW) ) {
            	        alt29=1;
            	    }
            	    else if ( (LA29_0==DOT) ) {
            	        alt29=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return n;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 29, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // TestSuite.g:440:8: ARROW
            	            {
            	            match(input,ARROW,FOLLOW_ARROW_in_postfixExpression1790); if (state.failed) return n;

            	            if ( state.backtracking==0 ) { arrow = true; }

            	            }
            	            break;
            	        case 2 :
            	            // TestSuite.g:440:34: DOT
            	            {
            	            match(input,DOT,FOLLOW_DOT_in_postfixExpression1796); if (state.failed) return n;

            	            if ( state.backtracking==0 ) { arrow = false; }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_propertyCall_in_postfixExpression1807);
            	    nPc=propertyCall(n, arrow);

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = nPc; }

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // TestSuite.g:456:1: primaryExpression returns [ASTExpression n] : (nLit= literal |nOr= objectReference |nPc= propertyCall[null, false] | LPAREN nExp= expression RPAREN |nIfExp= ifExpression |id1= IDENT DOT 'allInstances' ( AT 'pre' )? ( LPAREN RPAREN )? |id2= IDENT DOT 'byUseId' ( LPAREN idExp= expression RPAREN ) ( AT 'pre' )? );
    public final ASTExpression primaryExpression() throws RecognitionException {
        ASTExpression n = null;


        Token id1=null;
        Token id2=null;
        ASTExpression nLit =null;

        ASTExpression nOr =null;

        ASTExpression nPc =null;

        TestSuiteParser.expression_return nExp =null;

        ASTExpression nIfExp =null;

        TestSuiteParser.expression_return idExp =null;


        try {
            // TestSuite.g:457:7: (nLit= literal |nOr= objectReference |nPc= propertyCall[null, false] | LPAREN nExp= expression RPAREN |nIfExp= ifExpression |id1= IDENT DOT 'allInstances' ( AT 'pre' )? ( LPAREN RPAREN )? |id2= IDENT DOT 'byUseId' ( LPAREN idExp= expression RPAREN ) ( AT 'pre' )? )
            int alt34=7;
            switch ( input.LA(1) ) {
            case HASH:
            case INT:
            case REAL:
            case STAR:
            case STRING:
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
            case 56:
            case 77:
            case 93:
            case 95:
            case 99:
            case 112:
                {
                alt34=1;
                }
                break;
            case IDENT:
                {
                switch ( input.LA(2) ) {
                case COLON_COLON:
                    {
                    alt34=1;
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
                case IDENT:
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
                case 44:
                case 58:
                case 59:
                case 60:
                case 62:
                case 65:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 76:
                case 81:
                case 82:
                case 83:
                case 89:
                case 102:
                case 107:
                case 111:
                case 115:
                    {
                    alt34=3;
                    }
                    break;
                case DOT:
                    {
                    switch ( input.LA(3) ) {
                    case 57:
                        {
                        alt34=6;
                        }
                        break;
                    case 64:
                        {
                        alt34=7;
                        }
                        break;
                    case IDENT:
                    case 75:
                    case 88:
                    case 94:
                    case 96:
                    case 97:
                    case 98:
                    case 105:
                    case 106:
                        {
                        alt34=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return n;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 7, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 2, input);

                    throw nvae;

                }

                }
                break;
            case AT:
                {
                alt34=2;
                }
                break;
            case 88:
            case 94:
            case 96:
            case 97:
            case 98:
            case 105:
            case 106:
                {
                alt34=3;
                }
                break;
            case LPAREN:
                {
                alt34=4;
                }
                break;
            case 80:
                {
                alt34=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }

            switch (alt34) {
                case 1 :
                    // TestSuite.g:458:7: nLit= literal
                    {
                    pushFollow(FOLLOW_literal_in_primaryExpression1847);
                    nLit=literal();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nLit; }

                    }
                    break;
                case 2 :
                    // TestSuite.g:459:7: nOr= objectReference
                    {
                    pushFollow(FOLLOW_objectReference_in_primaryExpression1861);
                    nOr=objectReference();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nOr; }

                    }
                    break;
                case 3 :
                    // TestSuite.g:460:7: nPc= propertyCall[null, false]
                    {
                    pushFollow(FOLLOW_propertyCall_in_primaryExpression1873);
                    nPc=propertyCall(null, false);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nPc; }

                    }
                    break;
                case 4 :
                    // TestSuite.g:461:7: LPAREN nExp= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression1884); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_primaryExpression1888);
                    nExp=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression1890); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (nExp!=null?nExp.n:null); }

                    }
                    break;
                case 5 :
                    // TestSuite.g:462:7: nIfExp= ifExpression
                    {
                    pushFollow(FOLLOW_ifExpression_in_primaryExpression1902);
                    nIfExp=ifExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nIfExp; }

                    }
                    break;
                case 6 :
                    // TestSuite.g:463:7: id1= IDENT DOT 'allInstances' ( AT 'pre' )? ( LPAREN RPAREN )?
                    {
                    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_primaryExpression1914); if (state.failed) return n;

                    match(input,DOT,FOLLOW_DOT_in_primaryExpression1916); if (state.failed) return n;

                    match(input,57,FOLLOW_57_in_primaryExpression1918); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTAllInstancesExpression(id1); }

                    // TestSuite.g:465:9: ( AT 'pre' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==AT) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // TestSuite.g:465:11: AT 'pre'
                            {
                            match(input,AT,FOLLOW_AT_in_primaryExpression1941); if (state.failed) return n;

                            match(input,104,FOLLOW_104_in_primaryExpression1943); if (state.failed) return n;

                            if ( state.backtracking==0 ) { n.setIsPre(); }

                            }
                            break;

                    }


                    // TestSuite.g:466:9: ( LPAREN RPAREN )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==LPAREN) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // TestSuite.g:466:11: LPAREN RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression1961); if (state.failed) return n;

                            match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression1963); if (state.failed) return n;

                            }
                            break;

                    }


                    }
                    break;
                case 7 :
                    // TestSuite.g:467:7: id2= IDENT DOT 'byUseId' ( LPAREN idExp= expression RPAREN ) ( AT 'pre' )?
                    {
                    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_primaryExpression1976); if (state.failed) return n;

                    match(input,DOT,FOLLOW_DOT_in_primaryExpression1978); if (state.failed) return n;

                    match(input,64,FOLLOW_64_in_primaryExpression1980); if (state.failed) return n;

                    // TestSuite.g:467:31: ( LPAREN idExp= expression RPAREN )
                    // TestSuite.g:467:33: LPAREN idExp= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression1984); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_primaryExpression1988);
                    idExp=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression1990); if (state.failed) return n;

                    }


                    if ( state.backtracking==0 ) { n = new ASTObjectByUseIdExpression(id2, (idExp!=null?idExp.n:null)); }

                    // TestSuite.g:469:7: ( AT 'pre' )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==AT) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // TestSuite.g:469:9: AT 'pre'
                            {
                            match(input,AT,FOLLOW_AT_in_primaryExpression2010); if (state.failed) return n;

                            match(input,104,FOLLOW_104_in_primaryExpression2012); if (state.failed) return n;

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
    // TestSuite.g:473:1: objectReference returns [ASTExpression n] : AT objectName= IDENT ;
    public final ASTExpression objectReference() throws RecognitionException {
        ASTExpression n = null;


        Token objectName=null;

        try {
            // TestSuite.g:474:3: ( AT objectName= IDENT )
            // TestSuite.g:475:3: AT objectName= IDENT
            {
            match(input,AT,FOLLOW_AT_in_objectReference2038); if (state.failed) return n;

            objectName=(Token)match(input,IDENT,FOLLOW_IDENT_in_objectReference2046); if (state.failed) return n;

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
    // TestSuite.g:489:1: propertyCall[ASTExpression source, boolean followsArrow] returns [ASTExpression n] : ({...}?{...}?nExpQuery= queryExpression[source] |nExpIterate= iterateExpression[source] |nExpOperation= operationExpression[source, followsArrow] |nExpType= typeExpression[source, followsArrow] |nExpInState= inStateExpression[source, followsArrow] );
    public final ASTExpression propertyCall(ASTExpression source, boolean followsArrow) throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nExpQuery =null;

        ASTExpression nExpIterate =null;

        TestSuiteParser.operationExpression_return nExpOperation =null;

        ASTTypeArgExpression nExpType =null;

        ASTInStateExpression nExpInState =null;


        try {
            // TestSuite.g:490:7: ({...}?{...}?nExpQuery= queryExpression[source] |nExpIterate= iterateExpression[source] |nExpOperation= operationExpression[source, followsArrow] |nExpType= typeExpression[source, followsArrow] |nExpInState= inStateExpression[source, followsArrow] )
            int alt35=5;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA35_1 = input.LA(2);

                if ( (((( input.LA(2) == LPAREN )&&( input.LA(2) == LPAREN ))&&( org.tzi.use.parser.base.ParserHelper.isQueryIdent(input.LT(1)) ))) ) {
                    alt35=1;
                }
                else if ( (true) ) {
                    alt35=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;

                }
                }
                break;
            case 88:
                {
                alt35=2;
                }
                break;
            case 94:
            case 97:
            case 98:
            case 105:
            case 106:
                {
                alt35=4;
                }
                break;
            case 96:
                {
                alt35=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }

            switch (alt35) {
                case 1 :
                    // TestSuite.g:494:7: {...}?{...}?nExpQuery= queryExpression[source]
                    {
                    if ( !(( org.tzi.use.parser.base.ParserHelper.isQueryIdent(input.LT(1)) )) ) {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        throw new FailedPredicateException(input, "propertyCall", " org.tzi.use.parser.base.ParserHelper.isQueryIdent(input.LT(1)) ");
                    }

                    if ( !(( input.LA(2) == LPAREN )) ) {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        throw new FailedPredicateException(input, "propertyCall", " input.LA(2) == LPAREN ");
                    }

                    pushFollow(FOLLOW_queryExpression_in_propertyCall2111);
                    nExpQuery=queryExpression(source);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nExpQuery; }

                    }
                    break;
                case 2 :
                    // TestSuite.g:497:7: nExpIterate= iterateExpression[source]
                    {
                    pushFollow(FOLLOW_iterateExpression_in_propertyCall2124);
                    nExpIterate=iterateExpression(source);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nExpIterate; }

                    }
                    break;
                case 3 :
                    // TestSuite.g:498:7: nExpOperation= operationExpression[source, followsArrow]
                    {
                    pushFollow(FOLLOW_operationExpression_in_propertyCall2137);
                    nExpOperation=operationExpression(source, followsArrow);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (nExpOperation!=null?nExpOperation.n:null); }

                    }
                    break;
                case 4 :
                    // TestSuite.g:499:7: nExpType= typeExpression[source, followsArrow]
                    {
                    pushFollow(FOLLOW_typeExpression_in_propertyCall2150);
                    nExpType=typeExpression(source, followsArrow);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nExpType; }

                    }
                    break;
                case 5 :
                    // TestSuite.g:500:7: nExpInState= inStateExpression[source, followsArrow]
                    {
                    pushFollow(FOLLOW_inStateExpression_in_propertyCall2163);
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
    // TestSuite.g:509:1: queryExpression[ASTExpression range] returns [ASTExpression n] : op= IDENT LPAREN (decls= elemVarsDeclaration BAR )? nExp= expression ( COMMA uncerExp= additiveExpression )? RPAREN ;
    public final ASTExpression queryExpression(ASTExpression range) throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTElemVarsDeclaration decls =null;

        TestSuiteParser.expression_return nExp =null;

        ASTExpression uncerExp =null;



                ASTElemVarsDeclaration decl = new ASTElemVarsDeclaration();
                ASTExpression uncer = null;
            
        try {
            // TestSuite.g:513:6: (op= IDENT LPAREN (decls= elemVarsDeclaration BAR )? nExp= expression ( COMMA uncerExp= additiveExpression )? RPAREN )
            // TestSuite.g:514:5: op= IDENT LPAREN (decls= elemVarsDeclaration BAR )? nExp= expression ( COMMA uncerExp= additiveExpression )? RPAREN
            {
            op=(Token)match(input,IDENT,FOLLOW_IDENT_in_queryExpression2198); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_queryExpression2205); if (state.failed) return n;

            // TestSuite.g:516:5: (decls= elemVarsDeclaration BAR )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==IDENT) ) {
                int LA36_1 = input.LA(2);

                if ( ((LA36_1 >= BAR && LA36_1 <= COLON)) ) {
                    alt36=1;
                }
                else if ( (LA36_1==COMMA) ) {
                    int LA36_4 = input.LA(3);

                    if ( (LA36_4==IDENT) ) {
                        int LA36_5 = input.LA(4);

                        if ( ((LA36_5 >= BAR && LA36_5 <= COLON)||LA36_5==COMMA) ) {
                            alt36=1;
                        }
                    }
                }
            }
            switch (alt36) {
                case 1 :
                    // TestSuite.g:516:7: decls= elemVarsDeclaration BAR
                    {
                    pushFollow(FOLLOW_elemVarsDeclaration_in_queryExpression2216);
                    decls=elemVarsDeclaration();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) {decl = decls;}

                    match(input,BAR,FOLLOW_BAR_in_queryExpression2220); if (state.failed) return n;

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_queryExpression2231);
            nExp=expression();

            state._fsp--;
            if (state.failed) return n;

            // TestSuite.g:518:5: ( COMMA uncerExp= additiveExpression )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==COMMA) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // TestSuite.g:518:7: COMMA uncerExp= additiveExpression
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_queryExpression2239); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_queryExpression2243);
                    uncerExp=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { uncer = uncerExp;}

                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_queryExpression2254); if (state.failed) return n;

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
    // TestSuite.g:531:1: iterateExpression[ASTExpression range] returns [ASTExpression n] : i= 'iterate' LPAREN decls= elemVarsDeclaration SEMI init= variableInitialization BAR nExp= expression RPAREN ;
    public final ASTExpression iterateExpression(ASTExpression range) throws RecognitionException {
        ASTExpression n = null;


        Token i=null;
        ASTElemVarsDeclaration decls =null;

        ASTVariableInitialization init =null;

        TestSuiteParser.expression_return nExp =null;


        try {
            // TestSuite.g:531:65: (i= 'iterate' LPAREN decls= elemVarsDeclaration SEMI init= variableInitialization BAR nExp= expression RPAREN )
            // TestSuite.g:532:5: i= 'iterate' LPAREN decls= elemVarsDeclaration SEMI init= variableInitialization BAR nExp= expression RPAREN
            {
            i=(Token)match(input,88,FOLLOW_88_in_iterateExpression2286); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_iterateExpression2292); if (state.failed) return n;

            pushFollow(FOLLOW_elemVarsDeclaration_in_iterateExpression2300);
            decls=elemVarsDeclaration();

            state._fsp--;
            if (state.failed) return n;

            match(input,SEMI,FOLLOW_SEMI_in_iterateExpression2302); if (state.failed) return n;

            pushFollow(FOLLOW_variableInitialization_in_iterateExpression2310);
            init=variableInitialization();

            state._fsp--;
            if (state.failed) return n;

            match(input,BAR,FOLLOW_BAR_in_iterateExpression2312); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_iterateExpression2320);
            nExp=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_iterateExpression2326); if (state.failed) return n;

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
    // TestSuite.g:553:1: operationExpression[ASTExpression source, boolean followsArrow] returns [ASTOperationExpression n] : name= IDENT ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )? ( AT 'pre' )? ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )? ;
    public final TestSuiteParser.operationExpression_return operationExpression(ASTExpression source, boolean followsArrow) throws RecognitionException {
        TestSuiteParser.operationExpression_return retval = new TestSuiteParser.operationExpression_return();
        retval.start = input.LT(1);


        Token name=null;
        TestSuiteParser.expression_return rolename =null;

        TestSuiteParser.expression_return e =null;


        try {
            // TestSuite.g:555:5: (name= IDENT ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )? ( AT 'pre' )? ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )? )
            // TestSuite.g:556:5: name= IDENT ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )? ( AT 'pre' )? ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )?
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_operationExpression2370); if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n = new ASTOperationExpression(name, source, followsArrow); }

            // TestSuite.g:562:5: ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==LBRACK) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // TestSuite.g:562:7: LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )?
                    {
                    match(input,LBRACK,FOLLOW_LBRACK_in_operationExpression2392); if (state.failed) return retval;

                    pushFollow(FOLLOW_expression_in_operationExpression2405);
                    rolename=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.addExplicitRolenameOrQualifier((rolename!=null?rolename.n:null)); }

                    // TestSuite.g:564:9: ( COMMA rolename= expression )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==COMMA) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // TestSuite.g:564:10: COMMA rolename= expression
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_operationExpression2418); if (state.failed) return retval;

                    	    pushFollow(FOLLOW_expression_in_operationExpression2422);
                    	    rolename=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) { retval.n.addExplicitRolenameOrQualifier((rolename!=null?rolename.n:null)); }

                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    match(input,RBRACK,FOLLOW_RBRACK_in_operationExpression2434); if (state.failed) return retval;

                    // TestSuite.g:567:7: ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==LBRACK) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // TestSuite.g:567:9: LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK
                            {
                            match(input,LBRACK,FOLLOW_LBRACK_in_operationExpression2451); if (state.failed) return retval;

                            pushFollow(FOLLOW_expression_in_operationExpression2466);
                            rolename=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            if ( state.backtracking==0 ) { retval.n.addQualifier((rolename!=null?rolename.n:null)); }

                            // TestSuite.g:569:11: ( COMMA rolename= expression )*
                            loop39:
                            do {
                                int alt39=2;
                                int LA39_0 = input.LA(1);

                                if ( (LA39_0==COMMA) ) {
                                    alt39=1;
                                }


                                switch (alt39) {
                            	case 1 :
                            	    // TestSuite.g:569:12: COMMA rolename= expression
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_operationExpression2481); if (state.failed) return retval;

                            	    pushFollow(FOLLOW_expression_in_operationExpression2485);
                            	    rolename=expression();

                            	    state._fsp--;
                            	    if (state.failed) return retval;

                            	    if ( state.backtracking==0 ) { retval.n.addQualifier((rolename!=null?rolename.n:null)); }

                            	    }
                            	    break;

                            	default :
                            	    break loop39;
                                }
                            } while (true);


                            match(input,RBRACK,FOLLOW_RBRACK_in_operationExpression2499); if (state.failed) return retval;

                            }
                            break;

                    }


                    }
                    break;

            }


            // TestSuite.g:574:5: ( AT 'pre' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==AT) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // TestSuite.g:574:7: AT 'pre'
                    {
                    match(input,AT,FOLLOW_AT_in_operationExpression2524); if (state.failed) return retval;

                    match(input,104,FOLLOW_104_in_operationExpression2526); if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.setIsPre(); }

                    }
                    break;

            }


            // TestSuite.g:576:5: ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==LPAREN) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // TestSuite.g:577:7: LPAREN (e= expression ( COMMA e= expression )* )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_operationExpression2551); if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.hasParentheses(); }

                    // TestSuite.g:578:7: (e= expression ( COMMA e= expression )* )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==AT||LA44_0==HASH||(LA44_0 >= IDENT && LA44_0 <= INT)||(LA44_0 >= LPAREN && LA44_0 <= MINUS)||LA44_0==PLUS||LA44_0==REAL||(LA44_0 >= STAR && LA44_0 <= STRING)||(LA44_0 >= 45 && LA44_0 <= 56)||LA44_0==77||LA44_0==80||(LA44_0 >= 88 && LA44_0 <= 89)||(LA44_0 >= 92 && LA44_0 <= 99)||(LA44_0 >= 105 && LA44_0 <= 106)||LA44_0==112) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // TestSuite.g:579:7: e= expression ( COMMA e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_operationExpression2572);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            if ( state.backtracking==0 ) { retval.n.addArg((e!=null?e.n:null)); }

                            // TestSuite.g:580:7: ( COMMA e= expression )*
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==COMMA) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // TestSuite.g:580:9: COMMA e= expression
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_operationExpression2584); if (state.failed) return retval;

                            	    pushFollow(FOLLOW_expression_in_operationExpression2588);
                            	    e=expression();

                            	    state._fsp--;
                            	    if (state.failed) return retval;

                            	    if ( state.backtracking==0 ) { retval.n.addArg((e!=null?e.n:null)); }

                            	    }
                            	    break;

                            	default :
                            	    break loop43;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_operationExpression2608); if (state.failed) return retval;

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
    // TestSuite.g:587:1: inStateExpression[ASTExpression source, boolean followsArrow] returns [ASTInStateExpression n] : opToken= 'oclInState' LPAREN s= IDENT RPAREN ;
    public final ASTInStateExpression inStateExpression(ASTExpression source, boolean followsArrow) throws RecognitionException {
        ASTInStateExpression n = null;


        Token opToken=null;
        Token s=null;

        try {
            // TestSuite.g:588:35: (opToken= 'oclInState' LPAREN s= IDENT RPAREN )
            // TestSuite.g:589:4: opToken= 'oclInState' LPAREN s= IDENT RPAREN
            {
            opToken=(Token)match(input,96,FOLLOW_96_in_inStateExpression2645); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_inStateExpression2650); if (state.failed) return n;

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_inStateExpression2659); if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_inStateExpression2664); if (state.failed) return n;

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
    // TestSuite.g:601:1: typeExpression[ASTExpression source, boolean followsArrow] returns [ASTTypeArgExpression n] : ( 'oclAsType' | 'oclIsKindOf' | 'oclIsTypeOf' | 'selectByType' | 'selectByKind' ) LPAREN t= type RPAREN ;
    public final ASTTypeArgExpression typeExpression(ASTExpression source, boolean followsArrow) throws RecognitionException {
        ASTTypeArgExpression n = null;


        ASTType t =null;


         Token opToken = null; 
        try {
            // TestSuite.g:604:2: ( ( 'oclAsType' | 'oclIsKindOf' | 'oclIsTypeOf' | 'selectByType' | 'selectByKind' ) LPAREN t= type RPAREN )
            // TestSuite.g:605:2: ( 'oclAsType' | 'oclIsKindOf' | 'oclIsTypeOf' | 'selectByType' | 'selectByKind' ) LPAREN t= type RPAREN
            {
            if ( state.backtracking==0 ) { opToken = input.LT(1); }

            if ( input.LA(1)==94||(input.LA(1) >= 97 && input.LA(1) <= 98)||(input.LA(1) >= 105 && input.LA(1) <= 106) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,LPAREN,FOLLOW_LPAREN_in_typeExpression2724); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_typeExpression2728);
            t=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_typeExpression2730); if (state.failed) return n;

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
    // TestSuite.g:616:1: elemVarsDeclaration returns [ASTElemVarsDeclaration n] :var1= IDENT ( COLON t= type )? ( COMMA varN= IDENT ( COLON tN= type )? )* ;
    public final ASTElemVarsDeclaration elemVarsDeclaration() throws RecognitionException {
        ASTElemVarsDeclaration n = null;


        Token var1=null;
        Token varN=null;
        ASTType t =null;

        ASTType tN =null;


        try {
            // TestSuite.g:617:1: (var1= IDENT ( COLON t= type )? ( COMMA varN= IDENT ( COLON tN= type )? )* )
            // TestSuite.g:618:1: var1= IDENT ( COLON t= type )? ( COMMA varN= IDENT ( COLON tN= type )? )*
            {
            if ( state.backtracking==0 ) { n = new ASTElemVarsDeclaration(); }

            var1=(Token)match(input,IDENT,FOLLOW_IDENT_in_elemVarsDeclaration2768); if (state.failed) return n;

            // TestSuite.g:619:17: ( COLON t= type )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==COLON) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // TestSuite.g:619:18: COLON t= type
                    {
                    match(input,COLON,FOLLOW_COLON_in_elemVarsDeclaration2771); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_elemVarsDeclaration2775);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {n.addDeclaration(var1, t);}

            // TestSuite.g:620:4: ( COMMA varN= IDENT ( COLON tN= type )? )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==COMMA) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // TestSuite.g:620:5: COMMA varN= IDENT ( COLON tN= type )?
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_elemVarsDeclaration2785); if (state.failed) return n;

            	    varN=(Token)match(input,IDENT,FOLLOW_IDENT_in_elemVarsDeclaration2791); if (state.failed) return n;

            	    // TestSuite.g:620:24: ( COLON tN= type )?
            	    int alt47=2;
            	    int LA47_0 = input.LA(1);

            	    if ( (LA47_0==COLON) ) {
            	        alt47=1;
            	    }
            	    switch (alt47) {
            	        case 1 :
            	            // TestSuite.g:620:25: COLON tN= type
            	            {
            	            match(input,COLON,FOLLOW_COLON_in_elemVarsDeclaration2794); if (state.failed) return n;

            	            pushFollow(FOLLOW_type_in_elemVarsDeclaration2800);
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
            	    break loop48;
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
    // TestSuite.g:628:1: variableInitialization returns [ASTVariableInitialization n] : name= IDENT COLON t= type EQUAL e= expression ;
    public final ASTVariableInitialization variableInitialization() throws RecognitionException {
        ASTVariableInitialization n = null;


        Token name=null;
        ASTType t =null;

        TestSuiteParser.expression_return e =null;


        try {
            // TestSuite.g:629:5: (name= IDENT COLON t= type EQUAL e= expression )
            // TestSuite.g:630:5: name= IDENT COLON t= type EQUAL e= expression
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_variableInitialization2828); if (state.failed) return n;

            match(input,COLON,FOLLOW_COLON_in_variableInitialization2830); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_variableInitialization2834);
            t=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,EQUAL,FOLLOW_EQUAL_in_variableInitialization2836); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_variableInitialization2840);
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
    // TestSuite.g:639:1: ifExpression returns [ASTExpression n] : i= 'if' cond= expression 'then' t= expression 'else' e= expression 'endif' ;
    public final ASTExpression ifExpression() throws RecognitionException {
        ASTExpression n = null;


        Token i=null;
        TestSuiteParser.expression_return cond =null;

        TestSuiteParser.expression_return t =null;

        TestSuiteParser.expression_return e =null;


        try {
            // TestSuite.g:640:5: (i= 'if' cond= expression 'then' t= expression 'else' e= expression 'endif' )
            // TestSuite.g:641:5: i= 'if' cond= expression 'then' t= expression 'else' e= expression 'endif'
            {
            i=(Token)match(input,80,FOLLOW_80_in_ifExpression2872); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_ifExpression2876);
            cond=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,111,FOLLOW_111_in_ifExpression2878); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_ifExpression2882);
            t=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,71,FOLLOW_71_in_ifExpression2884); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_ifExpression2888);
            e=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,74,FOLLOW_74_in_ifExpression2890); if (state.failed) return n;

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
    // TestSuite.g:660:1: literal returns [ASTExpression n] : (t= 'true' |f= 'false' |i= INT |r= REAL |s= STRING | 'UString' LPAREN usve= additiveExpression COMMA usue= additiveExpression RPAREN | 'UReal' LPAREN urve= additiveExpression COMMA urue= additiveExpression RPAREN | 'UBoolean' LPAREN ubve= conditionalImpliesExpression COMMA ubpe= additiveExpression RPAREN | 'UInteger' LPAREN uive= additiveExpression COMMA uiue= additiveExpression RPAREN | 'SBoolean' LPAREN ubve= additiveExpression COMMA udve= additiveExpression COMMA uuve= additiveExpression COMMA uave= additiveExpression RPAREN | HASH enumLit= IDENT |enumName= IDENT '::' enumLit= IDENT |nColIt= collectionLiteral |nEColIt= emptyCollectionLiteral |nUndLit= undefinedLiteral |nTupleLit= tupleLiteral |un= STAR );
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
            // TestSuite.g:661:7: (t= 'true' |f= 'false' |i= INT |r= REAL |s= STRING | 'UString' LPAREN usve= additiveExpression COMMA usue= additiveExpression RPAREN | 'UReal' LPAREN urve= additiveExpression COMMA urue= additiveExpression RPAREN | 'UBoolean' LPAREN ubve= conditionalImpliesExpression COMMA ubpe= additiveExpression RPAREN | 'UInteger' LPAREN uive= additiveExpression COMMA uiue= additiveExpression RPAREN | 'SBoolean' LPAREN ubve= additiveExpression COMMA udve= additiveExpression COMMA uuve= additiveExpression COMMA uave= additiveExpression RPAREN | HASH enumLit= IDENT |enumName= IDENT '::' enumLit= IDENT |nColIt= collectionLiteral |nEColIt= emptyCollectionLiteral |nUndLit= undefinedLiteral |nTupleLit= tupleLiteral |un= STAR )
            int alt49=17;
            switch ( input.LA(1) ) {
            case 112:
                {
                alt49=1;
                }
                break;
            case 77:
                {
                alt49=2;
                }
                break;
            case INT:
                {
                alt49=3;
                }
                break;
            case REAL:
                {
                alt49=4;
                }
                break;
            case STRING:
                {
                alt49=5;
                }
                break;
            case 55:
                {
                alt49=6;
                }
                break;
            case 54:
                {
                alt49=7;
                }
                break;
            case 52:
                {
                alt49=8;
                }
                break;
            case 53:
                {
                alt49=9;
                }
                break;
            case 48:
                {
                alt49=10;
                }
                break;
            case HASH:
                {
                alt49=11;
                }
                break;
            case IDENT:
                {
                alt49=12;
                }
                break;
            case 45:
            case 47:
            case 49:
            case 50:
                {
                int LA49_13 = input.LA(2);

                if ( (LA49_13==LPAREN) ) {
                    alt49=14;
                }
                else if ( (LA49_13==LBRACE) ) {
                    alt49=13;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 13, input);

                    throw nvae;

                }
                }
                break;
            case 46:
            case 95:
                {
                alt49=14;
                }
                break;
            case 56:
            case 93:
            case 99:
                {
                alt49=15;
                }
                break;
            case 51:
                {
                alt49=16;
                }
                break;
            case STAR:
                {
                alt49=17;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // TestSuite.g:662:7: t= 'true'
                    {
                    t=(Token)match(input,112,FOLLOW_112_in_literal2929); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTBooleanLiteral(true); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:663:7: f= 'false'
                    {
                    f=(Token)match(input,77,FOLLOW_77_in_literal2943); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTBooleanLiteral(false); }

                    }
                    break;
                case 3 :
                    // TestSuite.g:664:7: i= INT
                    {
                    i=(Token)match(input,INT,FOLLOW_INT_in_literal2956); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTIntegerLiteral(i); }

                    }
                    break;
                case 4 :
                    // TestSuite.g:665:7: r= REAL
                    {
                    r=(Token)match(input,REAL,FOLLOW_REAL_in_literal2971); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTRealLiteral(r); }

                    }
                    break;
                case 5 :
                    // TestSuite.g:666:7: s= STRING
                    {
                    s=(Token)match(input,STRING,FOLLOW_STRING_in_literal2985); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTStringLiteral(s); }

                    }
                    break;
                case 6 :
                    // TestSuite.g:667:7: 'UString' LPAREN usve= additiveExpression COMMA usue= additiveExpression RPAREN
                    {
                    match(input,55,FOLLOW_55_in_literal2995); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal2997); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3001);
                    usve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3003); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3007);
                    usue=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal3009); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUStringLiteral(usve,usue); }

                    }
                    break;
                case 7 :
                    // TestSuite.g:668:7: 'UReal' LPAREN urve= additiveExpression COMMA urue= additiveExpression RPAREN
                    {
                    match(input,54,FOLLOW_54_in_literal3019); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal3021); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3025);
                    urve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3027); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3031);
                    urue=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal3033); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTURealLiteral(urve,urue); }

                    }
                    break;
                case 8 :
                    // TestSuite.g:669:7: 'UBoolean' LPAREN ubve= conditionalImpliesExpression COMMA ubpe= additiveExpression RPAREN
                    {
                    match(input,52,FOLLOW_52_in_literal3043); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal3045); if (state.failed) return n;

                    pushFollow(FOLLOW_conditionalImpliesExpression_in_literal3049);
                    ubve=conditionalImpliesExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3051); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3055);
                    ubpe=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal3057); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUBooleanLiteral(ubve, ubpe); }

                    }
                    break;
                case 9 :
                    // TestSuite.g:670:7: 'UInteger' LPAREN uive= additiveExpression COMMA uiue= additiveExpression RPAREN
                    {
                    match(input,53,FOLLOW_53_in_literal3067); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal3069); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3073);
                    uive=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3075); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3079);
                    uiue=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal3081); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUIntegerLiteral(uive, uiue); }

                    }
                    break;
                case 10 :
                    // TestSuite.g:671:7: 'SBoolean' LPAREN ubve= additiveExpression COMMA udve= additiveExpression COMMA uuve= additiveExpression COMMA uave= additiveExpression RPAREN
                    {
                    match(input,48,FOLLOW_48_in_literal3091); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal3093); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3097);
                    ubve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3099); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3103);
                    udve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3105); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3109);
                    uuve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3111); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3115);
                    uave=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal3117); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTSBooleanLiteral(ubve, udve, uuve, uave); }

                    }
                    break;
                case 11 :
                    // TestSuite.g:673:7: HASH enumLit= IDENT
                    {
                    match(input,HASH,FOLLOW_HASH_in_literal3134); if (state.failed) return n;

                    enumLit=(Token)match(input,IDENT,FOLLOW_IDENT_in_literal3138); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTEnumLiteral(enumLit);}

                    }
                    break;
                case 12 :
                    // TestSuite.g:674:7: enumName= IDENT '::' enumLit= IDENT
                    {
                    enumName=(Token)match(input,IDENT,FOLLOW_IDENT_in_literal3150); if (state.failed) return n;

                    match(input,COLON_COLON,FOLLOW_COLON_COLON_in_literal3152); if (state.failed) return n;

                    enumLit=(Token)match(input,IDENT,FOLLOW_IDENT_in_literal3156); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTEnumLiteral(enumName, enumLit); }

                    }
                    break;
                case 13 :
                    // TestSuite.g:675:7: nColIt= collectionLiteral
                    {
                    pushFollow(FOLLOW_collectionLiteral_in_literal3168);
                    nColIt=collectionLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nColIt; }

                    }
                    break;
                case 14 :
                    // TestSuite.g:676:7: nEColIt= emptyCollectionLiteral
                    {
                    pushFollow(FOLLOW_emptyCollectionLiteral_in_literal3180);
                    nEColIt=emptyCollectionLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nEColIt; }

                    }
                    break;
                case 15 :
                    // TestSuite.g:677:7: nUndLit= undefinedLiteral
                    {
                    pushFollow(FOLLOW_undefinedLiteral_in_literal3192);
                    nUndLit=undefinedLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) {n = nUndLit; }

                    }
                    break;
                case 16 :
                    // TestSuite.g:678:7: nTupleLit= tupleLiteral
                    {
                    pushFollow(FOLLOW_tupleLiteral_in_literal3204);
                    nTupleLit=tupleLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) {n = nTupleLit; }

                    }
                    break;
                case 17 :
                    // TestSuite.g:679:7: un= STAR
                    {
                    un=(Token)match(input,STAR,FOLLOW_STAR_in_literal3216); if (state.failed) return n;

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
    // TestSuite.g:687:1: collectionLiteral returns [ASTCollectionLiteral n] : ( 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LBRACE (ci= collectionItem ( COMMA ci= collectionItem )* )? RBRACE ;
    public final ASTCollectionLiteral collectionLiteral() throws RecognitionException {
        ASTCollectionLiteral n = null;


        ASTCollectionItem ci =null;


         Token op = null; 
        try {
            // TestSuite.g:689:5: ( ( 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LBRACE (ci= collectionItem ( COMMA ci= collectionItem )* )? RBRACE )
            // TestSuite.g:690:5: ( 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LBRACE (ci= collectionItem ( COMMA ci= collectionItem )* )? RBRACE
            {
            if ( state.backtracking==0 ) { op = input.LT(1); }

            if ( input.LA(1)==45||input.LA(1)==47||(input.LA(1) >= 49 && input.LA(1) <= 50) ) {
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

            match(input,LBRACE,FOLLOW_LBRACE_in_collectionLiteral3283); if (state.failed) return n;

            // TestSuite.g:694:5: (ci= collectionItem ( COMMA ci= collectionItem )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==AT||LA51_0==HASH||(LA51_0 >= IDENT && LA51_0 <= INT)||(LA51_0 >= LPAREN && LA51_0 <= MINUS)||LA51_0==PLUS||LA51_0==REAL||(LA51_0 >= STAR && LA51_0 <= STRING)||(LA51_0 >= 45 && LA51_0 <= 56)||LA51_0==77||LA51_0==80||(LA51_0 >= 88 && LA51_0 <= 89)||(LA51_0 >= 92 && LA51_0 <= 99)||(LA51_0 >= 105 && LA51_0 <= 106)||LA51_0==112) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // TestSuite.g:695:7: ci= collectionItem ( COMMA ci= collectionItem )*
                    {
                    pushFollow(FOLLOW_collectionItem_in_collectionLiteral3300);
                    ci=collectionItem();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n.addItem(ci); }

                    // TestSuite.g:696:7: ( COMMA ci= collectionItem )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==COMMA) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // TestSuite.g:696:9: COMMA ci= collectionItem
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_collectionLiteral3313); if (state.failed) return n;

                    	    pushFollow(FOLLOW_collectionItem_in_collectionLiteral3317);
                    	    ci=collectionItem();

                    	    state._fsp--;
                    	    if (state.failed) return n;

                    	    if ( state.backtracking==0 ) { n.addItem(ci); }

                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_collectionLiteral3336); if (state.failed) return n;

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
    // TestSuite.g:705:1: collectionItem returns [ASTCollectionItem n] : e= expression ( DOTDOT e= expression )? ;
    public final ASTCollectionItem collectionItem() throws RecognitionException {
        ASTCollectionItem n = null;


        TestSuiteParser.expression_return e =null;


         n = new ASTCollectionItem(); 
        try {
            // TestSuite.g:707:5: (e= expression ( DOTDOT e= expression )? )
            // TestSuite.g:708:5: e= expression ( DOTDOT e= expression )?
            {
            pushFollow(FOLLOW_expression_in_collectionItem3365);
            e=expression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.setFirst((e!=null?e.n:null)); }

            // TestSuite.g:709:5: ( DOTDOT e= expression )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==DOTDOT) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // TestSuite.g:709:7: DOTDOT e= expression
                    {
                    match(input,DOTDOT,FOLLOW_DOTDOT_in_collectionItem3376); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_collectionItem3380);
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
    // TestSuite.g:719:1: emptyCollectionLiteral returns [ASTEmptyCollectionLiteral n] : ( 'oclEmpty' LPAREN t= collectionType RPAREN |t= collectionType LBRACE RBRACE );
    public final ASTEmptyCollectionLiteral emptyCollectionLiteral() throws RecognitionException {
        ASTEmptyCollectionLiteral n = null;


        ASTCollectionType t =null;


        try {
            // TestSuite.g:720:5: ( 'oclEmpty' LPAREN t= collectionType RPAREN |t= collectionType LBRACE RBRACE )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==95) ) {
                alt53=1;
            }
            else if ( ((LA53_0 >= 45 && LA53_0 <= 47)||(LA53_0 >= 49 && LA53_0 <= 50)) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }
            switch (alt53) {
                case 1 :
                    // TestSuite.g:721:5: 'oclEmpty' LPAREN t= collectionType RPAREN
                    {
                    match(input,95,FOLLOW_95_in_emptyCollectionLiteral3409); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_emptyCollectionLiteral3411); if (state.failed) return n;

                    pushFollow(FOLLOW_collectionType_in_emptyCollectionLiteral3415);
                    t=collectionType();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_emptyCollectionLiteral3417); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTEmptyCollectionLiteral(t); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:724:5: t= collectionType LBRACE RBRACE
                    {
                    pushFollow(FOLLOW_collectionType_in_emptyCollectionLiteral3433);
                    t=collectionType();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,LBRACE,FOLLOW_LBRACE_in_emptyCollectionLiteral3435); if (state.failed) return n;

                    match(input,RBRACE,FOLLOW_RBRACE_in_emptyCollectionLiteral3437); if (state.failed) return n;

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
    // TestSuite.g:735:1: undefinedLiteral returns [ASTUndefinedLiteral n] : ( 'oclUndefined' LPAREN t= type RPAREN | 'Undefined' | 'null' LPAREN t= type RPAREN | 'null' );
    public final ASTUndefinedLiteral undefinedLiteral() throws RecognitionException {
        ASTUndefinedLiteral n = null;


        ASTType t =null;


        try {
            // TestSuite.g:736:5: ( 'oclUndefined' LPAREN t= type RPAREN | 'Undefined' | 'null' LPAREN t= type RPAREN | 'null' )
            int alt54=4;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt54=1;
                }
                break;
            case 56:
                {
                alt54=2;
                }
                break;
            case 93:
                {
                int LA54_3 = input.LA(2);

                if ( (LA54_3==LPAREN) ) {
                    alt54=3;
                }
                else if ( (LA54_3==EOF||LA54_3==ARROW||LA54_3==BAR||(LA54_3 >= COMMA && LA54_3 <= EQUAL)||(LA54_3 >= GREATER && LA54_3 <= GREATER_EQUAL)||LA54_3==IDENT||LA54_3==LBRACE||(LA54_3 >= LESS && LA54_3 <= LESS_EQUAL)||LA54_3==MINUS||(LA54_3 >= NOT_EQUAL && LA54_3 <= PLUS)||(LA54_3 >= RBRACE && LA54_3 <= RBRACK)||(LA54_3 >= RPAREN && LA54_3 <= SLASH)||LA54_3==STAR||LA54_3==44||(LA54_3 >= 58 && LA54_3 <= 60)||LA54_3==62||LA54_3==65||(LA54_3 >= 67 && LA54_3 <= 74)||LA54_3==76||(LA54_3 >= 81 && LA54_3 <= 83)||LA54_3==89||LA54_3==102||LA54_3==107||LA54_3==111||LA54_3==115) ) {
                    alt54=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }

            switch (alt54) {
                case 1 :
                    // TestSuite.g:737:5: 'oclUndefined' LPAREN t= type RPAREN
                    {
                    match(input,99,FOLLOW_99_in_undefinedLiteral3467); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_undefinedLiteral3469); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_undefinedLiteral3473);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_undefinedLiteral3475); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUndefinedLiteral(t); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:740:5: 'Undefined'
                    {
                    match(input,56,FOLLOW_56_in_undefinedLiteral3489); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUndefinedLiteral(); }

                    }
                    break;
                case 3 :
                    // TestSuite.g:743:5: 'null' LPAREN t= type RPAREN
                    {
                    match(input,93,FOLLOW_93_in_undefinedLiteral3503); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_undefinedLiteral3505); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_undefinedLiteral3509);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_undefinedLiteral3511); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUndefinedLiteral(t); }

                    }
                    break;
                case 4 :
                    // TestSuite.g:746:5: 'null'
                    {
                    match(input,93,FOLLOW_93_in_undefinedLiteral3525); if (state.failed) return n;

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
    // TestSuite.g:756:1: tupleLiteral returns [ASTTupleLiteral n] : 'Tuple' LBRACE ti= tupleItem ( COMMA ti= tupleItem )* RBRACE ;
    public final ASTTupleLiteral tupleLiteral() throws RecognitionException {
        ASTTupleLiteral n = null;


        ASTTupleItem ti =null;


         List tiList = new ArrayList(); 
        try {
            // TestSuite.g:758:5: ( 'Tuple' LBRACE ti= tupleItem ( COMMA ti= tupleItem )* RBRACE )
            // TestSuite.g:759:5: 'Tuple' LBRACE ti= tupleItem ( COMMA ti= tupleItem )* RBRACE
            {
            match(input,51,FOLLOW_51_in_tupleLiteral3564); if (state.failed) return n;

            match(input,LBRACE,FOLLOW_LBRACE_in_tupleLiteral3570); if (state.failed) return n;

            pushFollow(FOLLOW_tupleItem_in_tupleLiteral3578);
            ti=tupleItem();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { tiList.add(ti); }

            // TestSuite.g:762:5: ( COMMA ti= tupleItem )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==COMMA) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // TestSuite.g:762:7: COMMA ti= tupleItem
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_tupleLiteral3589); if (state.failed) return n;

            	    pushFollow(FOLLOW_tupleItem_in_tupleLiteral3593);
            	    ti=tupleItem();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { tiList.add(ti); }

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_tupleLiteral3604); if (state.failed) return n;

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
    // TestSuite.g:770:1: tupleItem returns [ASTTupleItem n] : name= IDENT ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression ) ;
    public final ASTTupleItem tupleItem() throws RecognitionException {
        ASTTupleItem n = null;


        Token name=null;
        ASTType t =null;

        TestSuiteParser.expression_return e =null;


        try {
            // TestSuite.g:771:5: (name= IDENT ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression ) )
            // TestSuite.g:772:5: name= IDENT ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression )
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_tupleItem3635); if (state.failed) return n;

            // TestSuite.g:773:5: ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==COLON) ) {
                int LA56_1 = input.LA(2);

                if ( (synpred1_TestSuite()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA56_0==EQUAL) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }
            switch (alt56) {
                case 1 :
                    // TestSuite.g:776:7: ( COLON type EQUAL )=> COLON t= type EQUAL e= expression
                    {
                    match(input,COLON,FOLLOW_COLON_in_tupleItem3674); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_tupleItem3678);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,EQUAL,FOLLOW_EQUAL_in_tupleItem3680); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_tupleItem3684);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTTupleItem(name, t, (e!=null?e.n:null)); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:779:7: ( COLON | EQUAL ) e= expression
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


                    pushFollow(FOLLOW_expression_in_tupleItem3716);
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
    // TestSuite.g:791:1: type returns [ASTType n] : (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType ) ;
    public final ASTType type() throws RecognitionException {
        ASTType n = null;


        ASTSimpleType nTSimple =null;

        ASTCollectionType nTCollection =null;

        ASTTupleType nTTuple =null;

        ASTType nTUncertainty =null;


         Token tok = null; 
        try {
            // TestSuite.g:793:5: ( (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType ) )
            // TestSuite.g:794:5: (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType )
            {
            if ( state.backtracking==0 ) { tok = input.LT(1); /* remember start of type */ }

            // TestSuite.g:795:5: (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType )
            int alt57=4;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt57=1;
                }
                break;
            case 45:
            case 46:
            case 47:
            case 49:
            case 50:
                {
                alt57=2;
                }
                break;
            case 51:
                {
                alt57=3;
                }
                break;
            case 48:
            case 52:
            case 53:
            case 54:
            case 55:
                {
                alt57=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }

            switch (alt57) {
                case 1 :
                    // TestSuite.g:796:7: nTSimple= simpleType
                    {
                    pushFollow(FOLLOW_simpleType_in_type3782);
                    nTSimple=simpleType();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nTSimple; if (n != null) n.setStartToken(tok); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:797:7: nTCollection= collectionType
                    {
                    pushFollow(FOLLOW_collectionType_in_type3794);
                    nTCollection=collectionType();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nTCollection; if (n != null) n.setStartToken(tok); }

                    }
                    break;
                case 3 :
                    // TestSuite.g:798:7: nTTuple= tupleType
                    {
                    pushFollow(FOLLOW_tupleType_in_type3806);
                    nTTuple=tupleType();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nTTuple; if (n != null) n.setStartToken(tok); }

                    }
                    break;
                case 4 :
                    // TestSuite.g:799:7: nTUncertainty= uncertaintyType
                    {
                    pushFollow(FOLLOW_uncertaintyType_in_type3818);
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
    // TestSuite.g:803:1: uncertaintyType returns [ASTType n] : name= ( 'UReal' | 'UInteger' | 'UBoolean' | 'UString' | 'SBoolean' ) ;
    public final ASTType uncertaintyType() throws RecognitionException {
        ASTType n = null;


        Token name=null;

        try {
            // TestSuite.g:804:5: (name= ( 'UReal' | 'UInteger' | 'UBoolean' | 'UString' | 'SBoolean' ) )
            // TestSuite.g:805:5: name= ( 'UReal' | 'UInteger' | 'UBoolean' | 'UString' | 'SBoolean' )
            {
            name=(Token)input.LT(1);

            if ( input.LA(1)==48||(input.LA(1) >= 52 && input.LA(1) <= 55) ) {
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
    // TestSuite.g:809:1: typeOnly returns [ASTType n] : nT= type EOF ;
    public final ASTType typeOnly() throws RecognitionException {
        ASTType n = null;


        ASTType nT =null;


        try {
            // TestSuite.g:810:5: (nT= type EOF )
            // TestSuite.g:811:5: nT= type EOF
            {
            pushFollow(FOLLOW_type_in_typeOnly3887);
            nT=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,EOF,FOLLOW_EOF_in_typeOnly3889); if (state.failed) return n;

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
    // TestSuite.g:821:1: simpleType returns [ASTSimpleType n] : name= IDENT ;
    public final ASTSimpleType simpleType() throws RecognitionException {
        ASTSimpleType n = null;


        Token name=null;

        try {
            // TestSuite.g:822:5: (name= IDENT )
            // TestSuite.g:823:5: name= IDENT
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_simpleType3917); if (state.failed) return n;

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
    // TestSuite.g:831:1: collectionType returns [ASTCollectionType n] : ( 'Collection' | 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LPAREN elemType= type RPAREN ;
    public final ASTCollectionType collectionType() throws RecognitionException {
        ASTCollectionType n = null;


        ASTType elemType =null;


         Token op = null; 
        try {
            // TestSuite.g:833:5: ( ( 'Collection' | 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LPAREN elemType= type RPAREN )
            // TestSuite.g:834:5: ( 'Collection' | 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LPAREN elemType= type RPAREN
            {
            if ( state.backtracking==0 ) { op = input.LT(1); }

            if ( (input.LA(1) >= 45 && input.LA(1) <= 47)||(input.LA(1) >= 49 && input.LA(1) <= 50) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,LPAREN,FOLLOW_LPAREN_in_collectionType3982); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_collectionType3986);
            elemType=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_collectionType3988); if (state.failed) return n;

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
    // TestSuite.g:844:1: tupleType returns [ASTTupleType n] : 'Tuple' LPAREN tp= tuplePart ( COMMA tp= tuplePart )* RPAREN ;
    public final ASTTupleType tupleType() throws RecognitionException {
        ASTTupleType n = null;


        ASTTuplePart tp =null;


         List tpList = new ArrayList(); 
        try {
            // TestSuite.g:846:5: ( 'Tuple' LPAREN tp= tuplePart ( COMMA tp= tuplePart )* RPAREN )
            // TestSuite.g:847:5: 'Tuple' LPAREN tp= tuplePart ( COMMA tp= tuplePart )* RPAREN
            {
            match(input,51,FOLLOW_51_in_tupleType4022); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_tupleType4024); if (state.failed) return n;

            pushFollow(FOLLOW_tuplePart_in_tupleType4033);
            tp=tuplePart();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { tpList.add(tp); }

            // TestSuite.g:849:5: ( COMMA tp= tuplePart )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==COMMA) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // TestSuite.g:849:7: COMMA tp= tuplePart
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_tupleType4044); if (state.failed) return n;

            	    pushFollow(FOLLOW_tuplePart_in_tupleType4048);
            	    tp=tuplePart();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { tpList.add(tp); }

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            match(input,RPAREN,FOLLOW_RPAREN_in_tupleType4060); if (state.failed) return n;

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
    // TestSuite.g:858:1: tuplePart returns [ASTTuplePart n] : name= IDENT COLON t= type ;
    public final ASTTuplePart tuplePart() throws RecognitionException {
        ASTTuplePart n = null;


        Token name=null;
        ASTType t =null;


        try {
            // TestSuite.g:859:5: (name= IDENT COLON t= type )
            // TestSuite.g:860:5: name= IDENT COLON t= type
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_tuplePart4092); if (state.failed) return n;

            match(input,COLON,FOLLOW_COLON_in_tuplePart4094); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_tuplePart4098);
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



    // $ANTLR start "shellCommandOnly"
    // TestSuite.g:867:1: shellCommandOnly returns [ASTStatement n] : ( ( stat )=>s= stat | ( legacyStat )=>l= legacyStat );
    public final ASTStatement shellCommandOnly() throws RecognitionException {
        ASTStatement n = null;


        TestSuiteParser.stat_return s =null;

        TestSuiteParser.legacyStat_return l =null;


        try {
            // TestSuite.g:868:3: ( ( stat )=>s= stat | ( legacyStat )=>l= legacyStat )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==SEMI) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==72) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==44) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==59) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==62) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==73) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==89) ) {
                int LA59_7 = input.LA(2);

                if ( (synpred2_TestSuite()) ) {
                    alt59=1;
                }
                else if ( (synpred3_TestSuite()) ) {
                    alt59=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 7, input);

                    throw nvae;

                }
            }
            else if ( (LA59_0==MINUS||LA59_0==PLUS||LA59_0==92) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==112) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==77) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==INT) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==REAL) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==STRING) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==55) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==54) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==52) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==53) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==48) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==HASH) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==IDENT) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==45||LA59_0==47||(LA59_0 >= 49 && LA59_0 <= 50)) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==95) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==46) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==99) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==56) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==93) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==51) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==STAR) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==AT) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==88) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==94||(LA59_0 >= 97 && LA59_0 <= 98)||(LA59_0 >= 105 && LA59_0 <= 106)) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==96) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==LPAREN) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==80) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==91) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==68) ) {
                int LA59_36 = input.LA(2);

                if ( (synpred2_TestSuite()) ) {
                    alt59=1;
                }
                else if ( (synpred3_TestSuite()) ) {
                    alt59=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 36, input);

                    throw nvae;

                }
            }
            else if ( (LA59_0==83) ) {
                int LA59_37 = input.LA(2);

                if ( (synpred2_TestSuite()) ) {
                    alt59=1;
                }
                else if ( (synpred3_TestSuite()) ) {
                    alt59=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 37, input);

                    throw nvae;

                }
            }
            else if ( (LA59_0==67) ) {
                int LA59_38 = input.LA(2);

                if ( (synpred2_TestSuite()) ) {
                    alt59=1;
                }
                else if ( (synpred3_TestSuite()) ) {
                    alt59=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 38, input);

                    throw nvae;

                }
            }
            else if ( (LA59_0==78) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==114) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==61) && (synpred2_TestSuite())) {
                alt59=1;
            }
            else if ( (LA59_0==100) && (synpred3_TestSuite())) {
                alt59=2;
            }
            else if ( (LA59_0==101) && (synpred3_TestSuite())) {
                alt59=2;
            }
            else if ( (LA59_0==65) && (synpred3_TestSuite())) {
                alt59=2;
            }
            else if ( (LA59_0==60) && (synpred3_TestSuite())) {
                alt59=2;
            }
            else if ( (LA59_0==76) && (synpred3_TestSuite())) {
                alt59=2;
            }
            else if ( (LA59_0==107) && (synpred3_TestSuite())) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }
            switch (alt59) {
                case 1 :
                    // TestSuite.g:869:3: ( stat )=>s= stat
                    {
                    pushFollow(FOLLOW_stat_in_shellCommandOnly4135);
                    s=stat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (s!=null?s.n:null); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:872:3: ( legacyStat )=>l= legacyStat
                    {
                    pushFollow(FOLLOW_legacyStat_in_shellCommandOnly4156);
                    l=legacyStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (l!=null?l.n:null); }

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
    // $ANTLR end "shellCommandOnly"



    // $ANTLR start "shellCommand"
    // TestSuite.g:880:1: shellCommand returns [ASTStatement n] : ( ( legacyStat )=>l= legacyStat EOF | ( stat )=>s= stat EOF );
    public final ASTStatement shellCommand() throws RecognitionException {
        ASTStatement n = null;


        TestSuiteParser.legacyStat_return l =null;

        TestSuiteParser.stat_return s =null;


        try {
            // TestSuite.g:881:3: ( ( legacyStat )=>l= legacyStat EOF | ( stat )=>s= stat EOF )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==100) && (synpred4_TestSuite())) {
                alt60=1;
            }
            else if ( (LA60_0==101) && (synpred4_TestSuite())) {
                alt60=1;
            }
            else if ( (LA60_0==65) && (synpred4_TestSuite())) {
                alt60=1;
            }
            else if ( (LA60_0==60) && (synpred4_TestSuite())) {
                alt60=1;
            }
            else if ( (LA60_0==89) ) {
                int LA60_5 = input.LA(2);

                if ( (synpred4_TestSuite()) ) {
                    alt60=1;
                }
                else if ( (synpred5_TestSuite()) ) {
                    alt60=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 5, input);

                    throw nvae;

                }
            }
            else if ( (LA60_0==76) && (synpred4_TestSuite())) {
                alt60=1;
            }
            else if ( (LA60_0==68) ) {
                int LA60_7 = input.LA(2);

                if ( (synpred4_TestSuite()) ) {
                    alt60=1;
                }
                else if ( (synpred5_TestSuite()) ) {
                    alt60=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 7, input);

                    throw nvae;

                }
            }
            else if ( (LA60_0==107) && (synpred4_TestSuite())) {
                alt60=1;
            }
            else if ( (LA60_0==83) ) {
                int LA60_9 = input.LA(2);

                if ( (synpred4_TestSuite()) ) {
                    alt60=1;
                }
                else if ( (synpred5_TestSuite()) ) {
                    alt60=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 9, input);

                    throw nvae;

                }
            }
            else if ( (LA60_0==67) ) {
                int LA60_10 = input.LA(2);

                if ( (synpred4_TestSuite()) ) {
                    alt60=1;
                }
                else if ( (synpred5_TestSuite()) ) {
                    alt60=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 10, input);

                    throw nvae;

                }
            }
            else if ( (LA60_0==SEMI) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==EOF) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==MINUS||LA60_0==PLUS||LA60_0==92) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==112) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==77) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==INT) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==REAL) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==STRING) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==55) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==54) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==52) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==53) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==48) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==HASH) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==IDENT) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==45||LA60_0==47||(LA60_0 >= 49 && LA60_0 <= 50)) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==95) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==46) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==99) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==56) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==93) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==51) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==STAR) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==AT) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==88) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==94||(LA60_0 >= 97 && LA60_0 <= 98)||(LA60_0 >= 105 && LA60_0 <= 106)) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==96) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==LPAREN) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==80) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==91) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==78) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==114) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else if ( (LA60_0==61) && (synpred5_TestSuite())) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // TestSuite.g:882:3: ( legacyStat )=>l= legacyStat EOF
                    {
                    pushFollow(FOLLOW_legacyStat_in_shellCommand4188);
                    l=legacyStat();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,EOF,FOLLOW_EOF_in_shellCommand4190); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (l!=null?l.n:null); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:885:3: ( stat )=>s= stat EOF
                    {
                    pushFollow(FOLLOW_stat_in_shellCommand4211);
                    s=stat();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,EOF,FOLLOW_EOF_in_shellCommand4213); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (s!=null?s.n:null); }

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
    // $ANTLR end "shellCommand"


    public static class legacyStat_return extends ParserRuleReturnScope {
        public ASTStatement n;
    };


    // $ANTLR start "legacyStat"
    // TestSuite.g:895:1: legacyStat returns [ASTStatement n] : (loe= legacyOpEnter |lox= legacyOpExit | nextLegacyStat[seq] ( nextLegacyStat[seq] )* );
    public final TestSuiteParser.legacyStat_return legacyStat() throws RecognitionException {
        TestSuiteParser.legacyStat_return retval = new TestSuiteParser.legacyStat_return();
        retval.start = input.LT(1);


        TestSuiteParser.legacyOpEnter_return loe =null;

        TestSuiteParser.legacyOpExit_return lox =null;



          ASTSequenceStatement seq = new ASTSequenceStatement(((Token)retval.start));

        try {
            // TestSuite.g:899:3: (loe= legacyOpEnter |lox= legacyOpExit | nextLegacyStat[seq] ( nextLegacyStat[seq] )* )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 100:
                {
                alt62=1;
                }
                break;
            case 101:
                {
                alt62=2;
                }
                break;
            case 60:
            case 65:
            case 67:
            case 68:
            case 76:
            case 83:
            case 89:
            case 107:
                {
                alt62=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }

            switch (alt62) {
                case 1 :
                    // TestSuite.g:900:3: loe= legacyOpEnter
                    {
                    pushFollow(FOLLOW_legacyOpEnter_in_legacyStat4247);
                    loe=legacyOpEnter();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { 
                        retval.n = (loe!=null?loe.n:null);
                      }

                    }
                    break;
                case 2 :
                    // TestSuite.g:905:3: lox= legacyOpExit
                    {
                    pushFollow(FOLLOW_legacyOpExit_in_legacyStat4263);
                    lox=legacyOpExit();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { 
                        retval.n = (lox!=null?lox.n:null); 
                      }

                    }
                    break;
                case 3 :
                    // TestSuite.g:910:3: nextLegacyStat[seq] ( nextLegacyStat[seq] )*
                    {
                    pushFollow(FOLLOW_nextLegacyStat_in_legacyStat4276);
                    nextLegacyStat(seq);

                    state._fsp--;
                    if (state.failed) return retval;

                    // TestSuite.g:911:3: ( nextLegacyStat[seq] )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==60||LA61_0==65||(LA61_0 >= 67 && LA61_0 <= 68)||LA61_0==76||LA61_0==83||LA61_0==89||LA61_0==107) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // TestSuite.g:912:5: nextLegacyStat[seq]
                    	    {
                    	    pushFollow(FOLLOW_nextLegacyStat_in_legacyStat4287);
                    	    nextLegacyStat(seq);

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { 
                        retval.n = seq.simplify();
                      }

                    }
                    break;

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
    // $ANTLR end "legacyStat"



    // $ANTLR start "nextLegacyStat"
    // TestSuite.g:924:1: nextLegacyStat[ASTSequenceStatement seq] : s= singleLegacyStat ( SEMI )? ;
    public final void nextLegacyStat(ASTSequenceStatement seq) throws RecognitionException {
        ASTStatement s =null;


        try {
            // TestSuite.g:925:3: (s= singleLegacyStat ( SEMI )? )
            // TestSuite.g:926:3: s= singleLegacyStat ( SEMI )?
            {
            pushFollow(FOLLOW_singleLegacyStat_in_nextLegacyStat4321);
            s=singleLegacyStat();

            state._fsp--;
            if (state.failed) return ;

            // TestSuite.g:927:3: ( SEMI )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==SEMI) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // TestSuite.g:927:3: SEMI
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_nextLegacyStat4325); if (state.failed) return ;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                 seq.addStatement(s);
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
        return ;
    }
    // $ANTLR end "nextLegacyStat"



    // $ANTLR start "singleLegacyStat"
    // TestSuite.g:938:1: singleLegacyStat returns [ASTStatement n] : (lcr= legacyCreate |lca= legacyCreateAssign |lci= legacyCreateInsert |llt= legacyLet |lex= legacyExecute |ods= objDestroyStat | 'set' e= expression aas= attAssignStat[$e.n] |lis= lnkInsStat |lds= lnkDelStat );
    public final ASTStatement singleLegacyStat() throws RecognitionException {
        ASTStatement n = null;


        TestSuiteParser.legacyCreate_return lcr =null;

        TestSuiteParser.legacyCreateAssign_return lca =null;

        TestSuiteParser.legacyCreateInsert_return lci =null;

        TestSuiteParser.legacyLet_return llt =null;

        ASTStatement lex =null;

        TestSuiteParser.objDestroyStat_return ods =null;

        TestSuiteParser.expression_return e =null;

        ASTAttributeAssignmentStatement aas =null;

        TestSuiteParser.lnkInsStat_return lis =null;

        TestSuiteParser.lnkDelStat_return lds =null;


        try {
            // TestSuite.g:939:5: (lcr= legacyCreate |lca= legacyCreateAssign |lci= legacyCreateInsert |llt= legacyLet |lex= legacyExecute |ods= objDestroyStat | 'set' e= expression aas= attAssignStat[$e.n] |lis= lnkInsStat |lds= lnkDelStat )
            int alt64=9;
            switch ( input.LA(1) ) {
            case 65:
                {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==IDENT) ) {
                    int LA64_9 = input.LA(3);

                    if ( (LA64_9==COLON) ) {
                        int LA64_10 = input.LA(4);

                        if ( (LA64_10==IDENT) ) {
                            int LA64_12 = input.LA(5);

                            if ( (LA64_12==63) ) {
                                alt64=3;
                            }
                            else if ( (LA64_12==EOF||LA64_12==SEMI||LA64_12==44||(LA64_12 >= 59 && LA64_12 <= 60)||LA64_12==62||LA64_12==65||(LA64_12 >= 67 && LA64_12 <= 68)||(LA64_12 >= 72 && LA64_12 <= 73)||LA64_12==76||LA64_12==83||LA64_12==89||LA64_12==107) ) {
                                alt64=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return n;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 64, 12, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return n;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 64, 10, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA64_9==COMMA) ) {
                        alt64=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 9, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;

                }
                }
                break;
            case 60:
                {
                alt64=2;
                }
                break;
            case 89:
                {
                alt64=4;
                }
                break;
            case 76:
                {
                alt64=5;
                }
                break;
            case 68:
                {
                alt64=6;
                }
                break;
            case 107:
                {
                alt64=7;
                }
                break;
            case 83:
                {
                alt64=8;
                }
                break;
            case 67:
                {
                alt64=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }

            switch (alt64) {
                case 1 :
                    // TestSuite.g:940:5: lcr= legacyCreate
                    {
                    pushFollow(FOLLOW_legacyCreate_in_singleLegacyStat4358);
                    lcr=legacyCreate();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lcr!=null?lcr.n:null); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:941:5: lca= legacyCreateAssign
                    {
                    pushFollow(FOLLOW_legacyCreateAssign_in_singleLegacyStat4377);
                    lca=legacyCreateAssign();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lca!=null?lca.n:null); }

                    }
                    break;
                case 3 :
                    // TestSuite.g:942:5: lci= legacyCreateInsert
                    {
                    pushFollow(FOLLOW_legacyCreateInsert_in_singleLegacyStat4390);
                    lci=legacyCreateInsert();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lci!=null?lci.n:null); }

                    }
                    break;
                case 4 :
                    // TestSuite.g:943:5: llt= legacyLet
                    {
                    pushFollow(FOLLOW_legacyLet_in_singleLegacyStat4403);
                    llt=legacyLet();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (llt!=null?llt.n:null); }

                    }
                    break;
                case 5 :
                    // TestSuite.g:946:5: lex= legacyExecute
                    {
                    pushFollow(FOLLOW_legacyExecute_in_singleLegacyStat4431);
                    lex=legacyExecute();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = lex; }

                    }
                    break;
                case 6 :
                    // TestSuite.g:947:5: ods= objDestroyStat
                    {
                    pushFollow(FOLLOW_objDestroyStat_in_singleLegacyStat4449);
                    ods=objDestroyStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (ods!=null?ods.n:null); }

                    }
                    break;
                case 7 :
                    // TestSuite.g:948:5: 'set' e= expression aas= attAssignStat[$e.n]
                    {
                    match(input,107,FOLLOW_107_in_singleLegacyStat4462); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_singleLegacyStat4466);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    pushFollow(FOLLOW_attAssignStat_in_singleLegacyStat4472);
                    aas=attAssignStat((e!=null?e.n:null));

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = aas; }

                    }
                    break;
                case 8 :
                    // TestSuite.g:949:5: lis= lnkInsStat
                    {
                    pushFollow(FOLLOW_lnkInsStat_in_singleLegacyStat4485);
                    lis=lnkInsStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lis!=null?lis.n:null); }

                    }
                    break;
                case 9 :
                    // TestSuite.g:950:5: lds= lnkDelStat
                    {
                    pushFollow(FOLLOW_lnkDelStat_in_singleLegacyStat4506);
                    lds=lnkDelStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lds!=null?lds.n:null); }

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
    // $ANTLR end "singleLegacyStat"


    public static class legacyCreate_return extends ParserRuleReturnScope {
        public ASTStatement n;
    };


    // $ANTLR start "legacyCreate"
    // TestSuite.g:963:1: legacyCreate returns [ASTStatement n] : 'create' objNames= identListMin1 COLON objType= simpleType ;
    public final TestSuiteParser.legacyCreate_return legacyCreate() throws RecognitionException {
        TestSuiteParser.legacyCreate_return retval = new TestSuiteParser.legacyCreate_return();
        retval.start = input.LT(1);


        List<String> objNames =null;

        ASTSimpleType objType =null;


        try {
            // TestSuite.g:964:3: ( 'create' objNames= identListMin1 COLON objType= simpleType )
            // TestSuite.g:965:3: 'create' objNames= identListMin1 COLON objType= simpleType
            {
            match(input,65,FOLLOW_65_in_legacyCreate4542); if (state.failed) return retval;

            pushFollow(FOLLOW_identListMin1_in_legacyCreate4550);
            objNames=identListMin1();

            state._fsp--;
            if (state.failed) return retval;

            match(input,COLON,FOLLOW_COLON_in_legacyCreate4554); if (state.failed) return retval;

            pushFollow(FOLLOW_simpleType_in_legacyCreate4562);
            objType=simpleType();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { 
                ASTSequenceStatement seq = new ASTSequenceStatement(((Token)retval.start));
                
                for (String objName : objNames) {
                  seq.addStatement(
                    new ASTNewObjectStatement(
                      ((Token)retval.start),
                      objType, 
                      new ASTStringLiteral(objName)));
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
    // $ANTLR end "legacyCreate"


    public static class legacyCreateAssign_return extends ParserRuleReturnScope {
        public ASTStatement n;
    };


    // $ANTLR start "legacyCreateAssign"
    // TestSuite.g:996:1: legacyCreateAssign returns [ASTStatement n] : 'assign' varNames= identListMin1 COLON_EQUAL 'create' objType= simpleType ;
    public final TestSuiteParser.legacyCreateAssign_return legacyCreateAssign() throws RecognitionException {
        TestSuiteParser.legacyCreateAssign_return retval = new TestSuiteParser.legacyCreateAssign_return();
        retval.start = input.LT(1);


        List<String> varNames =null;

        ASTSimpleType objType =null;


        try {
            // TestSuite.g:997:3: ( 'assign' varNames= identListMin1 COLON_EQUAL 'create' objType= simpleType )
            // TestSuite.g:998:3: 'assign' varNames= identListMin1 COLON_EQUAL 'create' objType= simpleType
            {
            match(input,60,FOLLOW_60_in_legacyCreateAssign4599); if (state.failed) return retval;

            pushFollow(FOLLOW_identListMin1_in_legacyCreateAssign4607);
            varNames=identListMin1();

            state._fsp--;
            if (state.failed) return retval;

            match(input,COLON_EQUAL,FOLLOW_COLON_EQUAL_in_legacyCreateAssign4611); if (state.failed) return retval;

            match(input,65,FOLLOW_65_in_legacyCreateAssign4615); if (state.failed) return retval;

            pushFollow(FOLLOW_simpleType_in_legacyCreateAssign4623);
            objType=simpleType();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {
                ASTSequenceStatement seq = new ASTSequenceStatement(((Token)retval.start));
                
                for (String varName : varNames) {
                  seq.addStatement(
                    new ASTVariableAssignmentStatement(
                      ((Token)retval.start),
                      varName, 
                      new ASTRValueNewObject(((Token)retval.start), objType)));
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
    // $ANTLR end "legacyCreateAssign"


    public static class legacyCreateInsert_return extends ParserRuleReturnScope {
        public ASTVariableAssignmentStatement n;
    };


    // $ANTLR start "legacyCreateInsert"
    // TestSuite.g:1031:1: legacyCreateInsert returns [ASTVariableAssignmentStatement n] : 'create' name= IDENT COLON asClassName= simpleType 'between' LPAREN participants= rValListMin2WithOptionalQualifiers RPAREN ;
    public final TestSuiteParser.legacyCreateInsert_return legacyCreateInsert() throws RecognitionException {
        TestSuiteParser.legacyCreateInsert_return retval = new TestSuiteParser.legacyCreateInsert_return();
        retval.start = input.LT(1);


        Token name=null;
        ASTSimpleType asClassName =null;

        TestSuiteParser.rValListMin2WithOptionalQualifiers_return participants =null;


        try {
            // TestSuite.g:1032:3: ( 'create' name= IDENT COLON asClassName= simpleType 'between' LPAREN participants= rValListMin2WithOptionalQualifiers RPAREN )
            // TestSuite.g:1033:3: 'create' name= IDENT COLON asClassName= simpleType 'between' LPAREN participants= rValListMin2WithOptionalQualifiers RPAREN
            {
            match(input,65,FOLLOW_65_in_legacyCreateInsert4657); if (state.failed) return retval;

            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_legacyCreateInsert4665); if (state.failed) return retval;

            match(input,COLON,FOLLOW_COLON_in_legacyCreateInsert4669); if (state.failed) return retval;

            pushFollow(FOLLOW_simpleType_in_legacyCreateInsert4677);
            asClassName=simpleType();

            state._fsp--;
            if (state.failed) return retval;

            match(input,63,FOLLOW_63_in_legacyCreateInsert4681); if (state.failed) return retval;

            match(input,LPAREN,FOLLOW_LPAREN_in_legacyCreateInsert4685); if (state.failed) return retval;

            pushFollow(FOLLOW_rValListMin2WithOptionalQualifiers_in_legacyCreateInsert4695);
            participants=rValListMin2WithOptionalQualifiers();

            state._fsp--;
            if (state.failed) return retval;

            match(input,RPAREN,FOLLOW_RPAREN_in_legacyCreateInsert4699); if (state.failed) return retval;

            if ( state.backtracking==0 ) {
                ASTNewLinkObjectStatement nlo = 
                  new ASTNewLinkObjectStatement(
                    ((Token)retval.start),
                    asClassName, 
                    (participants!=null?participants.participans:null),
                    (participants!=null?participants.qualifiers:null),
                    new ASTStringLiteral(name));
              
                retval.n = new ASTVariableAssignmentStatement(((Token)retval.start),
                  (name!=null?name.getText():null),
                  new ASTRValueNewLinkObject(nlo));
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
    // $ANTLR end "legacyCreateInsert"


    public static class legacyLet_return extends ParserRuleReturnScope {
        public ASTVariableAssignmentStatement n;
    };


    // $ANTLR start "legacyLet"
    // TestSuite.g:1068:1: legacyLet returns [ASTVariableAssignmentStatement n] : 'let' varName= IDENT ( COLON varType= type )? EQUAL e= inSoilExpression ;
    public final TestSuiteParser.legacyLet_return legacyLet() throws RecognitionException {
        TestSuiteParser.legacyLet_return retval = new TestSuiteParser.legacyLet_return();
        retval.start = input.LT(1);


        Token varName=null;
        ASTType varType =null;

        ASTExpression e =null;


        try {
            // TestSuite.g:1069:3: ( 'let' varName= IDENT ( COLON varType= type )? EQUAL e= inSoilExpression )
            // TestSuite.g:1070:3: 'let' varName= IDENT ( COLON varType= type )? EQUAL e= inSoilExpression
            {
            match(input,89,FOLLOW_89_in_legacyLet4732); if (state.failed) return retval;

            varName=(Token)match(input,IDENT,FOLLOW_IDENT_in_legacyLet4740); if (state.failed) return retval;

            // TestSuite.g:1072:3: ( COLON varType= type )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==COLON) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // TestSuite.g:1073:5: COLON varType= type
                    {
                    match(input,COLON,FOLLOW_COLON_in_legacyLet4750); if (state.failed) return retval;

                    pushFollow(FOLLOW_type_in_legacyLet4760);
                    varType=type();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }


            match(input,EQUAL,FOLLOW_EQUAL_in_legacyLet4769); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_legacyLet4777);
            e=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n = new ASTVariableAssignmentStatement(((Token)retval.start), (varName!=null?varName.getText():null), e, varType); }

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
    // $ANTLR end "legacyLet"


    public static class legacyOpEnter_return extends ParserRuleReturnScope {
        public ASTEnterOperationStatement n;
    };


    // $ANTLR start "legacyOpEnter"
    // TestSuite.g:1094:1: legacyOpEnter returns [ASTEnterOperationStatement n] : 'openter' obj= inSoilExpression op= IDENT LPAREN args= exprList RPAREN ;
    public final TestSuiteParser.legacyOpEnter_return legacyOpEnter() throws RecognitionException {
        TestSuiteParser.legacyOpEnter_return retval = new TestSuiteParser.legacyOpEnter_return();
        retval.start = input.LT(1);


        Token op=null;
        ASTExpression obj =null;

        List<ASTExpression> args =null;


        try {
            // TestSuite.g:1095:3: ( 'openter' obj= inSoilExpression op= IDENT LPAREN args= exprList RPAREN )
            // TestSuite.g:1096:3: 'openter' obj= inSoilExpression op= IDENT LPAREN args= exprList RPAREN
            {
            match(input,100,FOLLOW_100_in_legacyOpEnter4810); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_legacyOpEnter4818);
            obj=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            op=(Token)match(input,IDENT,FOLLOW_IDENT_in_legacyOpEnter4826); if (state.failed) return retval;

            match(input,LPAREN,FOLLOW_LPAREN_in_legacyOpEnter4830); if (state.failed) return retval;

            pushFollow(FOLLOW_exprList_in_legacyOpEnter4840);
            args=exprList();

            state._fsp--;
            if (state.failed) return retval;

            match(input,RPAREN,FOLLOW_RPAREN_in_legacyOpEnter4844); if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n = new ASTEnterOperationStatement(((Token)retval.start), obj, (op!=null?op.getText():null), args); }

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
    // $ANTLR end "legacyOpEnter"


    public static class legacyOpExit_return extends ParserRuleReturnScope {
        public ASTStatement n;
    };


    // $ANTLR start "legacyOpExit"
    // TestSuite.g:1119:1: legacyOpExit returns [ASTStatement n] : 'opexit' ( ( inSoilExpression )=>retVal= inSoilExpression | nothing ) ;
    public final TestSuiteParser.legacyOpExit_return legacyOpExit() throws RecognitionException {
        TestSuiteParser.legacyOpExit_return retval = new TestSuiteParser.legacyOpExit_return();
        retval.start = input.LT(1);


        ASTExpression retVal =null;


        try {
            // TestSuite.g:1120:3: ( 'opexit' ( ( inSoilExpression )=>retVal= inSoilExpression | nothing ) )
            // TestSuite.g:1121:3: 'opexit' ( ( inSoilExpression )=>retVal= inSoilExpression | nothing )
            {
            match(input,101,FOLLOW_101_in_legacyOpExit4879); if (state.failed) return retval;

            // TestSuite.g:1121:12: ( ( inSoilExpression )=>retVal= inSoilExpression | nothing )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==89) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==MINUS||LA66_0==PLUS||LA66_0==92) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==112) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==77) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==INT) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==REAL) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==STRING) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==55) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==54) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==52) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==53) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==48) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==HASH) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==IDENT) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==45||LA66_0==47||(LA66_0 >= 49 && LA66_0 <= 50)) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==95) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==46) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==99) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==56) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==93) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==51) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==STAR) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==AT) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==88) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==94||(LA66_0 >= 97 && LA66_0 <= 98)||(LA66_0 >= 105 && LA66_0 <= 106)) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==96) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==LPAREN) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==80) && (synpred6_TestSuite())) {
                alt66=1;
            }
            else if ( (LA66_0==EOF||LA66_0==44||LA66_0==59||LA66_0==62||(LA66_0 >= 72 && LA66_0 <= 73)) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }
            switch (alt66) {
                case 1 :
                    // TestSuite.g:1121:13: ( inSoilExpression )=>retVal= inSoilExpression
                    {
                    pushFollow(FOLLOW_inSoilExpression_in_legacyOpExit4891);
                    retVal=inSoilExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // TestSuite.g:1121:62: nothing
                    {
                    pushFollow(FOLLOW_nothing_in_legacyOpExit4895);
                    nothing();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }


            if ( state.backtracking==0 ) { retval.n = new ASTExitOperationStatement(((Token)retval.start), retVal); }

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
    // $ANTLR end "legacyOpExit"



    // $ANTLR start "legacyExecute"
    // TestSuite.g:1136:1: legacyExecute returns [ASTStatement n] : 'execute' expression ;
    public final ASTStatement legacyExecute() throws RecognitionException {
        ASTStatement n = null;


        try {
            // TestSuite.g:1137:3: ( 'execute' expression )
            // TestSuite.g:1138:3: 'execute' expression
            {
            match(input,76,FOLLOW_76_in_legacyExecute4928); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_legacyExecute4932);
            expression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { 
                reportWarning("the execute command is not supported in this version"); 
                n = new ASTEmptyStatement();
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
    // $ANTLR end "legacyExecute"



    // $ANTLR start "statOnly"
    // TestSuite.g:1182:1: statOnly returns [ASTStatement n] : s= stat EOF ;
    public final ASTStatement statOnly() throws RecognitionException {
        ASTStatement n = null;


        TestSuiteParser.stat_return s =null;


        try {
            // TestSuite.g:1183:3: (s= stat EOF )
            // TestSuite.g:1184:3: s= stat EOF
            {
            pushFollow(FOLLOW_stat_in_statOnly4978);
            s=stat();

            state._fsp--;
            if (state.failed) return n;

            match(input,EOF,FOLLOW_EOF_in_statOnly4982); if (state.failed) return n;

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
    // TestSuite.g:1194:1: stat returns [ASTStatement n] : s= singleStat ( SEMI s2= singleStat )* ;
    public final TestSuiteParser.stat_return stat() throws RecognitionException {
        TestSuiteParser.stat_return retval = new TestSuiteParser.stat_return();
        retval.start = input.LT(1);


        ASTStatement s =null;

        ASTStatement s2 =null;



          ASTSequenceStatement seq = new ASTSequenceStatement(((Token)retval.start));

        try {
            // TestSuite.g:1198:3: (s= singleStat ( SEMI s2= singleStat )* )
            // TestSuite.g:1199:3: s= singleStat ( SEMI s2= singleStat )*
            {
            pushFollow(FOLLOW_singleStat_in_stat5017);
            s=singleStat();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {seq.addStatement(s);}

            // TestSuite.g:1200:3: ( SEMI s2= singleStat )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==SEMI) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // TestSuite.g:1201:5: SEMI s2= singleStat
            	    {
            	    match(input,SEMI,FOLLOW_SEMI_in_stat5029); if (state.failed) return retval;

            	    pushFollow(FOLLOW_singleStat_in_stat5039);
            	    s2=singleStat();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {seq.addStatement(s2); }

            	    }
            	    break;

            	default :
            	    break loop67;
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
    // TestSuite.g:1213:1: singleStat returns [ASTStatement n] : (emp= emptyStat | ( statStartingWithExpr )=>sse= statStartingWithExpr |vas= varAssignStat |ocs= objCreateStat |ods= objDestroyStat |lis= lnkInsStat |lds= lnkDelStat |ces= condExStat |its= iterStat |whs= whileStat |blk= blockStat );
    public final ASTStatement singleStat() throws RecognitionException {
        ASTStatement n = null;


        ASTEmptyStatement emp =null;

        TestSuiteParser.statStartingWithExpr_return sse =null;

        ASTStatement vas =null;

        TestSuiteParser.objCreateStat_return ocs =null;

        TestSuiteParser.objDestroyStat_return ods =null;

        TestSuiteParser.lnkInsStat_return lis =null;

        TestSuiteParser.lnkDelStat_return lds =null;

        TestSuiteParser.condExStat_return ces =null;

        TestSuiteParser.iterStat_return its =null;

        TestSuiteParser.whileStat_return whs =null;

        TestSuiteParser.blockStat_return blk =null;


        try {
            // TestSuite.g:1214:5: (emp= emptyStat | ( statStartingWithExpr )=>sse= statStartingWithExpr |vas= varAssignStat |ocs= objCreateStat |ods= objDestroyStat |lis= lnkInsStat |lds= lnkDelStat |ces= condExStat |its= iterStat |whs= whileStat |blk= blockStat )
            int alt68=11;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==EOF||LA68_0==SEMI||LA68_0==44||LA68_0==59||LA68_0==62||(LA68_0 >= 71 && LA68_0 <= 73)) ) {
                alt68=1;
            }
            else if ( (LA68_0==89) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==MINUS||LA68_0==PLUS||LA68_0==92) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==112) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==77) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==INT) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==REAL) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==STRING) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==55) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==54) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==52) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==53) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==48) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==HASH) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==IDENT) ) {
                int LA68_22 = input.LA(2);

                if ( (synpred7_TestSuite()) ) {
                    alt68=2;
                }
                else if ( (true) ) {
                    alt68=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 22, input);

                    throw nvae;

                }
            }
            else if ( (LA68_0==45||LA68_0==47||(LA68_0 >= 49 && LA68_0 <= 50)) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==95) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==46) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==99) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==56) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==93) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==51) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==STAR) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==AT) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==88) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==94||(LA68_0 >= 97 && LA68_0 <= 98)||(LA68_0 >= 105 && LA68_0 <= 106)) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==96) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==LPAREN) && (synpred7_TestSuite())) {
                alt68=2;
            }
            else if ( (LA68_0==80) ) {
                int LA68_36 = input.LA(2);

                if ( (synpred7_TestSuite()) ) {
                    alt68=2;
                }
                else if ( (true) ) {
                    alt68=8;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 36, input);

                    throw nvae;

                }
            }
            else if ( (LA68_0==91) ) {
                alt68=4;
            }
            else if ( (LA68_0==68) ) {
                alt68=5;
            }
            else if ( (LA68_0==83) ) {
                alt68=6;
            }
            else if ( (LA68_0==67) ) {
                alt68=7;
            }
            else if ( (LA68_0==78) ) {
                alt68=9;
            }
            else if ( (LA68_0==114) ) {
                alt68=10;
            }
            else if ( (LA68_0==61) ) {
                alt68=11;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;

            }
            switch (alt68) {
                case 1 :
                    // TestSuite.g:1215:5: emp= emptyStat
                    {
                    pushFollow(FOLLOW_emptyStat_in_singleStat5079);
                    emp=emptyStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = emp; }

                    }
                    break;
                case 2 :
                    // TestSuite.g:1217:5: ( statStartingWithExpr )=>sse= statStartingWithExpr
                    {
                    pushFollow(FOLLOW_statStartingWithExpr_in_singleStat5105);
                    sse=statStartingWithExpr();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (sse!=null?sse.n:null); }

                    }
                    break;
                case 3 :
                    // TestSuite.g:1218:5: vas= varAssignStat
                    {
                    pushFollow(FOLLOW_varAssignStat_in_singleStat5117);
                    vas=varAssignStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = vas; }

                    }
                    break;
                case 4 :
                    // TestSuite.g:1219:5: ocs= objCreateStat
                    {
                    pushFollow(FOLLOW_objCreateStat_in_singleStat5131);
                    ocs=objCreateStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (ocs!=null?ocs.n:null); }

                    }
                    break;
                case 5 :
                    // TestSuite.g:1220:5: ods= objDestroyStat
                    {
                    pushFollow(FOLLOW_objDestroyStat_in_singleStat5145);
                    ods=objDestroyStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (ods!=null?ods.n:null); }

                    }
                    break;
                case 6 :
                    // TestSuite.g:1221:5: lis= lnkInsStat
                    {
                    pushFollow(FOLLOW_lnkInsStat_in_singleStat5158);
                    lis=lnkInsStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lis!=null?lis.n:null); }

                    }
                    break;
                case 7 :
                    // TestSuite.g:1222:5: lds= lnkDelStat
                    {
                    pushFollow(FOLLOW_lnkDelStat_in_singleStat5175);
                    lds=lnkDelStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lds!=null?lds.n:null); }

                    }
                    break;
                case 8 :
                    // TestSuite.g:1223:5: ces= condExStat
                    {
                    pushFollow(FOLLOW_condExStat_in_singleStat5192);
                    ces=condExStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (ces!=null?ces.n:null); }

                    }
                    break;
                case 9 :
                    // TestSuite.g:1224:5: its= iterStat
                    {
                    pushFollow(FOLLOW_iterStat_in_singleStat5209);
                    its=iterStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (its!=null?its.n:null); }

                    }
                    break;
                case 10 :
                    // TestSuite.g:1226:5: whs= whileStat
                    {
                    pushFollow(FOLLOW_whileStat_in_singleStat5231);
                    whs=whileStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (whs!=null?whs.n:null); }

                    }
                    break;
                case 11 :
                    // TestSuite.g:1227:5: blk= blockStat
                    {
                    pushFollow(FOLLOW_blockStat_in_singleStat5249);
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
    // TestSuite.g:1234:1: emptyStat returns [ASTEmptyStatement n] : nothing ;
    public final ASTEmptyStatement emptyStat() throws RecognitionException {
        ASTEmptyStatement n = null;


        try {
            // TestSuite.g:1235:3: ( nothing )
            // TestSuite.g:1236:3: nothing
            {
            pushFollow(FOLLOW_nothing_in_emptyStat5276);
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
    // TestSuite.g:1241:1: statStartingWithExpr returns [ASTStatement n] : expr= inSoilExpression (aas= attAssignStat[$expr.n] )? ;
    public final TestSuiteParser.statStartingWithExpr_return statStartingWithExpr() throws RecognitionException {
        TestSuiteParser.statStartingWithExpr_return retval = new TestSuiteParser.statStartingWithExpr_return();
        retval.start = input.LT(1);


        ASTExpression expr =null;

        ASTAttributeAssignmentStatement aas =null;


        try {
            // TestSuite.g:1242:3: (expr= inSoilExpression (aas= attAssignStat[$expr.n] )? )
            // TestSuite.g:1243:3: expr= inSoilExpression (aas= attAssignStat[$expr.n] )?
            {
            pushFollow(FOLLOW_inSoilExpression_in_statStartingWithExpr5302);
            expr=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            // TestSuite.g:1244:3: (aas= attAssignStat[$expr.n] )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==DOT) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // TestSuite.g:1245:5: aas= attAssignStat[$expr.n]
                    {
                    pushFollow(FOLLOW_attAssignStat_in_statStartingWithExpr5316);
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
    // TestSuite.g:1257:1: varAssignStat returns [ASTStatement n] : varName= IDENT COLON_EQUAL rVal= rValue ;
    public final ASTStatement varAssignStat() throws RecognitionException {
        ASTStatement n = null;


        Token varName=null;
        ASTRValue rVal =null;


        try {
            // TestSuite.g:1258:3: (varName= IDENT COLON_EQUAL rVal= rValue )
            // TestSuite.g:1259:3: varName= IDENT COLON_EQUAL rVal= rValue
            {
            varName=(Token)match(input,IDENT,FOLLOW_IDENT_in_varAssignStat5354); if (state.failed) return n;

            match(input,COLON_EQUAL,FOLLOW_COLON_EQUAL_in_varAssignStat5358); if (state.failed) return n;

            pushFollow(FOLLOW_rValue_in_varAssignStat5366);
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
    // TestSuite.g:1271:1: attAssignStat[ASTExpression exp] returns [ASTAttributeAssignmentStatement n] : DOT attName= IDENT COLON_EQUAL r= rValue ;
    public final ASTAttributeAssignmentStatement attAssignStat(ASTExpression exp) throws RecognitionException {
        ASTAttributeAssignmentStatement n = null;


        Token attName=null;
        ASTRValue r =null;


        try {
            // TestSuite.g:1272:3: ( DOT attName= IDENT COLON_EQUAL r= rValue )
            // TestSuite.g:1273:3: DOT attName= IDENT COLON_EQUAL r= rValue
            {
            match(input,DOT,FOLLOW_DOT_in_attAssignStat5390); if (state.failed) return n;

            attName=(Token)match(input,IDENT,FOLLOW_IDENT_in_attAssignStat5399); if (state.failed) return n;

            match(input,COLON_EQUAL,FOLLOW_COLON_EQUAL_in_attAssignStat5403); if (state.failed) return n;

            pushFollow(FOLLOW_rValue_in_attAssignStat5411);
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
    // TestSuite.g:1285:1: objCreateStat returns [ASTStatement n] : 'new' ident= simpleType ( LPAREN (objName= inSoilExpression )? RPAREN )? ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )? ;
    public final TestSuiteParser.objCreateStat_return objCreateStat() throws RecognitionException {
        TestSuiteParser.objCreateStat_return retval = new TestSuiteParser.objCreateStat_return();
        retval.start = input.LT(1);


        ASTSimpleType ident =null;

        ASTExpression objName =null;

        TestSuiteParser.rValListMin2WithOptionalQualifiers_return p =null;


        try {
            // TestSuite.g:1286:3: ( 'new' ident= simpleType ( LPAREN (objName= inSoilExpression )? RPAREN )? ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )? )
            // TestSuite.g:1287:3: 'new' ident= simpleType ( LPAREN (objName= inSoilExpression )? RPAREN )? ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )?
            {
            match(input,91,FOLLOW_91_in_objCreateStat5437); if (state.failed) return retval;

            pushFollow(FOLLOW_simpleType_in_objCreateStat5445);
            ident=simpleType();

            state._fsp--;
            if (state.failed) return retval;

            // TestSuite.g:1289:3: ( LPAREN (objName= inSoilExpression )? RPAREN )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==LPAREN) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // TestSuite.g:1290:5: LPAREN (objName= inSoilExpression )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_objCreateStat5455); if (state.failed) return retval;

                    // TestSuite.g:1291:7: (objName= inSoilExpression )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==AT||LA70_0==HASH||(LA70_0 >= IDENT && LA70_0 <= INT)||(LA70_0 >= LPAREN && LA70_0 <= MINUS)||LA70_0==PLUS||LA70_0==REAL||(LA70_0 >= STAR && LA70_0 <= STRING)||(LA70_0 >= 45 && LA70_0 <= 56)||LA70_0==77||LA70_0==80||(LA70_0 >= 88 && LA70_0 <= 89)||(LA70_0 >= 92 && LA70_0 <= 99)||(LA70_0 >= 105 && LA70_0 <= 106)||LA70_0==112) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // TestSuite.g:1291:8: objName= inSoilExpression
                            {
                            pushFollow(FOLLOW_inSoilExpression_in_objCreateStat5468);
                            objName=inSoilExpression();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_objCreateStat5476); if (state.failed) return retval;

                    }
                    break;

            }


            // TestSuite.g:1295:3: ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==63) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // TestSuite.g:1296:5: 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN
                    {
                    match(input,63,FOLLOW_63_in_objCreateStat5494); if (state.failed) return retval;

                    match(input,LPAREN,FOLLOW_LPAREN_in_objCreateStat5502); if (state.failed) return retval;

                    pushFollow(FOLLOW_rValListMin2WithOptionalQualifiers_in_objCreateStat5516);
                    p=rValListMin2WithOptionalQualifiers();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,RPAREN,FOLLOW_RPAREN_in_objCreateStat5524); if (state.failed) return retval;

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
    // TestSuite.g:1315:1: objDestroyStat returns [ASTStatement n] : 'destroy' el= exprListMin1 ;
    public final TestSuiteParser.objDestroyStat_return objDestroyStat() throws RecognitionException {
        TestSuiteParser.objDestroyStat_return retval = new TestSuiteParser.objDestroyStat_return();
        retval.start = input.LT(1);


        List<ASTExpression> el =null;


        try {
            // TestSuite.g:1316:3: ( 'destroy' el= exprListMin1 )
            // TestSuite.g:1317:3: 'destroy' el= exprListMin1
            {
            match(input,68,FOLLOW_68_in_objDestroyStat5560); if (state.failed) return retval;

            pushFollow(FOLLOW_exprListMin1_in_objDestroyStat5568);
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
    // TestSuite.g:1336:1: lnkInsStat returns [ASTLinkInsertionStatement n] : 'insert' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'into' ass= IDENT ;
    public final TestSuiteParser.lnkInsStat_return lnkInsStat() throws RecognitionException {
        TestSuiteParser.lnkInsStat_return retval = new TestSuiteParser.lnkInsStat_return();
        retval.start = input.LT(1);


        Token ass=null;
        TestSuiteParser.rValListMin2WithOptionalQualifiers_return p =null;


        try {
            // TestSuite.g:1337:3: ( 'insert' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'into' ass= IDENT )
            // TestSuite.g:1338:3: 'insert' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'into' ass= IDENT
            {
            match(input,83,FOLLOW_83_in_lnkInsStat5594); if (state.failed) return retval;

            match(input,LPAREN,FOLLOW_LPAREN_in_lnkInsStat5598); if (state.failed) return retval;

            pushFollow(FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkInsStat5608);
            p=rValListMin2WithOptionalQualifiers();

            state._fsp--;
            if (state.failed) return retval;

            match(input,RPAREN,FOLLOW_RPAREN_in_lnkInsStat5612); if (state.failed) return retval;

            match(input,84,FOLLOW_84_in_lnkInsStat5616); if (state.failed) return retval;

            ass=(Token)match(input,IDENT,FOLLOW_IDENT_in_lnkInsStat5624); if (state.failed) return retval;

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
    // TestSuite.g:1348:1: rValListMin2WithOptionalQualifiers returns [List<ASTRValue> participans, List<List<ASTRValue>> qualifiers] : r= rValue ( LBRACE qualifierValues= rValList RBRACE )? COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )* ;
    public final TestSuiteParser.rValListMin2WithOptionalQualifiers_return rValListMin2WithOptionalQualifiers() throws RecognitionException {
        TestSuiteParser.rValListMin2WithOptionalQualifiers_return retval = new TestSuiteParser.rValListMin2WithOptionalQualifiers_return();
        retval.start = input.LT(1);


        ASTRValue r =null;

        List<ASTRValue> qualifierValues =null;



          retval.participans = new ArrayList<ASTRValue>();
          retval.qualifiers = new ArrayList<List<ASTRValue>>();
          List<ASTRValue> currentQualifiers = Collections.emptyList();

        try {
            // TestSuite.g:1354:3: (r= rValue ( LBRACE qualifierValues= rValList RBRACE )? COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )* )
            // TestSuite.g:1355:3: r= rValue ( LBRACE qualifierValues= rValList RBRACE )? COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )*
            {
            pushFollow(FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5653);
            r=rValue();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.participans.add(r); }

            // TestSuite.g:1356:3: ( LBRACE qualifierValues= rValList RBRACE )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==LBRACE) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // TestSuite.g:1357:4: LBRACE qualifierValues= rValList RBRACE
                    {
                    match(input,LBRACE,FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5664); if (state.failed) return retval;

                    pushFollow(FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5673);
                    qualifierValues=rValList();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {currentQualifiers = qualifierValues;}

                    match(input,RBRACE,FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5680); if (state.failed) return retval;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                retval.qualifiers.add(currentQualifiers);
                currentQualifiers = Collections.emptyList();
              }

            match(input,COMMA,FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers5696); if (state.failed) return retval;

            pushFollow(FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5707);
            r=rValue();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.participans.add(r); }

            // TestSuite.g:1369:3: ( LBRACE qualifierValues= rValList RBRACE )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==LBRACE) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // TestSuite.g:1370:4: LBRACE qualifierValues= rValList RBRACE
                    {
                    match(input,LBRACE,FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5718); if (state.failed) return retval;

                    pushFollow(FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5727);
                    qualifierValues=rValList();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {currentQualifiers = qualifierValues;}

                    match(input,RBRACE,FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5734); if (state.failed) return retval;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                retval.qualifiers.add(currentQualifiers);
                currentQualifiers = Collections.emptyList();
              }

            // TestSuite.g:1379:3: ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==COMMA) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // TestSuite.g:1380:5: COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )?
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers5756); if (state.failed) return retval;

            	    pushFollow(FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5771);
            	    r=rValue();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { retval.participans.add(r); }

            	    // TestSuite.g:1384:5: ( LBRACE qualifierValues= rValList RBRACE )?
            	    int alt75=2;
            	    int LA75_0 = input.LA(1);

            	    if ( (LA75_0==LBRACE) ) {
            	        alt75=1;
            	    }
            	    switch (alt75) {
            	        case 1 :
            	            // TestSuite.g:1385:6: LBRACE qualifierValues= rValList RBRACE
            	            {
            	            match(input,LBRACE,FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5791); if (state.failed) return retval;

            	            pushFollow(FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5802);
            	            qualifierValues=rValList();

            	            state._fsp--;
            	            if (state.failed) return retval;

            	            if ( state.backtracking==0 ) {currentQualifiers = qualifierValues;}

            	            match(input,RBRACE,FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5811); if (state.failed) return retval;

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
            	    break loop76;
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
    // TestSuite.g:1400:1: lnkDelStat returns [ASTLinkDeletionStatement n] : 'delete' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'from' ass= IDENT ;
    public final TestSuiteParser.lnkDelStat_return lnkDelStat() throws RecognitionException {
        TestSuiteParser.lnkDelStat_return retval = new TestSuiteParser.lnkDelStat_return();
        retval.start = input.LT(1);


        Token ass=null;
        TestSuiteParser.rValListMin2WithOptionalQualifiers_return p =null;


        try {
            // TestSuite.g:1401:3: ( 'delete' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'from' ass= IDENT )
            // TestSuite.g:1402:3: 'delete' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'from' ass= IDENT
            {
            match(input,67,FOLLOW_67_in_lnkDelStat5852); if (state.failed) return retval;

            match(input,LPAREN,FOLLOW_LPAREN_in_lnkDelStat5856); if (state.failed) return retval;

            pushFollow(FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkDelStat5866);
            p=rValListMin2WithOptionalQualifiers();

            state._fsp--;
            if (state.failed) return retval;

            match(input,RPAREN,FOLLOW_RPAREN_in_lnkDelStat5870); if (state.failed) return retval;

            match(input,79,FOLLOW_79_in_lnkDelStat5874); if (state.failed) return retval;

            ass=(Token)match(input,IDENT,FOLLOW_IDENT_in_lnkDelStat5883); if (state.failed) return retval;

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
    // TestSuite.g:1416:1: condExStat returns [ASTConditionalExecutionStatement n] : 'if' con= inSoilExpression 'then' ts= statOrImplicitBlock ( 'else' es= statOrImplicitBlock )? 'end' ;
    public final TestSuiteParser.condExStat_return condExStat() throws RecognitionException {
        TestSuiteParser.condExStat_return retval = new TestSuiteParser.condExStat_return();
        retval.start = input.LT(1);


        ASTExpression con =null;

        ASTStatement ts =null;

        ASTStatement es =null;



          ASTStatement elseStat = new ASTEmptyStatement();

        try {
            // TestSuite.g:1420:3: ( 'if' con= inSoilExpression 'then' ts= statOrImplicitBlock ( 'else' es= statOrImplicitBlock )? 'end' )
            // TestSuite.g:1421:3: 'if' con= inSoilExpression 'then' ts= statOrImplicitBlock ( 'else' es= statOrImplicitBlock )? 'end'
            {
            match(input,80,FOLLOW_80_in_condExStat5914); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_condExStat5923);
            con=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            match(input,111,FOLLOW_111_in_condExStat5927); if (state.failed) return retval;

            pushFollow(FOLLOW_statOrImplicitBlock_in_condExStat5936);
            ts=statOrImplicitBlock();

            state._fsp--;
            if (state.failed) return retval;

            // TestSuite.g:1425:3: ( 'else' es= statOrImplicitBlock )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==71) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // TestSuite.g:1426:5: 'else' es= statOrImplicitBlock
                    {
                    match(input,71,FOLLOW_71_in_condExStat5947); if (state.failed) return retval;

                    pushFollow(FOLLOW_statOrImplicitBlock_in_condExStat5959);
                    es=statOrImplicitBlock();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { elseStat = es; }

                    }
                    break;

            }


            match(input,72,FOLLOW_72_in_condExStat5971); if (state.failed) return retval;

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
    // TestSuite.g:1437:1: iterStat returns [ASTIterationStatement n] : 'for' var= IDENT 'in' set= inSoilExpression 'do' s= statOrImplicitBlock 'end' ;
    public final TestSuiteParser.iterStat_return iterStat() throws RecognitionException {
        TestSuiteParser.iterStat_return retval = new TestSuiteParser.iterStat_return();
        retval.start = input.LT(1);


        Token var=null;
        ASTExpression set =null;

        ASTStatement s =null;


        try {
            // TestSuite.g:1438:3: ( 'for' var= IDENT 'in' set= inSoilExpression 'do' s= statOrImplicitBlock 'end' )
            // TestSuite.g:1439:3: 'for' var= IDENT 'in' set= inSoilExpression 'do' s= statOrImplicitBlock 'end'
            {
            match(input,78,FOLLOW_78_in_iterStat5996); if (state.failed) return retval;

            var=(Token)match(input,IDENT,FOLLOW_IDENT_in_iterStat6004); if (state.failed) return retval;

            match(input,82,FOLLOW_82_in_iterStat6008); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_iterStat6016);
            set=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            match(input,70,FOLLOW_70_in_iterStat6020); if (state.failed) return retval;

            pushFollow(FOLLOW_statOrImplicitBlock_in_iterStat6028);
            s=statOrImplicitBlock();

            state._fsp--;
            if (state.failed) return retval;

            match(input,72,FOLLOW_72_in_iterStat6033); if (state.failed) return retval;

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
    // TestSuite.g:1454:1: whileStat returns [ASTWhileStatement n] : 'while' cond= inSoilExpression 'do' s= statOrImplicitBlock 'end' ;
    public final TestSuiteParser.whileStat_return whileStat() throws RecognitionException {
        TestSuiteParser.whileStat_return retval = new TestSuiteParser.whileStat_return();
        retval.start = input.LT(1);


        ASTExpression cond =null;

        ASTStatement s =null;


        try {
            // TestSuite.g:1455:3: ( 'while' cond= inSoilExpression 'do' s= statOrImplicitBlock 'end' )
            // TestSuite.g:1456:3: 'while' cond= inSoilExpression 'do' s= statOrImplicitBlock 'end'
            {
            match(input,114,FOLLOW_114_in_whileStat6059); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_whileStat6067);
            cond=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            match(input,70,FOLLOW_70_in_whileStat6071); if (state.failed) return retval;

            pushFollow(FOLLOW_statOrImplicitBlock_in_whileStat6079);
            s=statOrImplicitBlock();

            state._fsp--;
            if (state.failed) return retval;

            match(input,72,FOLLOW_72_in_whileStat6084); if (state.failed) return retval;

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
    // TestSuite.g:1468:1: blockStat returns [ASTBlockStatement n] : 'begin' ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )? s= stat 'end' ;
    public final TestSuiteParser.blockStat_return blockStat() throws RecognitionException {
        TestSuiteParser.blockStat_return retval = new TestSuiteParser.blockStat_return();
        retval.start = input.LT(1);


        ASTVariableDeclaration vd =null;

        ASTVariableDeclaration vd1 =null;

        TestSuiteParser.stat_return s =null;



          retval.n = new ASTBlockStatement(((Token)retval.start), org.tzi.use.config.Options.explicitVariableDeclarations);

        try {
            // TestSuite.g:1472:2: ( 'begin' ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )? s= stat 'end' )
            // TestSuite.g:1473:2: 'begin' ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )? s= stat 'end'
            {
            match(input,61,FOLLOW_61_in_blockStat6114); if (state.failed) return retval;

            // TestSuite.g:1474:2: ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==66) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // TestSuite.g:1474:4: 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI
                    {
                    match(input,66,FOLLOW_66_in_blockStat6119); if (state.failed) return retval;

                    pushFollow(FOLLOW_variableDeclaration_in_blockStat6125);
                    vd=variableDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd);}

                    // TestSuite.g:1474:73: ( COMMA vd1= variableDeclaration )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==COMMA) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // TestSuite.g:1474:75: COMMA vd1= variableDeclaration
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_blockStat6131); if (state.failed) return retval;

                    	    pushFollow(FOLLOW_variableDeclaration_in_blockStat6137);
                    	    vd1=variableDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd1);}

                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);


                    match(input,SEMI,FOLLOW_SEMI_in_blockStat6144); if (state.failed) return retval;

                    }
                    break;

            }


            pushFollow(FOLLOW_stat_in_blockStat6154);
            s=stat();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n.setBody((s!=null?s.n:null)); }

            match(input,72,FOLLOW_72_in_blockStat6159); if (state.failed) return retval;

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
    // TestSuite.g:1483:1: implicitBlockStat returns [ASTBlockStatement n] : 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI s= stat ;
    public final TestSuiteParser.implicitBlockStat_return implicitBlockStat() throws RecognitionException {
        TestSuiteParser.implicitBlockStat_return retval = new TestSuiteParser.implicitBlockStat_return();
        retval.start = input.LT(1);


        ASTVariableDeclaration vd =null;

        ASTVariableDeclaration vd1 =null;

        TestSuiteParser.stat_return s =null;



          retval.n = new ASTBlockStatement(((Token)retval.start), false);

        try {
            // TestSuite.g:1487:3: ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI s= stat )
            // TestSuite.g:1488:3: 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI s= stat
            {
            match(input,66,FOLLOW_66_in_implicitBlockStat6185); if (state.failed) return retval;

            pushFollow(FOLLOW_variableDeclaration_in_implicitBlockStat6191);
            vd=variableDeclaration();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd);}

            // TestSuite.g:1488:72: ( COMMA vd1= variableDeclaration )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==COMMA) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // TestSuite.g:1488:74: COMMA vd1= variableDeclaration
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_implicitBlockStat6197); if (state.failed) return retval;

            	    pushFollow(FOLLOW_variableDeclaration_in_implicitBlockStat6203);
            	    vd1=variableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd1);}

            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);


            match(input,SEMI,FOLLOW_SEMI_in_implicitBlockStat6210); if (state.failed) return retval;

            pushFollow(FOLLOW_stat_in_implicitBlockStat6218);
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
    // TestSuite.g:1492:1: statOrImplicitBlock returns [ASTStatement n] : (s1= stat |s2= implicitBlockStat ) ;
    public final ASTStatement statOrImplicitBlock() throws RecognitionException {
        ASTStatement n = null;


        TestSuiteParser.stat_return s1 =null;

        TestSuiteParser.implicitBlockStat_return s2 =null;


        try {
            // TestSuite.g:1493:3: ( (s1= stat |s2= implicitBlockStat ) )
            // TestSuite.g:1494:3: (s1= stat |s2= implicitBlockStat )
            {
            // TestSuite.g:1494:3: (s1= stat |s2= implicitBlockStat )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==AT||LA81_0==HASH||(LA81_0 >= IDENT && LA81_0 <= INT)||(LA81_0 >= LPAREN && LA81_0 <= MINUS)||LA81_0==PLUS||LA81_0==REAL||LA81_0==SEMI||(LA81_0 >= STAR && LA81_0 <= STRING)||(LA81_0 >= 45 && LA81_0 <= 56)||LA81_0==61||(LA81_0 >= 67 && LA81_0 <= 68)||(LA81_0 >= 71 && LA81_0 <= 72)||(LA81_0 >= 77 && LA81_0 <= 78)||LA81_0==80||LA81_0==83||(LA81_0 >= 88 && LA81_0 <= 89)||(LA81_0 >= 91 && LA81_0 <= 99)||(LA81_0 >= 105 && LA81_0 <= 106)||LA81_0==112||LA81_0==114) ) {
                alt81=1;
            }
            else if ( (LA81_0==66) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;

            }
            switch (alt81) {
                case 1 :
                    // TestSuite.g:1494:4: s1= stat
                    {
                    pushFollow(FOLLOW_stat_in_statOrImplicitBlock6241);
                    s1=stat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (s1!=null?s1.n:null); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:1494:31: s2= implicitBlockStat
                    {
                    pushFollow(FOLLOW_implicitBlockStat_in_statOrImplicitBlock6251);
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
    // TestSuite.g:1508:1: nothing :;
    public final void nothing() throws RecognitionException {
        try {
            // TestSuite.g:1509:1: ()
            // TestSuite.g:1510:1: 
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
    // TestSuite.g:1516:1: rValue returns [ASTRValue n] : (e= inSoilExpression |oc= objCreateStat );
    public final ASTRValue rValue() throws RecognitionException {
        ASTRValue n = null;


        ASTExpression e =null;

        TestSuiteParser.objCreateStat_return oc =null;


        try {
            // TestSuite.g:1517:5: (e= inSoilExpression |oc= objCreateStat )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==AT||LA82_0==HASH||(LA82_0 >= IDENT && LA82_0 <= INT)||(LA82_0 >= LPAREN && LA82_0 <= MINUS)||LA82_0==PLUS||LA82_0==REAL||(LA82_0 >= STAR && LA82_0 <= STRING)||(LA82_0 >= 45 && LA82_0 <= 56)||LA82_0==77||LA82_0==80||(LA82_0 >= 88 && LA82_0 <= 89)||(LA82_0 >= 92 && LA82_0 <= 99)||(LA82_0 >= 105 && LA82_0 <= 106)||LA82_0==112) ) {
                alt82=1;
            }
            else if ( (LA82_0==91) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;

            }
            switch (alt82) {
                case 1 :
                    // TestSuite.g:1518:5: e= inSoilExpression
                    {
                    pushFollow(FOLLOW_inSoilExpression_in_rValue6297);
                    e=inSoilExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTRValueExpressionOrOpCall(e); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:1519:5: oc= objCreateStat
                    {
                    pushFollow(FOLLOW_objCreateStat_in_rValue6309);
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
    // TestSuite.g:1532:1: rValList returns [List<ASTRValue> n] : ( nothing |rl= rValListMin1 );
    public final List<ASTRValue> rValList() throws RecognitionException {
        List<ASTRValue> n = null;


        List<ASTRValue> rl =null;


        try {
            // TestSuite.g:1533:3: ( nothing |rl= rValListMin1 )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RBRACE) ) {
                alt83=1;
            }
            else if ( (LA83_0==AT||LA83_0==HASH||(LA83_0 >= IDENT && LA83_0 <= INT)||(LA83_0 >= LPAREN && LA83_0 <= MINUS)||LA83_0==PLUS||LA83_0==REAL||(LA83_0 >= STAR && LA83_0 <= STRING)||(LA83_0 >= 45 && LA83_0 <= 56)||LA83_0==77||LA83_0==80||(LA83_0 >= 88 && LA83_0 <= 89)||(LA83_0 >= 91 && LA83_0 <= 99)||(LA83_0 >= 105 && LA83_0 <= 106)||LA83_0==112) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;

            }
            switch (alt83) {
                case 1 :
                    // TestSuite.g:1534:3: nothing
                    {
                    pushFollow(FOLLOW_nothing_in_rValList6332);
                    nothing();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = Collections.<ASTRValue>emptyList(); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:1537:3: rl= rValListMin1
                    {
                    pushFollow(FOLLOW_rValListMin1_in_rValList6359);
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
    // TestSuite.g:1545:1: rValListMin1 returns [List<ASTRValue> n] : r= rValue ( COMMA r= rValue )* ;
    public final List<ASTRValue> rValListMin1() throws RecognitionException {
        List<ASTRValue> n = null;


        ASTRValue r =null;



          n = new ArrayList<ASTRValue>();

        try {
            // TestSuite.g:1549:3: (r= rValue ( COMMA r= rValue )* )
            // TestSuite.g:1550:3: r= rValue ( COMMA r= rValue )*
            {
            pushFollow(FOLLOW_rValue_in_rValListMin16392);
            r=rValue();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add(r); }

            // TestSuite.g:1552:3: ( COMMA r= rValue )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==COMMA) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // TestSuite.g:1553:5: COMMA r= rValue
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_rValListMin16406); if (state.failed) return n;

            	    pushFollow(FOLLOW_rValue_in_rValListMin16416);
            	    r=rValue();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n.add(r); }

            	    }
            	    break;

            	default :
            	    break loop84;
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
    // TestSuite.g:1563:1: rValListMin2 returns [List<ASTRValue> n] : r= rValue COMMA r= rValue ( COMMA r= rValue )* ;
    public final List<ASTRValue> rValListMin2() throws RecognitionException {
        List<ASTRValue> n = null;


        ASTRValue r =null;



          n = new ArrayList<ASTRValue>();

        try {
            // TestSuite.g:1567:3: (r= rValue COMMA r= rValue ( COMMA r= rValue )* )
            // TestSuite.g:1568:3: r= rValue COMMA r= rValue ( COMMA r= rValue )*
            {
            pushFollow(FOLLOW_rValue_in_rValListMin26455);
            r=rValue();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add(r); }

            match(input,COMMA,FOLLOW_COMMA_in_rValListMin26463); if (state.failed) return n;

            pushFollow(FOLLOW_rValue_in_rValListMin26471);
            r=rValue();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add(r); }

            // TestSuite.g:1573:3: ( COMMA r= rValue )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==COMMA) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // TestSuite.g:1574:5: COMMA r= rValue
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_rValListMin26485); if (state.failed) return n;

            	    pushFollow(FOLLOW_rValue_in_rValListMin26495);
            	    r=rValue();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n.add(r); }

            	    }
            	    break;

            	default :
            	    break loop85;
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
    // TestSuite.g:1584:1: inSoilExpression returns [ASTExpression n] : e= expression ;
    public final ASTExpression inSoilExpression() throws RecognitionException {
        ASTExpression n = null;


        TestSuiteParser.expression_return e =null;


        try {
            // TestSuite.g:1585:3: (e= expression )
            // TestSuite.g:1586:3: e= expression
            {
            pushFollow(FOLLOW_expression_in_inSoilExpression6529);
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
    // TestSuite.g:1595:1: exprList returns [List<ASTExpression> n] : ( nothing |el= exprListMin1 );
    public final List<ASTExpression> exprList() throws RecognitionException {
        List<ASTExpression> n = null;


        List<ASTExpression> el =null;


        try {
            // TestSuite.g:1596:3: ( nothing |el= exprListMin1 )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RPAREN) ) {
                alt86=1;
            }
            else if ( (LA86_0==AT||LA86_0==HASH||(LA86_0 >= IDENT && LA86_0 <= INT)||(LA86_0 >= LPAREN && LA86_0 <= MINUS)||LA86_0==PLUS||LA86_0==REAL||(LA86_0 >= STAR && LA86_0 <= STRING)||(LA86_0 >= 45 && LA86_0 <= 56)||LA86_0==77||LA86_0==80||(LA86_0 >= 88 && LA86_0 <= 89)||(LA86_0 >= 92 && LA86_0 <= 99)||(LA86_0 >= 105 && LA86_0 <= 106)||LA86_0==112) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;

            }
            switch (alt86) {
                case 1 :
                    // TestSuite.g:1597:3: nothing
                    {
                    pushFollow(FOLLOW_nothing_in_exprList6558);
                    nothing();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ArrayList<ASTExpression>(); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:1600:3: el= exprListMin1
                    {
                    pushFollow(FOLLOW_exprListMin1_in_exprList6576);
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
    // TestSuite.g:1608:1: exprListMin1 returns [List<ASTExpression> n] : e= inSoilExpression ( COMMA e= inSoilExpression )* ;
    public final List<ASTExpression> exprListMin1() throws RecognitionException {
        List<ASTExpression> n = null;


        ASTExpression e =null;



          n = new ArrayList<ASTExpression>();

        try {
            // TestSuite.g:1612:3: (e= inSoilExpression ( COMMA e= inSoilExpression )* )
            // TestSuite.g:1613:3: e= inSoilExpression ( COMMA e= inSoilExpression )*
            {
            pushFollow(FOLLOW_inSoilExpression_in_exprListMin16609);
            e=inSoilExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            // TestSuite.g:1615:3: ( COMMA e= inSoilExpression )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==COMMA) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // TestSuite.g:1616:5: COMMA e= inSoilExpression
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_exprListMin16624); if (state.failed) return n;

            	    pushFollow(FOLLOW_inSoilExpression_in_exprListMin16634);
            	    e=inSoilExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            	    }
            	    break;

            	default :
            	    break loop87;
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
    // TestSuite.g:1626:1: exprListMin2 returns [List<ASTExpression> n] : e= inSoilExpression COMMA e= inSoilExpression ( COMMA e= inSoilExpression )* ;
    public final List<ASTExpression> exprListMin2() throws RecognitionException {
        List<ASTExpression> n = null;


        ASTExpression e =null;



          n = new ArrayList<ASTExpression>();

        try {
            // TestSuite.g:1630:3: (e= inSoilExpression COMMA e= inSoilExpression ( COMMA e= inSoilExpression )* )
            // TestSuite.g:1631:3: e= inSoilExpression COMMA e= inSoilExpression ( COMMA e= inSoilExpression )*
            {
            pushFollow(FOLLOW_inSoilExpression_in_exprListMin26674);
            e=inSoilExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            match(input,COMMA,FOLLOW_COMMA_in_exprListMin26682); if (state.failed) return n;

            pushFollow(FOLLOW_inSoilExpression_in_exprListMin26690);
            e=inSoilExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            // TestSuite.g:1636:3: ( COMMA e= inSoilExpression )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==COMMA) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // TestSuite.g:1637:5: COMMA e= inSoilExpression
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_exprListMin26704); if (state.failed) return n;

            	    pushFollow(FOLLOW_inSoilExpression_in_exprListMin26714);
            	    e=inSoilExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            	    }
            	    break;

            	default :
            	    break loop88;
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
    // TestSuite.g:1647:1: identList returns [List<String> n] : ( nothing |il= identListMin1 );
    public final List<String> identList() throws RecognitionException {
        List<String> n = null;


        List<String> il =null;


        try {
            // TestSuite.g:1648:3: ( nothing |il= identListMin1 )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==EOF||LA89_0==RBRACE||(LA89_0 >= RPAREN && LA89_0 <= SEMI)||LA89_0==44||LA89_0==59||LA89_0==62||(LA89_0 >= 71 && LA89_0 <= 73)) ) {
                alt89=1;
            }
            else if ( (LA89_0==IDENT) ) {
                alt89=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;

            }
            switch (alt89) {
                case 1 :
                    // TestSuite.g:1649:3: nothing
                    {
                    pushFollow(FOLLOW_nothing_in_identList6744);
                    nothing();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ArrayList<String>(); }

                    }
                    break;
                case 2 :
                    // TestSuite.g:1652:3: il= identListMin1
                    {
                    pushFollow(FOLLOW_identListMin1_in_identList6761);
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
    // TestSuite.g:1660:1: identListMin1 returns [List<String> n] : id= IDENT ( COMMA id= IDENT )* ;
    public final List<String> identListMin1() throws RecognitionException {
        List<String> n = null;


        Token id=null;


          n = new ArrayList<String>();

        try {
            // TestSuite.g:1664:3: (id= IDENT ( COMMA id= IDENT )* )
            // TestSuite.g:1665:3: id= IDENT ( COMMA id= IDENT )*
            {
            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_identListMin16795); if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add((id!=null?id.getText():null)); }

            // TestSuite.g:1667:3: ( COMMA id= IDENT )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==COMMA) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // TestSuite.g:1668:5: COMMA id= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_identListMin16809); if (state.failed) return n;

            	    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_identListMin16819); if (state.failed) return n;

            	    if ( state.backtracking==0 ) {
            	        n.add((id!=null?id.getText():null)); }

            	    }
            	    break;

            	default :
            	    break loop90;
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

    // $ANTLR start synpred1_TestSuite
    public final void synpred1_TestSuite_fragment() throws RecognitionException {
        // TestSuite.g:776:7: ( COLON type EQUAL )
        // TestSuite.g:776:8: COLON type EQUAL
        {
        match(input,COLON,FOLLOW_COLON_in_synpred1_TestSuite3665); if (state.failed) return ;

        pushFollow(FOLLOW_type_in_synpred1_TestSuite3667);
        type();

        state._fsp--;
        if (state.failed) return ;

        match(input,EQUAL,FOLLOW_EQUAL_in_synpred1_TestSuite3669); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_TestSuite

    // $ANTLR start synpred2_TestSuite
    public final void synpred2_TestSuite_fragment() throws RecognitionException {
        // TestSuite.g:869:3: ( stat )
        // TestSuite.g:869:4: stat
        {
        pushFollow(FOLLOW_stat_in_synpred2_TestSuite4127);
        stat();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_TestSuite

    // $ANTLR start synpred3_TestSuite
    public final void synpred3_TestSuite_fragment() throws RecognitionException {
        // TestSuite.g:872:3: ( legacyStat )
        // TestSuite.g:872:4: legacyStat
        {
        pushFollow(FOLLOW_legacyStat_in_synpred3_TestSuite4148);
        legacyStat();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_TestSuite

    // $ANTLR start synpred4_TestSuite
    public final void synpred4_TestSuite_fragment() throws RecognitionException {
        // TestSuite.g:882:3: ( legacyStat )
        // TestSuite.g:882:4: legacyStat
        {
        pushFollow(FOLLOW_legacyStat_in_synpred4_TestSuite4180);
        legacyStat();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_TestSuite

    // $ANTLR start synpred5_TestSuite
    public final void synpred5_TestSuite_fragment() throws RecognitionException {
        // TestSuite.g:885:3: ( stat )
        // TestSuite.g:885:4: stat
        {
        pushFollow(FOLLOW_stat_in_synpred5_TestSuite4203);
        stat();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_TestSuite

    // $ANTLR start synpred6_TestSuite
    public final void synpred6_TestSuite_fragment() throws RecognitionException {
        // TestSuite.g:1121:13: ( inSoilExpression )
        // TestSuite.g:1121:14: inSoilExpression
        {
        pushFollow(FOLLOW_inSoilExpression_in_synpred6_TestSuite4883);
        inSoilExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_TestSuite

    // $ANTLR start synpred7_TestSuite
    public final void synpred7_TestSuite_fragment() throws RecognitionException {
        // TestSuite.g:1217:5: ( statStartingWithExpr )
        // TestSuite.g:1217:6: statStartingWithExpr
        {
        pushFollow(FOLLOW_statStartingWithExpr_in_synpred7_TestSuite5097);
        statStartingWithExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred7_TestSuite

    // Delegated rules

    public final boolean synpred2_TestSuite() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_TestSuite_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_TestSuite() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_TestSuite_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_TestSuite() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_TestSuite_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_TestSuite() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_TestSuite_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_TestSuite() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_TestSuite_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_TestSuite() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_TestSuite_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_TestSuite() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_TestSuite_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_110_in_testSuite61 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_testSuite71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_testSuite82 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_testSuite84 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_filename_in_testSuite93 = new BitSet(new long[]{0x0000000000000000L,0x0000300000000000L});
    public static final BitSet FOLLOW_108_in_testSuite105 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_44_in_testSuite112 = new BitSet(new long[]{0x31FFE308861A0020L,0x00050E3FFB09701AL});
    public static final BitSet FOLLOW_shellCommandOnly_in_testSuite118 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_testSuite124 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_testCases_in_testSuite145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_testSuite154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_filename172 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_DOT_in_filename174 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_filename178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_testCase_in_testCases205 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_testCase224 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_testCase228 = new BitSet(new long[]{0x4800100000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_44_in_testCase242 = new BitSet(new long[]{0x31FFE308861A0020L,0x00050E3FFB09701AL});
    public static final BitSet FOLLOW_shellCommandOnly_in_testCase248 = new BitSet(new long[]{0x4800100000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_assertStatement_in_testCase267 = new BitSet(new long[]{0x4800100000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_62_in_testCase285 = new BitSet(new long[]{0x4800100000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_73_in_testCase303 = new BitSet(new long[]{0x4800100000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_72_in_testCase315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_assertStatement336 = new BitSet(new long[]{0x0000000000000000L,0x0002000000400000L});
    public static final BitSet FOLLOW_113_in_assertStatement341 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001078FF3A12000L});
    public static final BitSet FOLLOW_86_in_assertStatement347 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001078FF3A12000L});
    public static final BitSet FOLLOW_expression_in_assertStatement366 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_87_in_assertStatement382 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_87_in_assertStatement398 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_assertStatement402 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_85_in_assertStatement418 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_assertStatement422 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_COLON_in_assertStatement424 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_assertStatement428 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_assertionStatementPre_in_assertStatement448 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_assertionStatementPost_in_assertStatement469 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_assertStatement486 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_STRING_in_assertStatement490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_assertionStatementPre513 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_assertionStatementPre517 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_assertionStatementPre521 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_assertionStatementPre527 = new BitSet(new long[]{0x01FFE318861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_assertionStatementPre538 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_assertionStatementPre544 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_assertionStatementPre548 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_RPAREN_in_assertionStatementPre561 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_COLON_COLON_in_assertionStatementPre564 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_assertionStatementPre568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_assertionStatementPost593 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_IDENT_in_assertionStatementPost602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionOnly638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expressionOnly640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_expression688 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_expression699 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_COLON_in_expression703 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_expression707 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_expression712 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_expression716 = new BitSet(new long[]{0x0000000000000400L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_expression754 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_expression766 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_COLON_in_expression770 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_expression774 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_expression779 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_expression783 = new BitSet(new long[]{0x0000000000000400L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_expression824 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_identicalExpression_in_expression840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_paramList873 = new BitSet(new long[]{0x0000001000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_paramList890 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_paramList902 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_paramList906 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_RPAREN_in_paramList926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_idList955 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_idList965 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_idList969 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_IDENT_in_variableDeclaration1000 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_variableDeclaration1002 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_variableDeclaration1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalImpliesExpression_in_identicalExpression1037 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_DOT_in_identicalExpression1055 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_identicalExpression1059 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_identicalExpression1061 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_conditionalImpliesExpression_in_identicalExpression1065 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_identicalExpression1067 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression1110 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_conditionalImpliesExpression1123 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression1127 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_conditionalXOrExpression_in_conditionalOrExpression1172 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_conditionalOrExpression1185 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_conditionalXOrExpression_in_conditionalOrExpression1189 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalXOrExpression1233 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_conditionalXOrExpression1246 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalXOrExpression1250 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_equalityExpression_in_conditionalAndExpression1294 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_conditionalAndExpression1307 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_equalityExpression_in_conditionalAndExpression1311 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression1359 = new BitSet(new long[]{0x0000000040002002L});
    public static final BitSet FOLLOW_set_in_equalityExpression1378 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression1388 = new BitSet(new long[]{0x0000000040002002L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1437 = new BitSet(new long[]{0x0000000001818002L});
    public static final BitSet FOLLOW_set_in_relationalExpression1455 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1473 = new BitSet(new long[]{0x0000000001818002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1523 = new BitSet(new long[]{0x0000000084000002L});
    public static final BitSet FOLLOW_set_in_additiveExpression1541 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1551 = new BitSet(new long[]{0x0000000084000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1601 = new BitSet(new long[]{0x0000014000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression1619 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1633 = new BitSet(new long[]{0x0000014000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_set_in_unaryExpression1695 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpression_in_postfixExpression1772 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_ARROW_in_postfixExpression1790 = new BitSet(new long[]{0x0000000000080000L,0x0000060741000000L});
    public static final BitSet FOLLOW_DOT_in_postfixExpression1796 = new BitSet(new long[]{0x0000000000080000L,0x0000060741000000L});
    public static final BitSet FOLLOW_propertyCall_in_postfixExpression1807 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_literal_in_primaryExpression1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectReference_in_primaryExpression1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyCall_in_primaryExpression1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression1884 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_primaryExpression1888 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression1890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifExpression_in_primaryExpression1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primaryExpression1914 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_DOT_in_primaryExpression1916 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_primaryExpression1918 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_AT_in_primaryExpression1941 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_primaryExpression1943 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression1961 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primaryExpression1976 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_DOT_in_primaryExpression1978 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_primaryExpression1980 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression1984 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_primaryExpression1988 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression1990 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AT_in_primaryExpression2010 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_primaryExpression2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_objectReference2038 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_objectReference2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_queryExpression_in_propertyCall2111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iterateExpression_in_propertyCall2124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationExpression_in_propertyCall2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeExpression_in_propertyCall2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inStateExpression_in_propertyCall2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_queryExpression2198 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_queryExpression2205 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_elemVarsDeclaration_in_queryExpression2216 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_BAR_in_queryExpression2220 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_queryExpression2231 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_queryExpression2239 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_queryExpression2243 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_queryExpression2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_iterateExpression2286 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_iterateExpression2292 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_elemVarsDeclaration_in_iterateExpression2300 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMI_in_iterateExpression2302 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableInitialization_in_iterateExpression2310 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_BAR_in_iterateExpression2312 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_iterateExpression2320 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_iterateExpression2326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_operationExpression2370 = new BitSet(new long[]{0x0000000002400022L});
    public static final BitSet FOLLOW_LBRACK_in_operationExpression2392 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_operationExpression2405 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_COMMA_in_operationExpression2418 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_operationExpression2422 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_RBRACK_in_operationExpression2434 = new BitSet(new long[]{0x0000000002400022L});
    public static final BitSet FOLLOW_LBRACK_in_operationExpression2451 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_operationExpression2466 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_COMMA_in_operationExpression2481 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_operationExpression2485 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_RBRACK_in_operationExpression2499 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_AT_in_operationExpression2524 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_operationExpression2526 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_operationExpression2551 = new BitSet(new long[]{0x01FFE318861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_operationExpression2572 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_operationExpression2584 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_operationExpression2588 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_RPAREN_in_operationExpression2608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_inStateExpression2645 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_inStateExpression2650 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_inStateExpression2659 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_inStateExpression2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeExpression2700 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_typeExpression2724 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_typeExpression2728 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_typeExpression2730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_elemVarsDeclaration2768 = new BitSet(new long[]{0x0000000000000482L});
    public static final BitSet FOLLOW_COLON_in_elemVarsDeclaration2771 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_elemVarsDeclaration2775 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_elemVarsDeclaration2785 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_elemVarsDeclaration2791 = new BitSet(new long[]{0x0000000000000482L});
    public static final BitSet FOLLOW_COLON_in_elemVarsDeclaration2794 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_elemVarsDeclaration2800 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_IDENT_in_variableInitialization2828 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_variableInitialization2830 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_variableInitialization2834 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_variableInitialization2836 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_variableInitialization2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ifExpression2872 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_ifExpression2876 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_ifExpression2878 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_ifExpression2882 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ifExpression2884 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_ifExpression2888 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_ifExpression2890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_literal2929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_literal2943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_literal2956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_literal2971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_literal2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_literal2995 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal2997 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3001 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3003 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3007 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal3009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_literal3019 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal3021 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3025 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3027 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3031 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal3033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_literal3043 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal3045 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_conditionalImpliesExpression_in_literal3049 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3051 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3055 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal3057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_literal3067 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal3069 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3073 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3075 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3079 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_literal3091 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal3093 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3097 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3099 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3103 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3105 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3109 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3111 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF1012000L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3115 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HASH_in_literal3134 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_literal3138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_literal3150 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_COLON_in_literal3152 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_literal3156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionLiteral_in_literal3168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emptyCollectionLiteral_in_literal3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_undefinedLiteral_in_literal3192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleLiteral_in_literal3204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_literal3216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionLiteral3254 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LBRACE_in_collectionLiteral3283 = new BitSet(new long[]{0x01FFE30A861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_collectionItem_in_collectionLiteral3300 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_COMMA_in_collectionLiteral3313 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_collectionItem_in_collectionLiteral3317 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_RBRACE_in_collectionLiteral3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_collectionItem3365 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_DOTDOT_in_collectionItem3376 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_collectionItem3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_emptyCollectionLiteral3409 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_emptyCollectionLiteral3411 = new BitSet(new long[]{0x0006E00000000000L});
    public static final BitSet FOLLOW_collectionType_in_emptyCollectionLiteral3415 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_emptyCollectionLiteral3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_emptyCollectionLiteral3433 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LBRACE_in_emptyCollectionLiteral3435 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_emptyCollectionLiteral3437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_undefinedLiteral3467 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_undefinedLiteral3469 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_undefinedLiteral3473 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_undefinedLiteral3475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_undefinedLiteral3489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_undefinedLiteral3503 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_undefinedLiteral3505 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_undefinedLiteral3509 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_undefinedLiteral3511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_undefinedLiteral3525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_tupleLiteral3564 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LBRACE_in_tupleLiteral3570 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tupleItem_in_tupleLiteral3578 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_COMMA_in_tupleLiteral3589 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tupleItem_in_tupleLiteral3593 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_RBRACE_in_tupleLiteral3604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_tupleItem3635 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_COLON_in_tupleItem3674 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_tupleItem3678 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_tupleItem3680 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_tupleItem3684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tupleItem3706 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_tupleItem3716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleType_in_type3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_type3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleType_in_type3806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_uncertaintyType_in_type3818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_uncertaintyType3849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeOnly3887 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_typeOnly3889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_simpleType3917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType3955 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_collectionType3982 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_collectionType3986 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_collectionType3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_tupleType4022 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_tupleType4024 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tuplePart_in_tupleType4033 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_tupleType4044 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tuplePart_in_tupleType4048 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tupleType4060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_tuplePart4092 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_tuplePart4094 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_tuplePart4098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_shellCommandOnly4135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyStat_in_shellCommandOnly4156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyStat_in_shellCommand4188 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_shellCommand4190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_shellCommand4211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_shellCommand4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyOpEnter_in_legacyStat4247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyOpExit_in_legacyStat4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nextLegacyStat_in_legacyStat4276 = new BitSet(new long[]{0x1000000000000002L,0x000008000208101AL});
    public static final BitSet FOLLOW_nextLegacyStat_in_legacyStat4287 = new BitSet(new long[]{0x1000000000000002L,0x000008000208101AL});
    public static final BitSet FOLLOW_singleLegacyStat_in_nextLegacyStat4321 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_SEMI_in_nextLegacyStat4325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyCreate_in_singleLegacyStat4358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyCreateAssign_in_singleLegacyStat4377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyCreateInsert_in_singleLegacyStat4390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyLet_in_singleLegacyStat4403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyExecute_in_singleLegacyStat4431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objDestroyStat_in_singleLegacyStat4449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_singleLegacyStat4462 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_singleLegacyStat4466 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_attAssignStat_in_singleLegacyStat4472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lnkInsStat_in_singleLegacyStat4485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lnkDelStat_in_singleLegacyStat4506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_legacyCreate4542 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_identListMin1_in_legacyCreate4550 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_legacyCreate4554 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_simpleType_in_legacyCreate4562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_legacyCreateAssign4599 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_identListMin1_in_legacyCreateAssign4607 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_EQUAL_in_legacyCreateAssign4611 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_legacyCreateAssign4615 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_simpleType_in_legacyCreateAssign4623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_legacyCreateInsert4657 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_legacyCreateInsert4665 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_legacyCreateInsert4669 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_simpleType_in_legacyCreateInsert4677 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_legacyCreateInsert4681 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_legacyCreateInsert4685 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValListMin2WithOptionalQualifiers_in_legacyCreateInsert4695 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_legacyCreateInsert4699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_legacyLet4732 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_legacyLet4740 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_COLON_in_legacyLet4750 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_legacyLet4760 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_legacyLet4769 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_inSoilExpression_in_legacyLet4777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_legacyOpEnter4810 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_inSoilExpression_in_legacyOpEnter4818 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_legacyOpEnter4826 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_legacyOpEnter4830 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_exprList_in_legacyOpEnter4840 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_legacyOpEnter4844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_legacyOpExit4879 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_inSoilExpression_in_legacyOpExit4891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nothing_in_legacyOpExit4895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_legacyExecute4928 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_expression_in_legacyExecute4932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_statOnly4978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_statOnly4982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleStat_in_stat5017 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_SEMI_in_stat5029 = new BitSet(new long[]{0x21FFE308861A0020L,0x0005060FFB096018L});
    public static final BitSet FOLLOW_singleStat_in_stat5039 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_emptyStat_in_singleStat5079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statStartingWithExpr_in_singleStat5105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varAssignStat_in_singleStat5117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCreateStat_in_singleStat5131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objDestroyStat_in_singleStat5145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lnkInsStat_in_singleStat5158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lnkDelStat_in_singleStat5175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condExStat_in_singleStat5192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iterStat_in_singleStat5209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStat_in_singleStat5231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStat_in_singleStat5249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nothing_in_emptyStat5276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inSoilExpression_in_statStartingWithExpr5302 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_attAssignStat_in_statStartingWithExpr5316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_varAssignStat5354 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_EQUAL_in_varAssignStat5358 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValue_in_varAssignStat5366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_attAssignStat5390 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_attAssignStat5399 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_EQUAL_in_attAssignStat5403 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValue_in_attAssignStat5411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_objCreateStat5437 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_simpleType_in_objCreateStat5445 = new BitSet(new long[]{0x8000000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_objCreateStat5455 = new BitSet(new long[]{0x01FFE318861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_inSoilExpression_in_objCreateStat5468 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_objCreateStat5476 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_objCreateStat5494 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_objCreateStat5502 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValListMin2WithOptionalQualifiers_in_objCreateStat5516 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_objCreateStat5524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_objDestroyStat5560 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_exprListMin1_in_objDestroyStat5568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_lnkInsStat5594 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_lnkInsStat5598 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkInsStat5608 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_lnkInsStat5612 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_lnkInsStat5616 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_lnkInsStat5624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5653 = new BitSet(new long[]{0x0000000000200400L});
    public static final BitSet FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5664 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5673 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5680 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers5696 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5707 = new BitSet(new long[]{0x0000000000200402L});
    public static final BitSet FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5718 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5727 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5734 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers5756 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5771 = new BitSet(new long[]{0x0000000000200402L});
    public static final BitSet FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5791 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5802 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5811 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_67_in_lnkDelStat5852 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_lnkDelStat5856 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkDelStat5866 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_lnkDelStat5870 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_lnkDelStat5874 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_lnkDelStat5883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_condExStat5914 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_inSoilExpression_in_condExStat5923 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_condExStat5927 = new BitSet(new long[]{0x21FFE308861A0020L,0x0005060FFB09601CL});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_condExStat5936 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_71_in_condExStat5947 = new BitSet(new long[]{0x21FFE308861A0020L,0x0005060FFB09601CL});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_condExStat5959 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_condExStat5971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_iterStat5996 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_iterStat6004 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_iterStat6008 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_inSoilExpression_in_iterStat6016 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_iterStat6020 = new BitSet(new long[]{0x21FFE308861A0020L,0x0005060FFB09601CL});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_iterStat6028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_iterStat6033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_whileStat6059 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_inSoilExpression_in_whileStat6067 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_whileStat6071 = new BitSet(new long[]{0x21FFE308861A0020L,0x0005060FFB09601CL});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_whileStat6079 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_whileStat6084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_blockStat6114 = new BitSet(new long[]{0x21FFE308861A0020L,0x0005060FFB09601CL});
    public static final BitSet FOLLOW_66_in_blockStat6119 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_blockStat6125 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_COMMA_in_blockStat6131 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_blockStat6137 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_SEMI_in_blockStat6144 = new BitSet(new long[]{0x21FFE308861A0020L,0x0005060FFB096018L});
    public static final BitSet FOLLOW_stat_in_blockStat6154 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_blockStat6159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_implicitBlockStat6185 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_implicitBlockStat6191 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_COMMA_in_implicitBlockStat6197 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_implicitBlockStat6203 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_SEMI_in_implicitBlockStat6210 = new BitSet(new long[]{0x21FFE308861A0020L,0x0005060FFB096018L});
    public static final BitSet FOLLOW_stat_in_implicitBlockStat6218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_statOrImplicitBlock6241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicitBlockStat_in_statOrImplicitBlock6251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inSoilExpression_in_rValue6297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCreateStat_in_rValue6309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nothing_in_rValList6332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rValListMin1_in_rValList6359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rValue_in_rValListMin16392 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin16406 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValue_in_rValListMin16416 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rValue_in_rValListMin26455 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin26463 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValue_in_rValListMin26471 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin26485 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FFB012000L});
    public static final BitSet FOLLOW_rValue_in_rValListMin26495 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_expression_in_inSoilExpression6529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nothing_in_exprList6558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exprListMin1_in_exprList6576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin16609 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_exprListMin16624 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin16634 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin26674 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_exprListMin26682 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin26690 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_exprListMin26704 = new BitSet(new long[]{0x01FFE308861A0020L,0x0001060FF3012000L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin26714 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_nothing_in_identList6744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identListMin1_in_identList6761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_identListMin16795 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_identListMin16809 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_identListMin16819 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COLON_in_synpred1_TestSuite3665 = new BitSet(new long[]{0x00FFE00000080000L});
    public static final BitSet FOLLOW_type_in_synpred1_TestSuite3667 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_synpred1_TestSuite3669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_synpred2_TestSuite4127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyStat_in_synpred3_TestSuite4148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyStat_in_synpred4_TestSuite4180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_synpred5_TestSuite4203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inSoilExpression_in_synpred6_TestSuite4883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statStartingWithExpr_in_synpred7_TestSuite5097 = new BitSet(new long[]{0x0000000000000002L});

}