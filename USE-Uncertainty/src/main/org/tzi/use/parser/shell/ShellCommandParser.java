// $ANTLR 3.4 ShellCommand.g 2020-10-07 09:32:02

/*
 * USE - UML based specification environment
 * Copyright (C) 1999-2010 University of Bremen
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
 
 
package org.tzi.use.parser.shell;

import org.tzi.use.parser.base.BaseParser;
import org.tzi.use.parser.ocl.*;
import org.tzi.use.parser.soil.ast.*;
import java.util.Collections;
import java.util.Arrays;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ShellCommandParser extends BaseParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARROW", "AT", "BAR", "COLON", "COLON_COLON", "COLON_EQUAL", "COMMA", "DOT", "DOTDOT", "EQUAL", "ESC", "GREATER", "GREATER_EQUAL", "HASH", "HEX_DIGIT", "IDENT", "INT", "LBRACE", "LBRACK", "LESS", "LESS_EQUAL", "LPAREN", "MINUS", "ML_COMMENT", "NEWLINE", "NON_OCL_STRING", "NOT_EQUAL", "PLUS", "RANGE_OR_INT", "RBRACE", "RBRACK", "REAL", "RPAREN", "SEMI", "SLASH", "SL_COMMENT", "STAR", "STRING", "VOCAB", "WS", "'Bag'", "'Collection'", "'OrderedSet'", "'SBoolean'", "'Sequence'", "'Set'", "'Tuple'", "'UBoolean'", "'UInteger'", "'UReal'", "'UString'", "'Undefined'", "'allInstances'", "'and'", "'assign'", "'begin'", "'between'", "'byUseId'", "'create'", "'declare'", "'delete'", "'destroy'", "'div'", "'do'", "'else'", "'end'", "'endif'", "'equals'", "'execute'", "'false'", "'for'", "'from'", "'if'", "'implies'", "'in'", "'insert'", "'into'", "'iterate'", "'let'", "'new'", "'not'", "'null'", "'oclAsType'", "'oclEmpty'", "'oclInState'", "'oclIsKindOf'", "'oclIsTypeOf'", "'oclUndefined'", "'openter'", "'opexit'", "'or'", "'pre'", "'selectByKind'", "'selectByType'", "'set'", "'then'", "'true'", "'while'", "'xor'"
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


    public ShellCommandParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public ShellCommandParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return ShellCommandParser.tokenNames; }
    public String getGrammarFileName() { return "ShellCommand.g"; }



    // $ANTLR start "shellCommandOnly"
    // ShellCommand.g:85:1: shellCommandOnly returns [ASTStatement n] : ( ( stat )=>s= stat | ( legacyStat )=>l= legacyStat );
    public final ASTStatement shellCommandOnly() throws RecognitionException {
        ASTStatement n = null;


        ShellCommandParser.stat_return s =null;

        ShellCommandParser.legacyStat_return l =null;


        try {
            // ShellCommand.g:86:3: ( ( stat )=>s= stat | ( legacyStat )=>l= legacyStat )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==SEMI) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==EOF) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==82) ) {
                int LA1_3 = input.LA(2);

                if ( (synpred1_ShellCommand()) ) {
                    alt1=1;
                }
                else if ( (synpred2_ShellCommand()) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;

                }
            }
            else if ( (LA1_0==MINUS||LA1_0==PLUS||LA1_0==84) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==100) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==73) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==INT) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==REAL) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==STRING) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==54) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==53) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==51) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==52) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==47) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==HASH) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==IDENT) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==44||LA1_0==46||(LA1_0 >= 48 && LA1_0 <= 49)) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==87) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==45) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==91) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==55) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==85) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==50) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==STAR) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==AT) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==81) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==86||(LA1_0 >= 89 && LA1_0 <= 90)||(LA1_0 >= 96 && LA1_0 <= 97)) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==88) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==LPAREN) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==76) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==83) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==65) ) {
                int LA1_32 = input.LA(2);

                if ( (synpred1_ShellCommand()) ) {
                    alt1=1;
                }
                else if ( (synpred2_ShellCommand()) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 32, input);

                    throw nvae;

                }
            }
            else if ( (LA1_0==79) ) {
                int LA1_33 = input.LA(2);

                if ( (synpred1_ShellCommand()) ) {
                    alt1=1;
                }
                else if ( (synpred2_ShellCommand()) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 33, input);

                    throw nvae;

                }
            }
            else if ( (LA1_0==64) ) {
                int LA1_34 = input.LA(2);

                if ( (synpred1_ShellCommand()) ) {
                    alt1=1;
                }
                else if ( (synpred2_ShellCommand()) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 34, input);

                    throw nvae;

                }
            }
            else if ( (LA1_0==74) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==101) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==59) && (synpred1_ShellCommand())) {
                alt1=1;
            }
            else if ( (LA1_0==92) && (synpred2_ShellCommand())) {
                alt1=2;
            }
            else if ( (LA1_0==93) && (synpred2_ShellCommand())) {
                alt1=2;
            }
            else if ( (LA1_0==62) && (synpred2_ShellCommand())) {
                alt1=2;
            }
            else if ( (LA1_0==58) && (synpred2_ShellCommand())) {
                alt1=2;
            }
            else if ( (LA1_0==72) && (synpred2_ShellCommand())) {
                alt1=2;
            }
            else if ( (LA1_0==98) && (synpred2_ShellCommand())) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // ShellCommand.g:87:3: ( stat )=>s= stat
                    {
                    pushFollow(FOLLOW_stat_in_shellCommandOnly65);
                    s=stat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (s!=null?s.n:null); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:90:3: ( legacyStat )=>l= legacyStat
                    {
                    pushFollow(FOLLOW_legacyStat_in_shellCommandOnly86);
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
    // ShellCommand.g:98:1: shellCommand returns [ASTStatement n] : ( ( legacyStat )=>l= legacyStat EOF | ( stat )=>s= stat EOF );
    public final ASTStatement shellCommand() throws RecognitionException {
        ASTStatement n = null;


        ShellCommandParser.legacyStat_return l =null;

        ShellCommandParser.stat_return s =null;


        try {
            // ShellCommand.g:99:3: ( ( legacyStat )=>l= legacyStat EOF | ( stat )=>s= stat EOF )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==92) && (synpred3_ShellCommand())) {
                alt2=1;
            }
            else if ( (LA2_0==93) && (synpred3_ShellCommand())) {
                alt2=1;
            }
            else if ( (LA2_0==62) && (synpred3_ShellCommand())) {
                alt2=1;
            }
            else if ( (LA2_0==58) && (synpred3_ShellCommand())) {
                alt2=1;
            }
            else if ( (LA2_0==82) ) {
                int LA2_5 = input.LA(2);

                if ( (synpred3_ShellCommand()) ) {
                    alt2=1;
                }
                else if ( (synpred4_ShellCommand()) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 5, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==72) && (synpred3_ShellCommand())) {
                alt2=1;
            }
            else if ( (LA2_0==65) ) {
                int LA2_7 = input.LA(2);

                if ( (synpred3_ShellCommand()) ) {
                    alt2=1;
                }
                else if ( (synpred4_ShellCommand()) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 7, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==98) && (synpred3_ShellCommand())) {
                alt2=1;
            }
            else if ( (LA2_0==79) ) {
                int LA2_9 = input.LA(2);

                if ( (synpred3_ShellCommand()) ) {
                    alt2=1;
                }
                else if ( (synpred4_ShellCommand()) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 9, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==64) ) {
                int LA2_10 = input.LA(2);

                if ( (synpred3_ShellCommand()) ) {
                    alt2=1;
                }
                else if ( (synpred4_ShellCommand()) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 10, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==SEMI) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==EOF) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==MINUS||LA2_0==PLUS||LA2_0==84) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==100) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==73) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==INT) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==REAL) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==STRING) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==54) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==53) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==51) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==52) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==47) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==HASH) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==IDENT) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==44||LA2_0==46||(LA2_0 >= 48 && LA2_0 <= 49)) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==87) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==45) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==91) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==55) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==85) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==50) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==STAR) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==AT) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==81) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==86||(LA2_0 >= 89 && LA2_0 <= 90)||(LA2_0 >= 96 && LA2_0 <= 97)) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==88) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==LPAREN) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==76) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==83) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==74) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==101) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else if ( (LA2_0==59) && (synpred4_ShellCommand())) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // ShellCommand.g:100:3: ( legacyStat )=>l= legacyStat EOF
                    {
                    pushFollow(FOLLOW_legacyStat_in_shellCommand118);
                    l=legacyStat();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,EOF,FOLLOW_EOF_in_shellCommand120); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (l!=null?l.n:null); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:103:3: ( stat )=>s= stat EOF
                    {
                    pushFollow(FOLLOW_stat_in_shellCommand141);
                    s=stat();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,EOF,FOLLOW_EOF_in_shellCommand143); if (state.failed) return n;

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
    // ShellCommand.g:113:1: legacyStat returns [ASTStatement n] : (loe= legacyOpEnter |lox= legacyOpExit | nextLegacyStat[seq] ( nextLegacyStat[seq] )* );
    public final ShellCommandParser.legacyStat_return legacyStat() throws RecognitionException {
        ShellCommandParser.legacyStat_return retval = new ShellCommandParser.legacyStat_return();
        retval.start = input.LT(1);


        ShellCommandParser.legacyOpEnter_return loe =null;

        ShellCommandParser.legacyOpExit_return lox =null;



          ASTSequenceStatement seq = new ASTSequenceStatement(((Token)retval.start));

        try {
            // ShellCommand.g:117:3: (loe= legacyOpEnter |lox= legacyOpExit | nextLegacyStat[seq] ( nextLegacyStat[seq] )* )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt4=1;
                }
                break;
            case 93:
                {
                alt4=2;
                }
                break;
            case 58:
            case 62:
            case 64:
            case 65:
            case 72:
            case 79:
            case 82:
            case 98:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // ShellCommand.g:118:3: loe= legacyOpEnter
                    {
                    pushFollow(FOLLOW_legacyOpEnter_in_legacyStat177);
                    loe=legacyOpEnter();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { 
                        retval.n = (loe!=null?loe.n:null);
                      }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:123:3: lox= legacyOpExit
                    {
                    pushFollow(FOLLOW_legacyOpExit_in_legacyStat193);
                    lox=legacyOpExit();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { 
                        retval.n = (lox!=null?lox.n:null); 
                      }

                    }
                    break;
                case 3 :
                    // ShellCommand.g:128:3: nextLegacyStat[seq] ( nextLegacyStat[seq] )*
                    {
                    pushFollow(FOLLOW_nextLegacyStat_in_legacyStat206);
                    nextLegacyStat(seq);

                    state._fsp--;
                    if (state.failed) return retval;

                    // ShellCommand.g:129:3: ( nextLegacyStat[seq] )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==58||LA3_0==62||(LA3_0 >= 64 && LA3_0 <= 65)||LA3_0==72||LA3_0==79||LA3_0==82||LA3_0==98) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ShellCommand.g:130:5: nextLegacyStat[seq]
                    	    {
                    	    pushFollow(FOLLOW_nextLegacyStat_in_legacyStat217);
                    	    nextLegacyStat(seq);

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
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
    // ShellCommand.g:142:1: nextLegacyStat[ASTSequenceStatement seq] : s= singleLegacyStat ( SEMI )? ;
    public final void nextLegacyStat(ASTSequenceStatement seq) throws RecognitionException {
        ASTStatement s =null;


        try {
            // ShellCommand.g:143:3: (s= singleLegacyStat ( SEMI )? )
            // ShellCommand.g:144:3: s= singleLegacyStat ( SEMI )?
            {
            pushFollow(FOLLOW_singleLegacyStat_in_nextLegacyStat251);
            s=singleLegacyStat();

            state._fsp--;
            if (state.failed) return ;

            // ShellCommand.g:145:3: ( SEMI )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==SEMI) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ShellCommand.g:145:3: SEMI
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_nextLegacyStat255); if (state.failed) return ;

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
    // ShellCommand.g:156:1: singleLegacyStat returns [ASTStatement n] : (lcr= legacyCreate |lca= legacyCreateAssign |lci= legacyCreateInsert |llt= legacyLet |lex= legacyExecute |ods= objDestroyStat | 'set' e= expression aas= attAssignStat[$e.n] |lis= lnkInsStat |lds= lnkDelStat );
    public final ASTStatement singleLegacyStat() throws RecognitionException {
        ASTStatement n = null;


        ShellCommandParser.legacyCreate_return lcr =null;

        ShellCommandParser.legacyCreateAssign_return lca =null;

        ShellCommandParser.legacyCreateInsert_return lci =null;

        ShellCommandParser.legacyLet_return llt =null;

        ASTStatement lex =null;

        ShellCommandParser.objDestroyStat_return ods =null;

        ShellCommandParser.expression_return e =null;

        ASTAttributeAssignmentStatement aas =null;

        ShellCommandParser.lnkInsStat_return lis =null;

        ShellCommandParser.lnkDelStat_return lds =null;


        try {
            // ShellCommand.g:157:5: (lcr= legacyCreate |lca= legacyCreateAssign |lci= legacyCreateInsert |llt= legacyLet |lex= legacyExecute |ods= objDestroyStat | 'set' e= expression aas= attAssignStat[$e.n] |lis= lnkInsStat |lds= lnkDelStat )
            int alt6=9;
            switch ( input.LA(1) ) {
            case 62:
                {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==IDENT) ) {
                    int LA6_9 = input.LA(3);

                    if ( (LA6_9==COLON) ) {
                        int LA6_10 = input.LA(4);

                        if ( (LA6_10==IDENT) ) {
                            int LA6_12 = input.LA(5);

                            if ( (LA6_12==60) ) {
                                alt6=3;
                            }
                            else if ( (LA6_12==EOF||LA6_12==SEMI||LA6_12==58||LA6_12==62||(LA6_12 >= 64 && LA6_12 <= 65)||LA6_12==72||LA6_12==79||LA6_12==82||LA6_12==98) ) {
                                alt6=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return n;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 12, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return n;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 10, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA6_9==COMMA) ) {
                        alt6=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 9, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;

                }
                }
                break;
            case 58:
                {
                alt6=2;
                }
                break;
            case 82:
                {
                alt6=4;
                }
                break;
            case 72:
                {
                alt6=5;
                }
                break;
            case 65:
                {
                alt6=6;
                }
                break;
            case 98:
                {
                alt6=7;
                }
                break;
            case 79:
                {
                alt6=8;
                }
                break;
            case 64:
                {
                alt6=9;
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
                    // ShellCommand.g:158:5: lcr= legacyCreate
                    {
                    pushFollow(FOLLOW_legacyCreate_in_singleLegacyStat288);
                    lcr=legacyCreate();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lcr!=null?lcr.n:null); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:159:5: lca= legacyCreateAssign
                    {
                    pushFollow(FOLLOW_legacyCreateAssign_in_singleLegacyStat307);
                    lca=legacyCreateAssign();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lca!=null?lca.n:null); }

                    }
                    break;
                case 3 :
                    // ShellCommand.g:160:5: lci= legacyCreateInsert
                    {
                    pushFollow(FOLLOW_legacyCreateInsert_in_singleLegacyStat320);
                    lci=legacyCreateInsert();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lci!=null?lci.n:null); }

                    }
                    break;
                case 4 :
                    // ShellCommand.g:161:5: llt= legacyLet
                    {
                    pushFollow(FOLLOW_legacyLet_in_singleLegacyStat333);
                    llt=legacyLet();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (llt!=null?llt.n:null); }

                    }
                    break;
                case 5 :
                    // ShellCommand.g:164:5: lex= legacyExecute
                    {
                    pushFollow(FOLLOW_legacyExecute_in_singleLegacyStat361);
                    lex=legacyExecute();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = lex; }

                    }
                    break;
                case 6 :
                    // ShellCommand.g:165:5: ods= objDestroyStat
                    {
                    pushFollow(FOLLOW_objDestroyStat_in_singleLegacyStat379);
                    ods=objDestroyStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (ods!=null?ods.n:null); }

                    }
                    break;
                case 7 :
                    // ShellCommand.g:166:5: 'set' e= expression aas= attAssignStat[$e.n]
                    {
                    match(input,98,FOLLOW_98_in_singleLegacyStat392); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_singleLegacyStat396);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    pushFollow(FOLLOW_attAssignStat_in_singleLegacyStat402);
                    aas=attAssignStat((e!=null?e.n:null));

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = aas; }

                    }
                    break;
                case 8 :
                    // ShellCommand.g:167:5: lis= lnkInsStat
                    {
                    pushFollow(FOLLOW_lnkInsStat_in_singleLegacyStat415);
                    lis=lnkInsStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lis!=null?lis.n:null); }

                    }
                    break;
                case 9 :
                    // ShellCommand.g:168:5: lds= lnkDelStat
                    {
                    pushFollow(FOLLOW_lnkDelStat_in_singleLegacyStat436);
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
    // ShellCommand.g:181:1: legacyCreate returns [ASTStatement n] : 'create' objNames= identListMin1 COLON objType= simpleType ;
    public final ShellCommandParser.legacyCreate_return legacyCreate() throws RecognitionException {
        ShellCommandParser.legacyCreate_return retval = new ShellCommandParser.legacyCreate_return();
        retval.start = input.LT(1);


        List<String> objNames =null;

        ASTSimpleType objType =null;


        try {
            // ShellCommand.g:182:3: ( 'create' objNames= identListMin1 COLON objType= simpleType )
            // ShellCommand.g:183:3: 'create' objNames= identListMin1 COLON objType= simpleType
            {
            match(input,62,FOLLOW_62_in_legacyCreate472); if (state.failed) return retval;

            pushFollow(FOLLOW_identListMin1_in_legacyCreate480);
            objNames=identListMin1();

            state._fsp--;
            if (state.failed) return retval;

            match(input,COLON,FOLLOW_COLON_in_legacyCreate484); if (state.failed) return retval;

            pushFollow(FOLLOW_simpleType_in_legacyCreate492);
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
    // ShellCommand.g:214:1: legacyCreateAssign returns [ASTStatement n] : 'assign' varNames= identListMin1 COLON_EQUAL 'create' objType= simpleType ;
    public final ShellCommandParser.legacyCreateAssign_return legacyCreateAssign() throws RecognitionException {
        ShellCommandParser.legacyCreateAssign_return retval = new ShellCommandParser.legacyCreateAssign_return();
        retval.start = input.LT(1);


        List<String> varNames =null;

        ASTSimpleType objType =null;


        try {
            // ShellCommand.g:215:3: ( 'assign' varNames= identListMin1 COLON_EQUAL 'create' objType= simpleType )
            // ShellCommand.g:216:3: 'assign' varNames= identListMin1 COLON_EQUAL 'create' objType= simpleType
            {
            match(input,58,FOLLOW_58_in_legacyCreateAssign529); if (state.failed) return retval;

            pushFollow(FOLLOW_identListMin1_in_legacyCreateAssign537);
            varNames=identListMin1();

            state._fsp--;
            if (state.failed) return retval;

            match(input,COLON_EQUAL,FOLLOW_COLON_EQUAL_in_legacyCreateAssign541); if (state.failed) return retval;

            match(input,62,FOLLOW_62_in_legacyCreateAssign545); if (state.failed) return retval;

            pushFollow(FOLLOW_simpleType_in_legacyCreateAssign553);
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
    // ShellCommand.g:249:1: legacyCreateInsert returns [ASTVariableAssignmentStatement n] : 'create' name= IDENT COLON asClassName= simpleType 'between' LPAREN participants= rValListMin2WithOptionalQualifiers RPAREN ;
    public final ShellCommandParser.legacyCreateInsert_return legacyCreateInsert() throws RecognitionException {
        ShellCommandParser.legacyCreateInsert_return retval = new ShellCommandParser.legacyCreateInsert_return();
        retval.start = input.LT(1);


        Token name=null;
        ASTSimpleType asClassName =null;

        ShellCommandParser.rValListMin2WithOptionalQualifiers_return participants =null;


        try {
            // ShellCommand.g:250:3: ( 'create' name= IDENT COLON asClassName= simpleType 'between' LPAREN participants= rValListMin2WithOptionalQualifiers RPAREN )
            // ShellCommand.g:251:3: 'create' name= IDENT COLON asClassName= simpleType 'between' LPAREN participants= rValListMin2WithOptionalQualifiers RPAREN
            {
            match(input,62,FOLLOW_62_in_legacyCreateInsert587); if (state.failed) return retval;

            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_legacyCreateInsert595); if (state.failed) return retval;

            match(input,COLON,FOLLOW_COLON_in_legacyCreateInsert599); if (state.failed) return retval;

            pushFollow(FOLLOW_simpleType_in_legacyCreateInsert607);
            asClassName=simpleType();

            state._fsp--;
            if (state.failed) return retval;

            match(input,60,FOLLOW_60_in_legacyCreateInsert611); if (state.failed) return retval;

            match(input,LPAREN,FOLLOW_LPAREN_in_legacyCreateInsert615); if (state.failed) return retval;

            pushFollow(FOLLOW_rValListMin2WithOptionalQualifiers_in_legacyCreateInsert625);
            participants=rValListMin2WithOptionalQualifiers();

            state._fsp--;
            if (state.failed) return retval;

            match(input,RPAREN,FOLLOW_RPAREN_in_legacyCreateInsert629); if (state.failed) return retval;

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
    // ShellCommand.g:286:1: legacyLet returns [ASTVariableAssignmentStatement n] : 'let' varName= IDENT ( COLON varType= type )? EQUAL e= inSoilExpression ;
    public final ShellCommandParser.legacyLet_return legacyLet() throws RecognitionException {
        ShellCommandParser.legacyLet_return retval = new ShellCommandParser.legacyLet_return();
        retval.start = input.LT(1);


        Token varName=null;
        ASTType varType =null;

        ASTExpression e =null;


        try {
            // ShellCommand.g:287:3: ( 'let' varName= IDENT ( COLON varType= type )? EQUAL e= inSoilExpression )
            // ShellCommand.g:288:3: 'let' varName= IDENT ( COLON varType= type )? EQUAL e= inSoilExpression
            {
            match(input,82,FOLLOW_82_in_legacyLet662); if (state.failed) return retval;

            varName=(Token)match(input,IDENT,FOLLOW_IDENT_in_legacyLet670); if (state.failed) return retval;

            // ShellCommand.g:290:3: ( COLON varType= type )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==COLON) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ShellCommand.g:291:5: COLON varType= type
                    {
                    match(input,COLON,FOLLOW_COLON_in_legacyLet680); if (state.failed) return retval;

                    pushFollow(FOLLOW_type_in_legacyLet690);
                    varType=type();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }


            match(input,EQUAL,FOLLOW_EQUAL_in_legacyLet699); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_legacyLet707);
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
    // ShellCommand.g:312:1: legacyOpEnter returns [ASTEnterOperationStatement n] : 'openter' obj= inSoilExpression op= IDENT LPAREN args= exprList RPAREN ;
    public final ShellCommandParser.legacyOpEnter_return legacyOpEnter() throws RecognitionException {
        ShellCommandParser.legacyOpEnter_return retval = new ShellCommandParser.legacyOpEnter_return();
        retval.start = input.LT(1);


        Token op=null;
        ASTExpression obj =null;

        List<ASTExpression> args =null;


        try {
            // ShellCommand.g:313:3: ( 'openter' obj= inSoilExpression op= IDENT LPAREN args= exprList RPAREN )
            // ShellCommand.g:314:3: 'openter' obj= inSoilExpression op= IDENT LPAREN args= exprList RPAREN
            {
            match(input,92,FOLLOW_92_in_legacyOpEnter740); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_legacyOpEnter748);
            obj=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            op=(Token)match(input,IDENT,FOLLOW_IDENT_in_legacyOpEnter756); if (state.failed) return retval;

            match(input,LPAREN,FOLLOW_LPAREN_in_legacyOpEnter760); if (state.failed) return retval;

            pushFollow(FOLLOW_exprList_in_legacyOpEnter770);
            args=exprList();

            state._fsp--;
            if (state.failed) return retval;

            match(input,RPAREN,FOLLOW_RPAREN_in_legacyOpEnter774); if (state.failed) return retval;

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
    // ShellCommand.g:337:1: legacyOpExit returns [ASTStatement n] : 'opexit' ( ( inSoilExpression )=>retVal= inSoilExpression | nothing ) ;
    public final ShellCommandParser.legacyOpExit_return legacyOpExit() throws RecognitionException {
        ShellCommandParser.legacyOpExit_return retval = new ShellCommandParser.legacyOpExit_return();
        retval.start = input.LT(1);


        ASTExpression retVal =null;


        try {
            // ShellCommand.g:338:3: ( 'opexit' ( ( inSoilExpression )=>retVal= inSoilExpression | nothing ) )
            // ShellCommand.g:339:3: 'opexit' ( ( inSoilExpression )=>retVal= inSoilExpression | nothing )
            {
            match(input,93,FOLLOW_93_in_legacyOpExit809); if (state.failed) return retval;

            // ShellCommand.g:339:12: ( ( inSoilExpression )=>retVal= inSoilExpression | nothing )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==82) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==MINUS||LA8_0==PLUS||LA8_0==84) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==100) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==73) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==INT) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==REAL) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==STRING) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==54) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==53) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==51) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==52) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==47) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==HASH) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==IDENT) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==44||LA8_0==46||(LA8_0 >= 48 && LA8_0 <= 49)) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==87) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==45) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==91) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==55) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==85) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==50) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==STAR) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==AT) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==81) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==86||(LA8_0 >= 89 && LA8_0 <= 90)||(LA8_0 >= 96 && LA8_0 <= 97)) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==88) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==LPAREN) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==76) && (synpred5_ShellCommand())) {
                alt8=1;
            }
            else if ( (LA8_0==EOF) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // ShellCommand.g:339:13: ( inSoilExpression )=>retVal= inSoilExpression
                    {
                    pushFollow(FOLLOW_inSoilExpression_in_legacyOpExit821);
                    retVal=inSoilExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // ShellCommand.g:339:62: nothing
                    {
                    pushFollow(FOLLOW_nothing_in_legacyOpExit825);
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
    // ShellCommand.g:354:1: legacyExecute returns [ASTStatement n] : 'execute' expression ;
    public final ASTStatement legacyExecute() throws RecognitionException {
        ASTStatement n = null;


        try {
            // ShellCommand.g:355:3: ( 'execute' expression )
            // ShellCommand.g:356:3: 'execute' expression
            {
            match(input,72,FOLLOW_72_in_legacyExecute858); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_legacyExecute862);
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



    // $ANTLR start "expressionOnly"
    // ShellCommand.g:392:1: expressionOnly returns [ASTExpression n] : nExp= expression EOF ;
    public final ASTExpression expressionOnly() throws RecognitionException {
        ASTExpression n = null;


        ShellCommandParser.expression_return nExp =null;


        try {
            // ShellCommand.g:393:5: (nExp= expression EOF )
            // ShellCommand.g:394:5: nExp= expression EOF
            {
            pushFollow(FOLLOW_expression_in_expressionOnly897);
            nExp=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,EOF,FOLLOW_EOF_in_expressionOnly899); if (state.failed) return n;

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
    // ShellCommand.g:401:1: expression returns [ASTExpression n] : ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )* nIdExp= identicalExpression ;
    public final ShellCommandParser.expression_return expression() throws RecognitionException {
        ShellCommandParser.expression_return retval = new ShellCommandParser.expression_return();
        retval.start = input.LT(1);


        Token name=null;
        ASTType t =null;

        ShellCommandParser.expression_return e1 =null;

        ASTExpression nIdExp =null;


         
          ASTLetExpression prevLet = null, firstLet = null;
          ASTExpression e2;
          Token tok = null;

        try {
            // ShellCommand.g:407:5: ( ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )* nIdExp= identicalExpression )
            // ShellCommand.g:408:5: ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )* nIdExp= identicalExpression
            {
            if ( state.backtracking==0 ) { tok = input.LT(1); /* remember start of expression */ }

            // ShellCommand.g:409:5: ( 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==82) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ShellCommand.g:410:7: 'let' name= IDENT ( COLON t= type )? EQUAL e1= expression ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )* 'in'
            	    {
            	    match(input,82,FOLLOW_82_in_expression947); if (state.failed) return retval;

            	    name=(Token)match(input,IDENT,FOLLOW_IDENT_in_expression958); if (state.failed) return retval;

            	    // ShellCommand.g:411:18: ( COLON t= type )?
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==COLON) ) {
            	        alt9=1;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // ShellCommand.g:411:20: COLON t= type
            	            {
            	            match(input,COLON,FOLLOW_COLON_in_expression962); if (state.failed) return retval;

            	            pushFollow(FOLLOW_type_in_expression966);
            	            t=type();

            	            state._fsp--;
            	            if (state.failed) return retval;

            	            }
            	            break;

            	    }


            	    match(input,EQUAL,FOLLOW_EQUAL_in_expression971); if (state.failed) return retval;

            	    pushFollow(FOLLOW_expression_in_expression975);
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

            	    // ShellCommand.g:421:7: ( COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression )*
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==COMMA) ) {
            	            alt11=1;
            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // ShellCommand.g:422:7: COMMA name= IDENT ( COLON t= type )? EQUAL e1= expression
            	    	    {
            	    	    match(input,COMMA,FOLLOW_COMMA_in_expression1013); if (state.failed) return retval;

            	    	    name=(Token)match(input,IDENT,FOLLOW_IDENT_in_expression1025); if (state.failed) return retval;

            	    	    // ShellCommand.g:423:20: ( COLON t= type )?
            	    	    int alt10=2;
            	    	    int LA10_0 = input.LA(1);

            	    	    if ( (LA10_0==COLON) ) {
            	    	        alt10=1;
            	    	    }
            	    	    switch (alt10) {
            	    	        case 1 :
            	    	            // ShellCommand.g:423:22: COLON t= type
            	    	            {
            	    	            match(input,COLON,FOLLOW_COLON_in_expression1029); if (state.failed) return retval;

            	    	            pushFollow(FOLLOW_type_in_expression1033);
            	    	            t=type();

            	    	            state._fsp--;
            	    	            if (state.failed) return retval;

            	    	            }
            	    	            break;

            	    	    }


            	    	    match(input,EQUAL,FOLLOW_EQUAL_in_expression1038); if (state.failed) return retval;

            	    	    pushFollow(FOLLOW_expression_in_expression1042);
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
            	    	    break loop11;
            	        }
            	    } while (true);


            	    match(input,78,FOLLOW_78_in_expression1083); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            pushFollow(FOLLOW_identicalExpression_in_expression1099);
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
    // ShellCommand.g:455:1: paramList returns [List<ASTVariableDeclaration> paramList] : LPAREN (v= variableDeclaration ( COMMA v= variableDeclaration )* )? RPAREN ;
    public final List<ASTVariableDeclaration> paramList() throws RecognitionException {
        List<ASTVariableDeclaration> paramList = null;


        ASTVariableDeclaration v =null;


         paramList = new ArrayList<ASTVariableDeclaration>(); 
        try {
            // ShellCommand.g:457:5: ( LPAREN (v= variableDeclaration ( COMMA v= variableDeclaration )* )? RPAREN )
            // ShellCommand.g:458:5: LPAREN (v= variableDeclaration ( COMMA v= variableDeclaration )* )? RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_paramList1132); if (state.failed) return paramList;

            // ShellCommand.g:459:5: (v= variableDeclaration ( COMMA v= variableDeclaration )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ShellCommand.g:460:7: v= variableDeclaration ( COMMA v= variableDeclaration )*
                    {
                    pushFollow(FOLLOW_variableDeclaration_in_paramList1149);
                    v=variableDeclaration();

                    state._fsp--;
                    if (state.failed) return paramList;

                    if ( state.backtracking==0 ) { paramList.add(v); }

                    // ShellCommand.g:461:7: ( COMMA v= variableDeclaration )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==COMMA) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ShellCommand.g:461:9: COMMA v= variableDeclaration
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_paramList1161); if (state.failed) return paramList;

                    	    pushFollow(FOLLOW_variableDeclaration_in_paramList1165);
                    	    v=variableDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return paramList;

                    	    if ( state.backtracking==0 ) { paramList.add(v); }

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_paramList1185); if (state.failed) return paramList;

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
    // ShellCommand.g:469:1: idList returns [List idList] : id0= IDENT ( COMMA idn= IDENT )* ;
    public final List idList() throws RecognitionException {
        List idList = null;


        Token id0=null;
        Token idn=null;

         idList = new ArrayList(); 
        try {
            // ShellCommand.g:471:5: (id0= IDENT ( COMMA idn= IDENT )* )
            // ShellCommand.g:472:5: id0= IDENT ( COMMA idn= IDENT )*
            {
            id0=(Token)match(input,IDENT,FOLLOW_IDENT_in_idList1214); if (state.failed) return idList;

            if ( state.backtracking==0 ) { idList.add(id0); }

            // ShellCommand.g:473:5: ( COMMA idn= IDENT )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COMMA) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ShellCommand.g:473:7: COMMA idn= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_idList1224); if (state.failed) return idList;

            	    idn=(Token)match(input,IDENT,FOLLOW_IDENT_in_idList1228); if (state.failed) return idList;

            	    if ( state.backtracking==0 ) { idList.add(idn); }

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ShellCommand.g:481:1: variableDeclaration returns [ASTVariableDeclaration n] : name= IDENT COLON t= type ;
    public final ASTVariableDeclaration variableDeclaration() throws RecognitionException {
        ASTVariableDeclaration n = null;


        Token name=null;
        ASTType t =null;


        try {
            // ShellCommand.g:482:5: (name= IDENT COLON t= type )
            // ShellCommand.g:483:5: name= IDENT COLON t= type
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_variableDeclaration1259); if (state.failed) return n;

            match(input,COLON,FOLLOW_COLON_in_variableDeclaration1261); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_variableDeclaration1265);
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
    // ShellCommand.g:491:1: identicalExpression returns [ASTExpression n] : conImpExp= conditionalImpliesExpression ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )* ;
    public final ASTExpression identicalExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression conImpExp =null;

        ASTExpression n1 =null;


        try {
            // ShellCommand.g:492:5: (conImpExp= conditionalImpliesExpression ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )* )
            // ShellCommand.g:493:5: conImpExp= conditionalImpliesExpression ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )*
            {
            pushFollow(FOLLOW_conditionalImpliesExpression_in_identicalExpression1296);
            conImpExp=conditionalImpliesExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = conImpExp; }

            // ShellCommand.g:494:5: ( DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==DOT) ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1==71) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ShellCommand.g:495:9: DOT op= 'equals' LPAREN n1= conditionalImpliesExpression RPAREN
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_identicalExpression1314); if (state.failed) return n;

            	    op=(Token)match(input,71,FOLLOW_71_in_identicalExpression1318); if (state.failed) return n;

            	    match(input,LPAREN,FOLLOW_LPAREN_in_identicalExpression1320); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalImpliesExpression_in_identicalExpression1324);
            	    n1=conditionalImpliesExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    match(input,RPAREN,FOLLOW_RPAREN_in_identicalExpression1326); if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ShellCommand.g:504:1: conditionalImpliesExpression returns [ASTExpression n] : nCndOrExp= conditionalOrExpression (op= 'implies' n1= conditionalOrExpression )* ;
    public final ASTExpression conditionalImpliesExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nCndOrExp =null;

        ASTExpression n1 =null;


        try {
            // ShellCommand.g:505:5: (nCndOrExp= conditionalOrExpression (op= 'implies' n1= conditionalOrExpression )* )
            // ShellCommand.g:506:5: nCndOrExp= conditionalOrExpression (op= 'implies' n1= conditionalOrExpression )*
            {
            pushFollow(FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression1369);
            nCndOrExp=conditionalOrExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nCndOrExp;}

            // ShellCommand.g:507:5: (op= 'implies' n1= conditionalOrExpression )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==77) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ShellCommand.g:507:7: op= 'implies' n1= conditionalOrExpression
            	    {
            	    op=(Token)match(input,77,FOLLOW_77_in_conditionalImpliesExpression1382); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression1386);
            	    n1=conditionalOrExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ShellCommand.g:516:1: conditionalOrExpression returns [ASTExpression n] : nCndXorExp= conditionalXOrExpression (op= 'or' n1= conditionalXOrExpression )* ;
    public final ASTExpression conditionalOrExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nCndXorExp =null;

        ASTExpression n1 =null;


        try {
            // ShellCommand.g:517:5: (nCndXorExp= conditionalXOrExpression (op= 'or' n1= conditionalXOrExpression )* )
            // ShellCommand.g:518:5: nCndXorExp= conditionalXOrExpression (op= 'or' n1= conditionalXOrExpression )*
            {
            pushFollow(FOLLOW_conditionalXOrExpression_in_conditionalOrExpression1431);
            nCndXorExp=conditionalXOrExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nCndXorExp;}

            // ShellCommand.g:519:5: (op= 'or' n1= conditionalXOrExpression )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==94) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ShellCommand.g:519:7: op= 'or' n1= conditionalXOrExpression
            	    {
            	    op=(Token)match(input,94,FOLLOW_94_in_conditionalOrExpression1444); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalXOrExpression_in_conditionalOrExpression1448);
            	    n1=conditionalXOrExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = new ASTBinaryExpression(op, n, n1); }

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
    // $ANTLR end "conditionalOrExpression"



    // $ANTLR start "conditionalXOrExpression"
    // ShellCommand.g:528:1: conditionalXOrExpression returns [ASTExpression n] : nCndAndExp= conditionalAndExpression (op= 'xor' n1= conditionalAndExpression )* ;
    public final ASTExpression conditionalXOrExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nCndAndExp =null;

        ASTExpression n1 =null;


        try {
            // ShellCommand.g:529:5: (nCndAndExp= conditionalAndExpression (op= 'xor' n1= conditionalAndExpression )* )
            // ShellCommand.g:530:5: nCndAndExp= conditionalAndExpression (op= 'xor' n1= conditionalAndExpression )*
            {
            pushFollow(FOLLOW_conditionalAndExpression_in_conditionalXOrExpression1492);
            nCndAndExp=conditionalAndExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nCndAndExp;}

            // ShellCommand.g:531:5: (op= 'xor' n1= conditionalAndExpression )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==102) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ShellCommand.g:531:7: op= 'xor' n1= conditionalAndExpression
            	    {
            	    op=(Token)match(input,102,FOLLOW_102_in_conditionalXOrExpression1505); if (state.failed) return n;

            	    pushFollow(FOLLOW_conditionalAndExpression_in_conditionalXOrExpression1509);
            	    n1=conditionalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

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
    // $ANTLR end "conditionalXOrExpression"



    // $ANTLR start "conditionalAndExpression"
    // ShellCommand.g:540:1: conditionalAndExpression returns [ASTExpression n] : nEqExp= equalityExpression (op= 'and' n1= equalityExpression )* ;
    public final ASTExpression conditionalAndExpression() throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTExpression nEqExp =null;

        ASTExpression n1 =null;


        try {
            // ShellCommand.g:541:5: (nEqExp= equalityExpression (op= 'and' n1= equalityExpression )* )
            // ShellCommand.g:542:5: nEqExp= equalityExpression (op= 'and' n1= equalityExpression )*
            {
            pushFollow(FOLLOW_equalityExpression_in_conditionalAndExpression1553);
            nEqExp=equalityExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nEqExp;}

            // ShellCommand.g:543:5: (op= 'and' n1= equalityExpression )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==57) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ShellCommand.g:543:7: op= 'and' n1= equalityExpression
            	    {
            	    op=(Token)match(input,57,FOLLOW_57_in_conditionalAndExpression1566); if (state.failed) return n;

            	    pushFollow(FOLLOW_equalityExpression_in_conditionalAndExpression1570);
            	    n1=equalityExpression();

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
    // $ANTLR end "conditionalAndExpression"



    // $ANTLR start "equalityExpression"
    // ShellCommand.g:552:1: equalityExpression returns [ASTExpression n] : nRelExp= relationalExpression ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )* ;
    public final ASTExpression equalityExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nRelExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // ShellCommand.g:554:5: (nRelExp= relationalExpression ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )* )
            // ShellCommand.g:555:5: nRelExp= relationalExpression ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )*
            {
            pushFollow(FOLLOW_relationalExpression_in_equalityExpression1618);
            nRelExp=relationalExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nRelExp;}

            // ShellCommand.g:556:5: ( ( EQUAL | NOT_EQUAL ) n1= relationalExpression )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==EQUAL||LA21_0==NOT_EQUAL) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ShellCommand.g:556:7: ( EQUAL | NOT_EQUAL ) n1= relationalExpression
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


            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression1647);
            	    n1=relationalExpression();

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
    // $ANTLR end "equalityExpression"



    // $ANTLR start "relationalExpression"
    // ShellCommand.g:566:1: relationalExpression returns [ASTExpression n] : nAddiExp= additiveExpression ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )* ;
    public final ASTExpression relationalExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nAddiExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // ShellCommand.g:568:5: (nAddiExp= additiveExpression ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )* )
            // ShellCommand.g:569:5: nAddiExp= additiveExpression ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )*
            {
            pushFollow(FOLLOW_additiveExpression_in_relationalExpression1696);
            nAddiExp=additiveExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nAddiExp;}

            // ShellCommand.g:570:5: ( ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0 >= GREATER && LA22_0 <= GREATER_EQUAL)||(LA22_0 >= LESS && LA22_0 <= LESS_EQUAL)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ShellCommand.g:570:7: ( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) n1= additiveExpression
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


            	    pushFollow(FOLLOW_additiveExpression_in_relationalExpression1732);
            	    n1=additiveExpression();

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
    // $ANTLR end "relationalExpression"



    // $ANTLR start "additiveExpression"
    // ShellCommand.g:580:1: additiveExpression returns [ASTExpression n] : nMulExp= multiplicativeExpression ( ( PLUS | MINUS ) n1= multiplicativeExpression )* ;
    public final ASTExpression additiveExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nMulExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // ShellCommand.g:582:5: (nMulExp= multiplicativeExpression ( ( PLUS | MINUS ) n1= multiplicativeExpression )* )
            // ShellCommand.g:583:5: nMulExp= multiplicativeExpression ( ( PLUS | MINUS ) n1= multiplicativeExpression )*
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1782);
            nMulExp=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) {n = nMulExp;}

            // ShellCommand.g:584:5: ( ( PLUS | MINUS ) n1= multiplicativeExpression )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==MINUS||LA23_0==PLUS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ShellCommand.g:584:7: ( PLUS | MINUS ) n1= multiplicativeExpression
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


            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1810);
            	    n1=multiplicativeExpression();

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
    // $ANTLR end "additiveExpression"



    // $ANTLR start "multiplicativeExpression"
    // ShellCommand.g:595:1: multiplicativeExpression returns [ASTExpression n] : nUnExp= unaryExpression ( ( STAR | SLASH | 'div' ) n1= unaryExpression )* ;
    public final ASTExpression multiplicativeExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nUnExp =null;

        ASTExpression n1 =null;


         Token op = null; 
        try {
            // ShellCommand.g:597:5: (nUnExp= unaryExpression ( ( STAR | SLASH | 'div' ) n1= unaryExpression )* )
            // ShellCommand.g:598:5: nUnExp= unaryExpression ( ( STAR | SLASH | 'div' ) n1= unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1860);
            nUnExp=unaryExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n = nUnExp;}

            // ShellCommand.g:599:5: ( ( STAR | SLASH | 'div' ) n1= unaryExpression )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==SLASH||LA24_0==STAR||LA24_0==66) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ShellCommand.g:599:7: ( STAR | SLASH | 'div' ) n1= unaryExpression
            	    {
            	    if ( state.backtracking==0 ) { op = input.LT(1); }

            	    if ( input.LA(1)==SLASH||input.LA(1)==STAR||input.LA(1)==66 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return n;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1892);
            	    n1=unaryExpression();

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
    // $ANTLR end "multiplicativeExpression"



    // $ANTLR start "unaryExpression"
    // ShellCommand.g:611:1: unaryExpression returns [ASTExpression n] : ( ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression ) |nPosExp= postfixExpression );
    public final ASTExpression unaryExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nUnExp =null;

        ASTExpression nPosExp =null;


         Token op = null; 
        try {
            // ShellCommand.g:613:7: ( ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression ) |nPosExp= postfixExpression )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==MINUS||LA25_0==PLUS||LA25_0==84) ) {
                alt25=1;
            }
            else if ( (LA25_0==AT||LA25_0==HASH||(LA25_0 >= IDENT && LA25_0 <= INT)||LA25_0==LPAREN||LA25_0==REAL||(LA25_0 >= STAR && LA25_0 <= STRING)||(LA25_0 >= 44 && LA25_0 <= 55)||LA25_0==73||LA25_0==76||LA25_0==81||(LA25_0 >= 85 && LA25_0 <= 91)||(LA25_0 >= 96 && LA25_0 <= 97)||LA25_0==100) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // ShellCommand.g:614:7: ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression )
                    {
                    // ShellCommand.g:614:7: ( ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression )
                    // ShellCommand.g:614:9: ( 'not' | MINUS | PLUS ) nUnExp= unaryExpression
                    {
                    if ( state.backtracking==0 ) { op = input.LT(1); }

                    if ( input.LA(1)==MINUS||input.LA(1)==PLUS||input.LA(1)==84 ) {
                        input.consume();
                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression1978);
                    nUnExp=unaryExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUnaryExpression(op, nUnExp); }

                    }


                    }
                    break;
                case 2 :
                    // ShellCommand.g:618:7: nPosExp= postfixExpression
                    {
                    pushFollow(FOLLOW_postfixExpression_in_unaryExpression1998);
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
    // ShellCommand.g:626:1: postfixExpression returns [ASTExpression n] : nPrimExp= primaryExpression ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )* ;
    public final ASTExpression postfixExpression() throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nPrimExp =null;

        ASTExpression nPc =null;


         boolean arrow = false; 
        try {
            // ShellCommand.g:628:5: (nPrimExp= primaryExpression ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )* )
            // ShellCommand.g:629:5: nPrimExp= primaryExpression ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )*
            {
            pushFollow(FOLLOW_primaryExpression_in_postfixExpression2031);
            nPrimExp=primaryExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n = nPrimExp; }

            // ShellCommand.g:630:5: ( ( ARROW | DOT ) nPc= propertyCall[$n, arrow] )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==DOT) ) {
                    int LA27_2 = input.LA(2);

                    if ( (LA27_2==IDENT) ) {
                        int LA27_4 = input.LA(3);

                        if ( (LA27_4==EOF||(LA27_4 >= ARROW && LA27_4 <= BAR)||(LA27_4 >= COMMA && LA27_4 <= EQUAL)||(LA27_4 >= GREATER && LA27_4 <= GREATER_EQUAL)||LA27_4==IDENT||(LA27_4 >= LBRACE && LA27_4 <= MINUS)||(LA27_4 >= NOT_EQUAL && LA27_4 <= PLUS)||(LA27_4 >= RBRACE && LA27_4 <= RBRACK)||(LA27_4 >= RPAREN && LA27_4 <= SLASH)||LA27_4==STAR||(LA27_4 >= 57 && LA27_4 <= 58)||LA27_4==62||(LA27_4 >= 64 && LA27_4 <= 70)||LA27_4==72||(LA27_4 >= 77 && LA27_4 <= 79)||LA27_4==82||LA27_4==94||(LA27_4 >= 98 && LA27_4 <= 99)||LA27_4==102) ) {
                            alt27=1;
                        }


                    }
                    else if ( (LA27_2==81||LA27_2==86||(LA27_2 >= 88 && LA27_2 <= 90)||(LA27_2 >= 96 && LA27_2 <= 97)) ) {
                        alt27=1;
                    }


                }
                else if ( (LA27_0==ARROW) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ShellCommand.g:631:6: ( ARROW | DOT ) nPc= propertyCall[$n, arrow]
            	    {
            	    // ShellCommand.g:631:6: ( ARROW | DOT )
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==ARROW) ) {
            	        alt26=1;
            	    }
            	    else if ( (LA26_0==DOT) ) {
            	        alt26=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return n;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 26, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // ShellCommand.g:631:8: ARROW
            	            {
            	            match(input,ARROW,FOLLOW_ARROW_in_postfixExpression2049); if (state.failed) return n;

            	            if ( state.backtracking==0 ) { arrow = true; }

            	            }
            	            break;
            	        case 2 :
            	            // ShellCommand.g:631:34: DOT
            	            {
            	            match(input,DOT,FOLLOW_DOT_in_postfixExpression2055); if (state.failed) return n;

            	            if ( state.backtracking==0 ) { arrow = false; }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_propertyCall_in_postfixExpression2066);
            	    nPc=propertyCall(n, arrow);

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n = nPc; }

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
    // $ANTLR end "postfixExpression"



    // $ANTLR start "primaryExpression"
    // ShellCommand.g:647:1: primaryExpression returns [ASTExpression n] : (nLit= literal |nOr= objectReference |nPc= propertyCall[null, false] | LPAREN nExp= expression RPAREN |nIfExp= ifExpression |id1= IDENT DOT 'allInstances' ( AT 'pre' )? ( LPAREN RPAREN )? |id2= IDENT DOT 'byUseId' ( LPAREN idExp= expression RPAREN ) ( AT 'pre' )? );
    public final ASTExpression primaryExpression() throws RecognitionException {
        ASTExpression n = null;


        Token id1=null;
        Token id2=null;
        ASTExpression nLit =null;

        ASTExpression nOr =null;

        ASTExpression nPc =null;

        ShellCommandParser.expression_return nExp =null;

        ASTExpression nIfExp =null;

        ShellCommandParser.expression_return idExp =null;


        try {
            // ShellCommand.g:648:7: (nLit= literal |nOr= objectReference |nPc= propertyCall[null, false] | LPAREN nExp= expression RPAREN |nIfExp= ifExpression |id1= IDENT DOT 'allInstances' ( AT 'pre' )? ( LPAREN RPAREN )? |id2= IDENT DOT 'byUseId' ( LPAREN idExp= expression RPAREN ) ( AT 'pre' )? )
            int alt31=7;
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
            case 73:
            case 85:
            case 87:
            case 91:
            case 100:
                {
                alt31=1;
                }
                break;
            case IDENT:
                {
                switch ( input.LA(2) ) {
                case COLON_COLON:
                    {
                    alt31=1;
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
                case 57:
                case 58:
                case 62:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 72:
                case 77:
                case 78:
                case 79:
                case 82:
                case 94:
                case 98:
                case 99:
                case 102:
                    {
                    alt31=3;
                    }
                    break;
                case DOT:
                    {
                    switch ( input.LA(3) ) {
                    case 56:
                        {
                        alt31=6;
                        }
                        break;
                    case 61:
                        {
                        alt31=7;
                        }
                        break;
                    case IDENT:
                    case 71:
                    case 81:
                    case 86:
                    case 88:
                    case 89:
                    case 90:
                    case 96:
                    case 97:
                        {
                        alt31=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return n;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 7, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 2, input);

                    throw nvae;

                }

                }
                break;
            case AT:
                {
                alt31=2;
                }
                break;
            case 81:
            case 86:
            case 88:
            case 89:
            case 90:
            case 96:
            case 97:
                {
                alt31=3;
                }
                break;
            case LPAREN:
                {
                alt31=4;
                }
                break;
            case 76:
                {
                alt31=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // ShellCommand.g:649:7: nLit= literal
                    {
                    pushFollow(FOLLOW_literal_in_primaryExpression2106);
                    nLit=literal();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nLit; }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:650:7: nOr= objectReference
                    {
                    pushFollow(FOLLOW_objectReference_in_primaryExpression2120);
                    nOr=objectReference();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nOr; }

                    }
                    break;
                case 3 :
                    // ShellCommand.g:651:7: nPc= propertyCall[null, false]
                    {
                    pushFollow(FOLLOW_propertyCall_in_primaryExpression2132);
                    nPc=propertyCall(null, false);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nPc; }

                    }
                    break;
                case 4 :
                    // ShellCommand.g:652:7: LPAREN nExp= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression2143); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_primaryExpression2147);
                    nExp=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression2149); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (nExp!=null?nExp.n:null); }

                    }
                    break;
                case 5 :
                    // ShellCommand.g:653:7: nIfExp= ifExpression
                    {
                    pushFollow(FOLLOW_ifExpression_in_primaryExpression2161);
                    nIfExp=ifExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nIfExp; }

                    }
                    break;
                case 6 :
                    // ShellCommand.g:654:7: id1= IDENT DOT 'allInstances' ( AT 'pre' )? ( LPAREN RPAREN )?
                    {
                    id1=(Token)match(input,IDENT,FOLLOW_IDENT_in_primaryExpression2173); if (state.failed) return n;

                    match(input,DOT,FOLLOW_DOT_in_primaryExpression2175); if (state.failed) return n;

                    match(input,56,FOLLOW_56_in_primaryExpression2177); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTAllInstancesExpression(id1); }

                    // ShellCommand.g:656:9: ( AT 'pre' )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==AT) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // ShellCommand.g:656:11: AT 'pre'
                            {
                            match(input,AT,FOLLOW_AT_in_primaryExpression2200); if (state.failed) return n;

                            match(input,95,FOLLOW_95_in_primaryExpression2202); if (state.failed) return n;

                            if ( state.backtracking==0 ) { n.setIsPre(); }

                            }
                            break;

                    }


                    // ShellCommand.g:657:9: ( LPAREN RPAREN )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==LPAREN) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ShellCommand.g:657:11: LPAREN RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression2220); if (state.failed) return n;

                            match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression2222); if (state.failed) return n;

                            }
                            break;

                    }


                    }
                    break;
                case 7 :
                    // ShellCommand.g:658:7: id2= IDENT DOT 'byUseId' ( LPAREN idExp= expression RPAREN ) ( AT 'pre' )?
                    {
                    id2=(Token)match(input,IDENT,FOLLOW_IDENT_in_primaryExpression2235); if (state.failed) return n;

                    match(input,DOT,FOLLOW_DOT_in_primaryExpression2237); if (state.failed) return n;

                    match(input,61,FOLLOW_61_in_primaryExpression2239); if (state.failed) return n;

                    // ShellCommand.g:658:31: ( LPAREN idExp= expression RPAREN )
                    // ShellCommand.g:658:33: LPAREN idExp= expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression2243); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_primaryExpression2247);
                    idExp=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression2249); if (state.failed) return n;

                    }


                    if ( state.backtracking==0 ) { n = new ASTObjectByUseIdExpression(id2, (idExp!=null?idExp.n:null)); }

                    // ShellCommand.g:660:7: ( AT 'pre' )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==AT) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ShellCommand.g:660:9: AT 'pre'
                            {
                            match(input,AT,FOLLOW_AT_in_primaryExpression2269); if (state.failed) return n;

                            match(input,95,FOLLOW_95_in_primaryExpression2271); if (state.failed) return n;

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
    // ShellCommand.g:664:1: objectReference returns [ASTExpression n] : AT objectName= IDENT ;
    public final ASTExpression objectReference() throws RecognitionException {
        ASTExpression n = null;


        Token objectName=null;

        try {
            // ShellCommand.g:665:3: ( AT objectName= IDENT )
            // ShellCommand.g:666:3: AT objectName= IDENT
            {
            match(input,AT,FOLLOW_AT_in_objectReference2297); if (state.failed) return n;

            objectName=(Token)match(input,IDENT,FOLLOW_IDENT_in_objectReference2305); if (state.failed) return n;

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
    // ShellCommand.g:680:1: propertyCall[ASTExpression source, boolean followsArrow] returns [ASTExpression n] : ({...}?{...}?nExpQuery= queryExpression[source] |nExpIterate= iterateExpression[source] |nExpOperation= operationExpression[source, followsArrow] |nExpType= typeExpression[source, followsArrow] |nExpInState= inStateExpression[source, followsArrow] );
    public final ASTExpression propertyCall(ASTExpression source, boolean followsArrow) throws RecognitionException {
        ASTExpression n = null;


        ASTExpression nExpQuery =null;

        ASTExpression nExpIterate =null;

        ShellCommandParser.operationExpression_return nExpOperation =null;

        ASTTypeArgExpression nExpType =null;

        ASTInStateExpression nExpInState =null;


        try {
            // ShellCommand.g:681:7: ({...}?{...}?nExpQuery= queryExpression[source] |nExpIterate= iterateExpression[source] |nExpOperation= operationExpression[source, followsArrow] |nExpType= typeExpression[source, followsArrow] |nExpInState= inStateExpression[source, followsArrow] )
            int alt32=5;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA32_1 = input.LA(2);

                if ( (((( input.LA(2) == LPAREN )&&( input.LA(2) == LPAREN ))&&( org.tzi.use.parser.base.ParserHelper.isQueryIdent(input.LT(1)) ))) ) {
                    alt32=1;
                }
                else if ( (true) ) {
                    alt32=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;

                }
                }
                break;
            case 81:
                {
                alt32=2;
                }
                break;
            case 86:
            case 89:
            case 90:
            case 96:
            case 97:
                {
                alt32=4;
                }
                break;
            case 88:
                {
                alt32=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }

            switch (alt32) {
                case 1 :
                    // ShellCommand.g:685:7: {...}?{...}?nExpQuery= queryExpression[source]
                    {
                    if ( !(( org.tzi.use.parser.base.ParserHelper.isQueryIdent(input.LT(1)) )) ) {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        throw new FailedPredicateException(input, "propertyCall", " org.tzi.use.parser.base.ParserHelper.isQueryIdent(input.LT(1)) ");
                    }

                    if ( !(( input.LA(2) == LPAREN )) ) {
                        if (state.backtracking>0) {state.failed=true; return n;}
                        throw new FailedPredicateException(input, "propertyCall", " input.LA(2) == LPAREN ");
                    }

                    pushFollow(FOLLOW_queryExpression_in_propertyCall2370);
                    nExpQuery=queryExpression(source);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nExpQuery; }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:688:7: nExpIterate= iterateExpression[source]
                    {
                    pushFollow(FOLLOW_iterateExpression_in_propertyCall2383);
                    nExpIterate=iterateExpression(source);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nExpIterate; }

                    }
                    break;
                case 3 :
                    // ShellCommand.g:689:7: nExpOperation= operationExpression[source, followsArrow]
                    {
                    pushFollow(FOLLOW_operationExpression_in_propertyCall2396);
                    nExpOperation=operationExpression(source, followsArrow);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (nExpOperation!=null?nExpOperation.n:null); }

                    }
                    break;
                case 4 :
                    // ShellCommand.g:690:7: nExpType= typeExpression[source, followsArrow]
                    {
                    pushFollow(FOLLOW_typeExpression_in_propertyCall2409);
                    nExpType=typeExpression(source, followsArrow);

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nExpType; }

                    }
                    break;
                case 5 :
                    // ShellCommand.g:691:7: nExpInState= inStateExpression[source, followsArrow]
                    {
                    pushFollow(FOLLOW_inStateExpression_in_propertyCall2422);
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
    // ShellCommand.g:700:1: queryExpression[ASTExpression range] returns [ASTExpression n] : op= IDENT LPAREN (decls= elemVarsDeclaration BAR )? nExp= expression ( COMMA uncerExp= additiveExpression )? RPAREN ;
    public final ASTExpression queryExpression(ASTExpression range) throws RecognitionException {
        ASTExpression n = null;


        Token op=null;
        ASTElemVarsDeclaration decls =null;

        ShellCommandParser.expression_return nExp =null;

        ASTExpression uncerExp =null;



                ASTElemVarsDeclaration decl = new ASTElemVarsDeclaration();
                ASTExpression uncer = null;
            
        try {
            // ShellCommand.g:704:6: (op= IDENT LPAREN (decls= elemVarsDeclaration BAR )? nExp= expression ( COMMA uncerExp= additiveExpression )? RPAREN )
            // ShellCommand.g:705:5: op= IDENT LPAREN (decls= elemVarsDeclaration BAR )? nExp= expression ( COMMA uncerExp= additiveExpression )? RPAREN
            {
            op=(Token)match(input,IDENT,FOLLOW_IDENT_in_queryExpression2457); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_queryExpression2464); if (state.failed) return n;

            // ShellCommand.g:707:5: (decls= elemVarsDeclaration BAR )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==IDENT) ) {
                int LA33_1 = input.LA(2);

                if ( ((LA33_1 >= BAR && LA33_1 <= COLON)) ) {
                    alt33=1;
                }
                else if ( (LA33_1==COMMA) ) {
                    int LA33_4 = input.LA(3);

                    if ( (LA33_4==IDENT) ) {
                        int LA33_5 = input.LA(4);

                        if ( ((LA33_5 >= BAR && LA33_5 <= COLON)||LA33_5==COMMA) ) {
                            alt33=1;
                        }
                    }
                }
            }
            switch (alt33) {
                case 1 :
                    // ShellCommand.g:707:7: decls= elemVarsDeclaration BAR
                    {
                    pushFollow(FOLLOW_elemVarsDeclaration_in_queryExpression2475);
                    decls=elemVarsDeclaration();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) {decl = decls;}

                    match(input,BAR,FOLLOW_BAR_in_queryExpression2479); if (state.failed) return n;

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_queryExpression2490);
            nExp=expression();

            state._fsp--;
            if (state.failed) return n;

            // ShellCommand.g:709:5: ( COMMA uncerExp= additiveExpression )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==COMMA) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ShellCommand.g:709:7: COMMA uncerExp= additiveExpression
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_queryExpression2498); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_queryExpression2502);
                    uncerExp=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { uncer = uncerExp;}

                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_queryExpression2513); if (state.failed) return n;

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
    // ShellCommand.g:722:1: iterateExpression[ASTExpression range] returns [ASTExpression n] : i= 'iterate' LPAREN decls= elemVarsDeclaration SEMI init= variableInitialization BAR nExp= expression RPAREN ;
    public final ASTExpression iterateExpression(ASTExpression range) throws RecognitionException {
        ASTExpression n = null;


        Token i=null;
        ASTElemVarsDeclaration decls =null;

        ASTVariableInitialization init =null;

        ShellCommandParser.expression_return nExp =null;


        try {
            // ShellCommand.g:722:65: (i= 'iterate' LPAREN decls= elemVarsDeclaration SEMI init= variableInitialization BAR nExp= expression RPAREN )
            // ShellCommand.g:723:5: i= 'iterate' LPAREN decls= elemVarsDeclaration SEMI init= variableInitialization BAR nExp= expression RPAREN
            {
            i=(Token)match(input,81,FOLLOW_81_in_iterateExpression2545); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_iterateExpression2551); if (state.failed) return n;

            pushFollow(FOLLOW_elemVarsDeclaration_in_iterateExpression2559);
            decls=elemVarsDeclaration();

            state._fsp--;
            if (state.failed) return n;

            match(input,SEMI,FOLLOW_SEMI_in_iterateExpression2561); if (state.failed) return n;

            pushFollow(FOLLOW_variableInitialization_in_iterateExpression2569);
            init=variableInitialization();

            state._fsp--;
            if (state.failed) return n;

            match(input,BAR,FOLLOW_BAR_in_iterateExpression2571); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_iterateExpression2579);
            nExp=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_iterateExpression2585); if (state.failed) return n;

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
    // ShellCommand.g:744:1: operationExpression[ASTExpression source, boolean followsArrow] returns [ASTOperationExpression n] : name= IDENT ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )? ( AT 'pre' )? ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )? ;
    public final ShellCommandParser.operationExpression_return operationExpression(ASTExpression source, boolean followsArrow) throws RecognitionException {
        ShellCommandParser.operationExpression_return retval = new ShellCommandParser.operationExpression_return();
        retval.start = input.LT(1);


        Token name=null;
        ShellCommandParser.expression_return rolename =null;

        ShellCommandParser.expression_return e =null;


        try {
            // ShellCommand.g:746:5: (name= IDENT ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )? ( AT 'pre' )? ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )? )
            // ShellCommand.g:747:5: name= IDENT ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )? ( AT 'pre' )? ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )?
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_operationExpression2629); if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n = new ASTOperationExpression(name, source, followsArrow); }

            // ShellCommand.g:753:5: ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )? )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==LBRACK) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ShellCommand.g:753:7: LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )?
                    {
                    match(input,LBRACK,FOLLOW_LBRACK_in_operationExpression2651); if (state.failed) return retval;

                    pushFollow(FOLLOW_expression_in_operationExpression2664);
                    rolename=expression();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.addExplicitRolenameOrQualifier((rolename!=null?rolename.n:null)); }

                    // ShellCommand.g:755:9: ( COMMA rolename= expression )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==COMMA) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ShellCommand.g:755:10: COMMA rolename= expression
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_operationExpression2677); if (state.failed) return retval;

                    	    pushFollow(FOLLOW_expression_in_operationExpression2681);
                    	    rolename=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) { retval.n.addExplicitRolenameOrQualifier((rolename!=null?rolename.n:null)); }

                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    match(input,RBRACK,FOLLOW_RBRACK_in_operationExpression2693); if (state.failed) return retval;

                    // ShellCommand.g:758:7: ( LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==LBRACK) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // ShellCommand.g:758:9: LBRACK rolename= expression ( COMMA rolename= expression )* RBRACK
                            {
                            match(input,LBRACK,FOLLOW_LBRACK_in_operationExpression2710); if (state.failed) return retval;

                            pushFollow(FOLLOW_expression_in_operationExpression2725);
                            rolename=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            if ( state.backtracking==0 ) { retval.n.addQualifier((rolename!=null?rolename.n:null)); }

                            // ShellCommand.g:760:11: ( COMMA rolename= expression )*
                            loop36:
                            do {
                                int alt36=2;
                                int LA36_0 = input.LA(1);

                                if ( (LA36_0==COMMA) ) {
                                    alt36=1;
                                }


                                switch (alt36) {
                            	case 1 :
                            	    // ShellCommand.g:760:12: COMMA rolename= expression
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_operationExpression2740); if (state.failed) return retval;

                            	    pushFollow(FOLLOW_expression_in_operationExpression2744);
                            	    rolename=expression();

                            	    state._fsp--;
                            	    if (state.failed) return retval;

                            	    if ( state.backtracking==0 ) { retval.n.addQualifier((rolename!=null?rolename.n:null)); }

                            	    }
                            	    break;

                            	default :
                            	    break loop36;
                                }
                            } while (true);


                            match(input,RBRACK,FOLLOW_RBRACK_in_operationExpression2758); if (state.failed) return retval;

                            }
                            break;

                    }


                    }
                    break;

            }


            // ShellCommand.g:765:5: ( AT 'pre' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==AT) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ShellCommand.g:765:7: AT 'pre'
                    {
                    match(input,AT,FOLLOW_AT_in_operationExpression2783); if (state.failed) return retval;

                    match(input,95,FOLLOW_95_in_operationExpression2785); if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.setIsPre(); }

                    }
                    break;

            }


            // ShellCommand.g:767:5: ( LPAREN (e= expression ( COMMA e= expression )* )? RPAREN )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==LPAREN) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ShellCommand.g:768:7: LPAREN (e= expression ( COMMA e= expression )* )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_operationExpression2810); if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.hasParentheses(); }

                    // ShellCommand.g:769:7: (e= expression ( COMMA e= expression )* )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==AT||LA41_0==HASH||(LA41_0 >= IDENT && LA41_0 <= INT)||(LA41_0 >= LPAREN && LA41_0 <= MINUS)||LA41_0==PLUS||LA41_0==REAL||(LA41_0 >= STAR && LA41_0 <= STRING)||(LA41_0 >= 44 && LA41_0 <= 55)||LA41_0==73||LA41_0==76||(LA41_0 >= 81 && LA41_0 <= 82)||(LA41_0 >= 84 && LA41_0 <= 91)||(LA41_0 >= 96 && LA41_0 <= 97)||LA41_0==100) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ShellCommand.g:770:7: e= expression ( COMMA e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_operationExpression2831);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return retval;

                            if ( state.backtracking==0 ) { retval.n.addArg((e!=null?e.n:null)); }

                            // ShellCommand.g:771:7: ( COMMA e= expression )*
                            loop40:
                            do {
                                int alt40=2;
                                int LA40_0 = input.LA(1);

                                if ( (LA40_0==COMMA) ) {
                                    alt40=1;
                                }


                                switch (alt40) {
                            	case 1 :
                            	    // ShellCommand.g:771:9: COMMA e= expression
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_operationExpression2843); if (state.failed) return retval;

                            	    pushFollow(FOLLOW_expression_in_operationExpression2847);
                            	    e=expression();

                            	    state._fsp--;
                            	    if (state.failed) return retval;

                            	    if ( state.backtracking==0 ) { retval.n.addArg((e!=null?e.n:null)); }

                            	    }
                            	    break;

                            	default :
                            	    break loop40;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_operationExpression2867); if (state.failed) return retval;

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
    // ShellCommand.g:778:1: inStateExpression[ASTExpression source, boolean followsArrow] returns [ASTInStateExpression n] : opToken= 'oclInState' LPAREN s= IDENT RPAREN ;
    public final ASTInStateExpression inStateExpression(ASTExpression source, boolean followsArrow) throws RecognitionException {
        ASTInStateExpression n = null;


        Token opToken=null;
        Token s=null;

        try {
            // ShellCommand.g:779:35: (opToken= 'oclInState' LPAREN s= IDENT RPAREN )
            // ShellCommand.g:780:4: opToken= 'oclInState' LPAREN s= IDENT RPAREN
            {
            opToken=(Token)match(input,88,FOLLOW_88_in_inStateExpression2904); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_inStateExpression2909); if (state.failed) return n;

            s=(Token)match(input,IDENT,FOLLOW_IDENT_in_inStateExpression2918); if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_inStateExpression2923); if (state.failed) return n;

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
    // ShellCommand.g:792:1: typeExpression[ASTExpression source, boolean followsArrow] returns [ASTTypeArgExpression n] : ( 'oclAsType' | 'oclIsKindOf' | 'oclIsTypeOf' | 'selectByType' | 'selectByKind' ) LPAREN t= type RPAREN ;
    public final ASTTypeArgExpression typeExpression(ASTExpression source, boolean followsArrow) throws RecognitionException {
        ASTTypeArgExpression n = null;


        ASTType t =null;


         Token opToken = null; 
        try {
            // ShellCommand.g:795:2: ( ( 'oclAsType' | 'oclIsKindOf' | 'oclIsTypeOf' | 'selectByType' | 'selectByKind' ) LPAREN t= type RPAREN )
            // ShellCommand.g:796:2: ( 'oclAsType' | 'oclIsKindOf' | 'oclIsTypeOf' | 'selectByType' | 'selectByKind' ) LPAREN t= type RPAREN
            {
            if ( state.backtracking==0 ) { opToken = input.LT(1); }

            if ( input.LA(1)==86||(input.LA(1) >= 89 && input.LA(1) <= 90)||(input.LA(1) >= 96 && input.LA(1) <= 97) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,LPAREN,FOLLOW_LPAREN_in_typeExpression2983); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_typeExpression2987);
            t=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_typeExpression2989); if (state.failed) return n;

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
    // ShellCommand.g:807:1: elemVarsDeclaration returns [ASTElemVarsDeclaration n] :var1= IDENT ( COLON t= type )? ( COMMA varN= IDENT ( COLON tN= type )? )* ;
    public final ASTElemVarsDeclaration elemVarsDeclaration() throws RecognitionException {
        ASTElemVarsDeclaration n = null;


        Token var1=null;
        Token varN=null;
        ASTType t =null;

        ASTType tN =null;


        try {
            // ShellCommand.g:808:1: (var1= IDENT ( COLON t= type )? ( COMMA varN= IDENT ( COLON tN= type )? )* )
            // ShellCommand.g:809:1: var1= IDENT ( COLON t= type )? ( COMMA varN= IDENT ( COLON tN= type )? )*
            {
            if ( state.backtracking==0 ) { n = new ASTElemVarsDeclaration(); }

            var1=(Token)match(input,IDENT,FOLLOW_IDENT_in_elemVarsDeclaration3027); if (state.failed) return n;

            // ShellCommand.g:810:17: ( COLON t= type )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==COLON) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ShellCommand.g:810:18: COLON t= type
                    {
                    match(input,COLON,FOLLOW_COLON_in_elemVarsDeclaration3030); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_elemVarsDeclaration3034);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {n.addDeclaration(var1, t);}

            // ShellCommand.g:811:4: ( COMMA varN= IDENT ( COLON tN= type )? )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==COMMA) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ShellCommand.g:811:5: COMMA varN= IDENT ( COLON tN= type )?
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_elemVarsDeclaration3044); if (state.failed) return n;

            	    varN=(Token)match(input,IDENT,FOLLOW_IDENT_in_elemVarsDeclaration3050); if (state.failed) return n;

            	    // ShellCommand.g:811:24: ( COLON tN= type )?
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==COLON) ) {
            	        alt44=1;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // ShellCommand.g:811:25: COLON tN= type
            	            {
            	            match(input,COLON,FOLLOW_COLON_in_elemVarsDeclaration3053); if (state.failed) return n;

            	            pushFollow(FOLLOW_type_in_elemVarsDeclaration3059);
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
            	    break loop45;
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
    // ShellCommand.g:819:1: variableInitialization returns [ASTVariableInitialization n] : name= IDENT COLON t= type EQUAL e= expression ;
    public final ASTVariableInitialization variableInitialization() throws RecognitionException {
        ASTVariableInitialization n = null;


        Token name=null;
        ASTType t =null;

        ShellCommandParser.expression_return e =null;


        try {
            // ShellCommand.g:820:5: (name= IDENT COLON t= type EQUAL e= expression )
            // ShellCommand.g:821:5: name= IDENT COLON t= type EQUAL e= expression
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_variableInitialization3087); if (state.failed) return n;

            match(input,COLON,FOLLOW_COLON_in_variableInitialization3089); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_variableInitialization3093);
            t=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,EQUAL,FOLLOW_EQUAL_in_variableInitialization3095); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_variableInitialization3099);
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
    // ShellCommand.g:830:1: ifExpression returns [ASTExpression n] : i= 'if' cond= expression 'then' t= expression 'else' e= expression 'endif' ;
    public final ASTExpression ifExpression() throws RecognitionException {
        ASTExpression n = null;


        Token i=null;
        ShellCommandParser.expression_return cond =null;

        ShellCommandParser.expression_return t =null;

        ShellCommandParser.expression_return e =null;


        try {
            // ShellCommand.g:831:5: (i= 'if' cond= expression 'then' t= expression 'else' e= expression 'endif' )
            // ShellCommand.g:832:5: i= 'if' cond= expression 'then' t= expression 'else' e= expression 'endif'
            {
            i=(Token)match(input,76,FOLLOW_76_in_ifExpression3131); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_ifExpression3135);
            cond=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,99,FOLLOW_99_in_ifExpression3137); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_ifExpression3141);
            t=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,68,FOLLOW_68_in_ifExpression3143); if (state.failed) return n;

            pushFollow(FOLLOW_expression_in_ifExpression3147);
            e=expression();

            state._fsp--;
            if (state.failed) return n;

            match(input,70,FOLLOW_70_in_ifExpression3149); if (state.failed) return n;

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
    // ShellCommand.g:851:1: literal returns [ASTExpression n] : (t= 'true' |f= 'false' |i= INT |r= REAL |s= STRING | 'UString' LPAREN usve= additiveExpression COMMA usue= additiveExpression RPAREN | 'UReal' LPAREN urve= additiveExpression COMMA urue= additiveExpression RPAREN | 'UBoolean' LPAREN ubve= conditionalImpliesExpression COMMA ubpe= additiveExpression RPAREN | 'UInteger' LPAREN uive= additiveExpression COMMA uiue= additiveExpression RPAREN | 'SBoolean' LPAREN ubve= additiveExpression COMMA udve= additiveExpression COMMA uuve= additiveExpression COMMA uave= additiveExpression RPAREN | HASH enumLit= IDENT |enumName= IDENT '::' enumLit= IDENT |nColIt= collectionLiteral |nEColIt= emptyCollectionLiteral |nUndLit= undefinedLiteral |nTupleLit= tupleLiteral |un= STAR );
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
            // ShellCommand.g:852:7: (t= 'true' |f= 'false' |i= INT |r= REAL |s= STRING | 'UString' LPAREN usve= additiveExpression COMMA usue= additiveExpression RPAREN | 'UReal' LPAREN urve= additiveExpression COMMA urue= additiveExpression RPAREN | 'UBoolean' LPAREN ubve= conditionalImpliesExpression COMMA ubpe= additiveExpression RPAREN | 'UInteger' LPAREN uive= additiveExpression COMMA uiue= additiveExpression RPAREN | 'SBoolean' LPAREN ubve= additiveExpression COMMA udve= additiveExpression COMMA uuve= additiveExpression COMMA uave= additiveExpression RPAREN | HASH enumLit= IDENT |enumName= IDENT '::' enumLit= IDENT |nColIt= collectionLiteral |nEColIt= emptyCollectionLiteral |nUndLit= undefinedLiteral |nTupleLit= tupleLiteral |un= STAR )
            int alt46=17;
            switch ( input.LA(1) ) {
            case 100:
                {
                alt46=1;
                }
                break;
            case 73:
                {
                alt46=2;
                }
                break;
            case INT:
                {
                alt46=3;
                }
                break;
            case REAL:
                {
                alt46=4;
                }
                break;
            case STRING:
                {
                alt46=5;
                }
                break;
            case 54:
                {
                alt46=6;
                }
                break;
            case 53:
                {
                alt46=7;
                }
                break;
            case 51:
                {
                alt46=8;
                }
                break;
            case 52:
                {
                alt46=9;
                }
                break;
            case 47:
                {
                alt46=10;
                }
                break;
            case HASH:
                {
                alt46=11;
                }
                break;
            case IDENT:
                {
                alt46=12;
                }
                break;
            case 44:
            case 46:
            case 48:
            case 49:
                {
                int LA46_13 = input.LA(2);

                if ( (LA46_13==LPAREN) ) {
                    alt46=14;
                }
                else if ( (LA46_13==LBRACE) ) {
                    alt46=13;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 13, input);

                    throw nvae;

                }
                }
                break;
            case 45:
            case 87:
                {
                alt46=14;
                }
                break;
            case 55:
            case 85:
            case 91:
                {
                alt46=15;
                }
                break;
            case 50:
                {
                alt46=16;
                }
                break;
            case STAR:
                {
                alt46=17;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // ShellCommand.g:853:7: t= 'true'
                    {
                    t=(Token)match(input,100,FOLLOW_100_in_literal3188); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTBooleanLiteral(true); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:854:7: f= 'false'
                    {
                    f=(Token)match(input,73,FOLLOW_73_in_literal3202); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTBooleanLiteral(false); }

                    }
                    break;
                case 3 :
                    // ShellCommand.g:855:7: i= INT
                    {
                    i=(Token)match(input,INT,FOLLOW_INT_in_literal3215); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTIntegerLiteral(i); }

                    }
                    break;
                case 4 :
                    // ShellCommand.g:856:7: r= REAL
                    {
                    r=(Token)match(input,REAL,FOLLOW_REAL_in_literal3230); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTRealLiteral(r); }

                    }
                    break;
                case 5 :
                    // ShellCommand.g:857:7: s= STRING
                    {
                    s=(Token)match(input,STRING,FOLLOW_STRING_in_literal3244); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTStringLiteral(s); }

                    }
                    break;
                case 6 :
                    // ShellCommand.g:858:7: 'UString' LPAREN usve= additiveExpression COMMA usue= additiveExpression RPAREN
                    {
                    match(input,54,FOLLOW_54_in_literal3254); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal3256); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3260);
                    usve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3262); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3266);
                    usue=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal3268); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUStringLiteral(usve,usue); }

                    }
                    break;
                case 7 :
                    // ShellCommand.g:859:7: 'UReal' LPAREN urve= additiveExpression COMMA urue= additiveExpression RPAREN
                    {
                    match(input,53,FOLLOW_53_in_literal3278); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal3280); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3284);
                    urve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3286); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3290);
                    urue=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal3292); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTURealLiteral(urve,urue); }

                    }
                    break;
                case 8 :
                    // ShellCommand.g:860:7: 'UBoolean' LPAREN ubve= conditionalImpliesExpression COMMA ubpe= additiveExpression RPAREN
                    {
                    match(input,51,FOLLOW_51_in_literal3302); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal3304); if (state.failed) return n;

                    pushFollow(FOLLOW_conditionalImpliesExpression_in_literal3308);
                    ubve=conditionalImpliesExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3310); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3314);
                    ubpe=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal3316); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUBooleanLiteral(ubve, ubpe); }

                    }
                    break;
                case 9 :
                    // ShellCommand.g:861:7: 'UInteger' LPAREN uive= additiveExpression COMMA uiue= additiveExpression RPAREN
                    {
                    match(input,52,FOLLOW_52_in_literal3326); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal3328); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3332);
                    uive=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3334); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3338);
                    uiue=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal3340); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUIntegerLiteral(uive, uiue); }

                    }
                    break;
                case 10 :
                    // ShellCommand.g:862:7: 'SBoolean' LPAREN ubve= additiveExpression COMMA udve= additiveExpression COMMA uuve= additiveExpression COMMA uave= additiveExpression RPAREN
                    {
                    match(input,47,FOLLOW_47_in_literal3350); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_literal3352); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3356);
                    ubve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3358); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3362);
                    udve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3364); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3368);
                    uuve=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,COMMA,FOLLOW_COMMA_in_literal3370); if (state.failed) return n;

                    pushFollow(FOLLOW_additiveExpression_in_literal3374);
                    uave=additiveExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_literal3376); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTSBooleanLiteral(ubve, udve, uuve, uave); }

                    }
                    break;
                case 11 :
                    // ShellCommand.g:864:7: HASH enumLit= IDENT
                    {
                    match(input,HASH,FOLLOW_HASH_in_literal3393); if (state.failed) return n;

                    enumLit=(Token)match(input,IDENT,FOLLOW_IDENT_in_literal3397); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTEnumLiteral(enumLit);}

                    }
                    break;
                case 12 :
                    // ShellCommand.g:865:7: enumName= IDENT '::' enumLit= IDENT
                    {
                    enumName=(Token)match(input,IDENT,FOLLOW_IDENT_in_literal3409); if (state.failed) return n;

                    match(input,COLON_COLON,FOLLOW_COLON_COLON_in_literal3411); if (state.failed) return n;

                    enumLit=(Token)match(input,IDENT,FOLLOW_IDENT_in_literal3415); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTEnumLiteral(enumName, enumLit); }

                    }
                    break;
                case 13 :
                    // ShellCommand.g:866:7: nColIt= collectionLiteral
                    {
                    pushFollow(FOLLOW_collectionLiteral_in_literal3427);
                    nColIt=collectionLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nColIt; }

                    }
                    break;
                case 14 :
                    // ShellCommand.g:867:7: nEColIt= emptyCollectionLiteral
                    {
                    pushFollow(FOLLOW_emptyCollectionLiteral_in_literal3439);
                    nEColIt=emptyCollectionLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nEColIt; }

                    }
                    break;
                case 15 :
                    // ShellCommand.g:868:7: nUndLit= undefinedLiteral
                    {
                    pushFollow(FOLLOW_undefinedLiteral_in_literal3451);
                    nUndLit=undefinedLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) {n = nUndLit; }

                    }
                    break;
                case 16 :
                    // ShellCommand.g:869:7: nTupleLit= tupleLiteral
                    {
                    pushFollow(FOLLOW_tupleLiteral_in_literal3463);
                    nTupleLit=tupleLiteral();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) {n = nTupleLit; }

                    }
                    break;
                case 17 :
                    // ShellCommand.g:870:7: un= STAR
                    {
                    un=(Token)match(input,STAR,FOLLOW_STAR_in_literal3475); if (state.failed) return n;

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
    // ShellCommand.g:878:1: collectionLiteral returns [ASTCollectionLiteral n] : ( 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LBRACE (ci= collectionItem ( COMMA ci= collectionItem )* )? RBRACE ;
    public final ASTCollectionLiteral collectionLiteral() throws RecognitionException {
        ASTCollectionLiteral n = null;


        ASTCollectionItem ci =null;


         Token op = null; 
        try {
            // ShellCommand.g:880:5: ( ( 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LBRACE (ci= collectionItem ( COMMA ci= collectionItem )* )? RBRACE )
            // ShellCommand.g:881:5: ( 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LBRACE (ci= collectionItem ( COMMA ci= collectionItem )* )? RBRACE
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

            match(input,LBRACE,FOLLOW_LBRACE_in_collectionLiteral3542); if (state.failed) return n;

            // ShellCommand.g:885:5: (ci= collectionItem ( COMMA ci= collectionItem )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==AT||LA48_0==HASH||(LA48_0 >= IDENT && LA48_0 <= INT)||(LA48_0 >= LPAREN && LA48_0 <= MINUS)||LA48_0==PLUS||LA48_0==REAL||(LA48_0 >= STAR && LA48_0 <= STRING)||(LA48_0 >= 44 && LA48_0 <= 55)||LA48_0==73||LA48_0==76||(LA48_0 >= 81 && LA48_0 <= 82)||(LA48_0 >= 84 && LA48_0 <= 91)||(LA48_0 >= 96 && LA48_0 <= 97)||LA48_0==100) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ShellCommand.g:886:7: ci= collectionItem ( COMMA ci= collectionItem )*
                    {
                    pushFollow(FOLLOW_collectionItem_in_collectionLiteral3559);
                    ci=collectionItem();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n.addItem(ci); }

                    // ShellCommand.g:887:7: ( COMMA ci= collectionItem )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==COMMA) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ShellCommand.g:887:9: COMMA ci= collectionItem
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_collectionLiteral3572); if (state.failed) return n;

                    	    pushFollow(FOLLOW_collectionItem_in_collectionLiteral3576);
                    	    ci=collectionItem();

                    	    state._fsp--;
                    	    if (state.failed) return n;

                    	    if ( state.backtracking==0 ) { n.addItem(ci); }

                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_collectionLiteral3595); if (state.failed) return n;

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
    // ShellCommand.g:896:1: collectionItem returns [ASTCollectionItem n] : e= expression ( DOTDOT e= expression )? ;
    public final ASTCollectionItem collectionItem() throws RecognitionException {
        ASTCollectionItem n = null;


        ShellCommandParser.expression_return e =null;


         n = new ASTCollectionItem(); 
        try {
            // ShellCommand.g:898:5: (e= expression ( DOTDOT e= expression )? )
            // ShellCommand.g:899:5: e= expression ( DOTDOT e= expression )?
            {
            pushFollow(FOLLOW_expression_in_collectionItem3624);
            e=expression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.setFirst((e!=null?e.n:null)); }

            // ShellCommand.g:900:5: ( DOTDOT e= expression )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==DOTDOT) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ShellCommand.g:900:7: DOTDOT e= expression
                    {
                    match(input,DOTDOT,FOLLOW_DOTDOT_in_collectionItem3635); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_collectionItem3639);
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
    // ShellCommand.g:910:1: emptyCollectionLiteral returns [ASTEmptyCollectionLiteral n] : ( 'oclEmpty' LPAREN t= collectionType RPAREN |t= collectionType LBRACE RBRACE );
    public final ASTEmptyCollectionLiteral emptyCollectionLiteral() throws RecognitionException {
        ASTEmptyCollectionLiteral n = null;


        ASTCollectionType t =null;


        try {
            // ShellCommand.g:911:5: ( 'oclEmpty' LPAREN t= collectionType RPAREN |t= collectionType LBRACE RBRACE )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==87) ) {
                alt50=1;
            }
            else if ( ((LA50_0 >= 44 && LA50_0 <= 46)||(LA50_0 >= 48 && LA50_0 <= 49)) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }
            switch (alt50) {
                case 1 :
                    // ShellCommand.g:912:5: 'oclEmpty' LPAREN t= collectionType RPAREN
                    {
                    match(input,87,FOLLOW_87_in_emptyCollectionLiteral3668); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_emptyCollectionLiteral3670); if (state.failed) return n;

                    pushFollow(FOLLOW_collectionType_in_emptyCollectionLiteral3674);
                    t=collectionType();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_emptyCollectionLiteral3676); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTEmptyCollectionLiteral(t); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:915:5: t= collectionType LBRACE RBRACE
                    {
                    pushFollow(FOLLOW_collectionType_in_emptyCollectionLiteral3692);
                    t=collectionType();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,LBRACE,FOLLOW_LBRACE_in_emptyCollectionLiteral3694); if (state.failed) return n;

                    match(input,RBRACE,FOLLOW_RBRACE_in_emptyCollectionLiteral3696); if (state.failed) return n;

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
    // ShellCommand.g:926:1: undefinedLiteral returns [ASTUndefinedLiteral n] : ( 'oclUndefined' LPAREN t= type RPAREN | 'Undefined' | 'null' LPAREN t= type RPAREN | 'null' );
    public final ASTUndefinedLiteral undefinedLiteral() throws RecognitionException {
        ASTUndefinedLiteral n = null;


        ASTType t =null;


        try {
            // ShellCommand.g:927:5: ( 'oclUndefined' LPAREN t= type RPAREN | 'Undefined' | 'null' LPAREN t= type RPAREN | 'null' )
            int alt51=4;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt51=1;
                }
                break;
            case 55:
                {
                alt51=2;
                }
                break;
            case 85:
                {
                int LA51_3 = input.LA(2);

                if ( (LA51_3==LPAREN) ) {
                    alt51=3;
                }
                else if ( (LA51_3==EOF||LA51_3==ARROW||LA51_3==BAR||(LA51_3 >= COMMA && LA51_3 <= EQUAL)||(LA51_3 >= GREATER && LA51_3 <= GREATER_EQUAL)||LA51_3==IDENT||LA51_3==LBRACE||(LA51_3 >= LESS && LA51_3 <= LESS_EQUAL)||LA51_3==MINUS||(LA51_3 >= NOT_EQUAL && LA51_3 <= PLUS)||(LA51_3 >= RBRACE && LA51_3 <= RBRACK)||(LA51_3 >= RPAREN && LA51_3 <= SLASH)||LA51_3==STAR||(LA51_3 >= 57 && LA51_3 <= 58)||LA51_3==62||(LA51_3 >= 64 && LA51_3 <= 70)||LA51_3==72||(LA51_3 >= 77 && LA51_3 <= 79)||LA51_3==82||LA51_3==94||(LA51_3 >= 98 && LA51_3 <= 99)||LA51_3==102) ) {
                    alt51=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }

            switch (alt51) {
                case 1 :
                    // ShellCommand.g:928:5: 'oclUndefined' LPAREN t= type RPAREN
                    {
                    match(input,91,FOLLOW_91_in_undefinedLiteral3726); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_undefinedLiteral3728); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_undefinedLiteral3732);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_undefinedLiteral3734); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUndefinedLiteral(t); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:931:5: 'Undefined'
                    {
                    match(input,55,FOLLOW_55_in_undefinedLiteral3748); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUndefinedLiteral(); }

                    }
                    break;
                case 3 :
                    // ShellCommand.g:934:5: 'null' LPAREN t= type RPAREN
                    {
                    match(input,85,FOLLOW_85_in_undefinedLiteral3762); if (state.failed) return n;

                    match(input,LPAREN,FOLLOW_LPAREN_in_undefinedLiteral3764); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_undefinedLiteral3768);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,RPAREN,FOLLOW_RPAREN_in_undefinedLiteral3770); if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTUndefinedLiteral(t); }

                    }
                    break;
                case 4 :
                    // ShellCommand.g:937:5: 'null'
                    {
                    match(input,85,FOLLOW_85_in_undefinedLiteral3784); if (state.failed) return n;

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
    // ShellCommand.g:947:1: tupleLiteral returns [ASTTupleLiteral n] : 'Tuple' LBRACE ti= tupleItem ( COMMA ti= tupleItem )* RBRACE ;
    public final ASTTupleLiteral tupleLiteral() throws RecognitionException {
        ASTTupleLiteral n = null;


        ASTTupleItem ti =null;


         List tiList = new ArrayList(); 
        try {
            // ShellCommand.g:949:5: ( 'Tuple' LBRACE ti= tupleItem ( COMMA ti= tupleItem )* RBRACE )
            // ShellCommand.g:950:5: 'Tuple' LBRACE ti= tupleItem ( COMMA ti= tupleItem )* RBRACE
            {
            match(input,50,FOLLOW_50_in_tupleLiteral3823); if (state.failed) return n;

            match(input,LBRACE,FOLLOW_LBRACE_in_tupleLiteral3829); if (state.failed) return n;

            pushFollow(FOLLOW_tupleItem_in_tupleLiteral3837);
            ti=tupleItem();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { tiList.add(ti); }

            // ShellCommand.g:953:5: ( COMMA ti= tupleItem )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==COMMA) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ShellCommand.g:953:7: COMMA ti= tupleItem
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_tupleLiteral3848); if (state.failed) return n;

            	    pushFollow(FOLLOW_tupleItem_in_tupleLiteral3852);
            	    ti=tupleItem();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { tiList.add(ti); }

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_tupleLiteral3863); if (state.failed) return n;

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
    // ShellCommand.g:961:1: tupleItem returns [ASTTupleItem n] : name= IDENT ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression ) ;
    public final ASTTupleItem tupleItem() throws RecognitionException {
        ASTTupleItem n = null;


        Token name=null;
        ASTType t =null;

        ShellCommandParser.expression_return e =null;


        try {
            // ShellCommand.g:962:5: (name= IDENT ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression ) )
            // ShellCommand.g:963:5: name= IDENT ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression )
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_tupleItem3894); if (state.failed) return n;

            // ShellCommand.g:964:5: ( ( COLON type EQUAL )=> COLON t= type EQUAL e= expression | ( COLON | EQUAL ) e= expression )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==COLON) ) {
                int LA53_1 = input.LA(2);

                if ( (synpred6_ShellCommand()) ) {
                    alt53=1;
                }
                else if ( (true) ) {
                    alt53=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA53_0==EQUAL) ) {
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
                    // ShellCommand.g:967:7: ( COLON type EQUAL )=> COLON t= type EQUAL e= expression
                    {
                    match(input,COLON,FOLLOW_COLON_in_tupleItem3933); if (state.failed) return n;

                    pushFollow(FOLLOW_type_in_tupleItem3937);
                    t=type();

                    state._fsp--;
                    if (state.failed) return n;

                    match(input,EQUAL,FOLLOW_EQUAL_in_tupleItem3939); if (state.failed) return n;

                    pushFollow(FOLLOW_expression_in_tupleItem3943);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTTupleItem(name, t, (e!=null?e.n:null)); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:970:7: ( COLON | EQUAL ) e= expression
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


                    pushFollow(FOLLOW_expression_in_tupleItem3975);
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
    // ShellCommand.g:982:1: type returns [ASTType n] : (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType ) ;
    public final ASTType type() throws RecognitionException {
        ASTType n = null;


        ASTSimpleType nTSimple =null;

        ASTCollectionType nTCollection =null;

        ASTTupleType nTTuple =null;

        ASTType nTUncertainty =null;


         Token tok = null; 
        try {
            // ShellCommand.g:984:5: ( (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType ) )
            // ShellCommand.g:985:5: (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType )
            {
            if ( state.backtracking==0 ) { tok = input.LT(1); /* remember start of type */ }

            // ShellCommand.g:986:5: (nTSimple= simpleType |nTCollection= collectionType |nTTuple= tupleType |nTUncertainty= uncertaintyType )
            int alt54=4;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt54=1;
                }
                break;
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
                {
                alt54=2;
                }
                break;
            case 50:
                {
                alt54=3;
                }
                break;
            case 47:
            case 51:
            case 52:
            case 53:
            case 54:
                {
                alt54=4;
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
                    // ShellCommand.g:987:7: nTSimple= simpleType
                    {
                    pushFollow(FOLLOW_simpleType_in_type4041);
                    nTSimple=simpleType();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nTSimple; if (n != null) n.setStartToken(tok); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:988:7: nTCollection= collectionType
                    {
                    pushFollow(FOLLOW_collectionType_in_type4053);
                    nTCollection=collectionType();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nTCollection; if (n != null) n.setStartToken(tok); }

                    }
                    break;
                case 3 :
                    // ShellCommand.g:989:7: nTTuple= tupleType
                    {
                    pushFollow(FOLLOW_tupleType_in_type4065);
                    nTTuple=tupleType();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = nTTuple; if (n != null) n.setStartToken(tok); }

                    }
                    break;
                case 4 :
                    // ShellCommand.g:990:7: nTUncertainty= uncertaintyType
                    {
                    pushFollow(FOLLOW_uncertaintyType_in_type4077);
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
    // ShellCommand.g:994:1: uncertaintyType returns [ASTType n] : name= ( 'UReal' | 'UInteger' | 'UBoolean' | 'UString' | 'SBoolean' ) ;
    public final ASTType uncertaintyType() throws RecognitionException {
        ASTType n = null;


        Token name=null;

        try {
            // ShellCommand.g:995:5: (name= ( 'UReal' | 'UInteger' | 'UBoolean' | 'UString' | 'SBoolean' ) )
            // ShellCommand.g:996:5: name= ( 'UReal' | 'UInteger' | 'UBoolean' | 'UString' | 'SBoolean' )
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
    // ShellCommand.g:1000:1: typeOnly returns [ASTType n] : nT= type EOF ;
    public final ASTType typeOnly() throws RecognitionException {
        ASTType n = null;


        ASTType nT =null;


        try {
            // ShellCommand.g:1001:5: (nT= type EOF )
            // ShellCommand.g:1002:5: nT= type EOF
            {
            pushFollow(FOLLOW_type_in_typeOnly4146);
            nT=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,EOF,FOLLOW_EOF_in_typeOnly4148); if (state.failed) return n;

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
    // ShellCommand.g:1012:1: simpleType returns [ASTSimpleType n] : name= IDENT ;
    public final ASTSimpleType simpleType() throws RecognitionException {
        ASTSimpleType n = null;


        Token name=null;

        try {
            // ShellCommand.g:1013:5: (name= IDENT )
            // ShellCommand.g:1014:5: name= IDENT
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_simpleType4176); if (state.failed) return n;

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
    // ShellCommand.g:1022:1: collectionType returns [ASTCollectionType n] : ( 'Collection' | 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LPAREN elemType= type RPAREN ;
    public final ASTCollectionType collectionType() throws RecognitionException {
        ASTCollectionType n = null;


        ASTType elemType =null;


         Token op = null; 
        try {
            // ShellCommand.g:1024:5: ( ( 'Collection' | 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LPAREN elemType= type RPAREN )
            // ShellCommand.g:1025:5: ( 'Collection' | 'Set' | 'Sequence' | 'Bag' | 'OrderedSet' ) LPAREN elemType= type RPAREN
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


            match(input,LPAREN,FOLLOW_LPAREN_in_collectionType4241); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_collectionType4245);
            elemType=type();

            state._fsp--;
            if (state.failed) return n;

            match(input,RPAREN,FOLLOW_RPAREN_in_collectionType4247); if (state.failed) return n;

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
    // ShellCommand.g:1035:1: tupleType returns [ASTTupleType n] : 'Tuple' LPAREN tp= tuplePart ( COMMA tp= tuplePart )* RPAREN ;
    public final ASTTupleType tupleType() throws RecognitionException {
        ASTTupleType n = null;


        ASTTuplePart tp =null;


         List tpList = new ArrayList(); 
        try {
            // ShellCommand.g:1037:5: ( 'Tuple' LPAREN tp= tuplePart ( COMMA tp= tuplePart )* RPAREN )
            // ShellCommand.g:1038:5: 'Tuple' LPAREN tp= tuplePart ( COMMA tp= tuplePart )* RPAREN
            {
            match(input,50,FOLLOW_50_in_tupleType4281); if (state.failed) return n;

            match(input,LPAREN,FOLLOW_LPAREN_in_tupleType4283); if (state.failed) return n;

            pushFollow(FOLLOW_tuplePart_in_tupleType4292);
            tp=tuplePart();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { tpList.add(tp); }

            // ShellCommand.g:1040:5: ( COMMA tp= tuplePart )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==COMMA) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ShellCommand.g:1040:7: COMMA tp= tuplePart
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_tupleType4303); if (state.failed) return n;

            	    pushFollow(FOLLOW_tuplePart_in_tupleType4307);
            	    tp=tuplePart();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { tpList.add(tp); }

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            match(input,RPAREN,FOLLOW_RPAREN_in_tupleType4319); if (state.failed) return n;

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
    // ShellCommand.g:1049:1: tuplePart returns [ASTTuplePart n] : name= IDENT COLON t= type ;
    public final ASTTuplePart tuplePart() throws RecognitionException {
        ASTTuplePart n = null;


        Token name=null;
        ASTType t =null;


        try {
            // ShellCommand.g:1050:5: (name= IDENT COLON t= type )
            // ShellCommand.g:1051:5: name= IDENT COLON t= type
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_tuplePart4351); if (state.failed) return n;

            match(input,COLON,FOLLOW_COLON_in_tuplePart4353); if (state.failed) return n;

            pushFollow(FOLLOW_type_in_tuplePart4357);
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



    // $ANTLR start "statOnly"
    // ShellCommand.g:1090:1: statOnly returns [ASTStatement n] : s= stat EOF ;
    public final ASTStatement statOnly() throws RecognitionException {
        ASTStatement n = null;


        ShellCommandParser.stat_return s =null;


        try {
            // ShellCommand.g:1091:3: (s= stat EOF )
            // ShellCommand.g:1092:3: s= stat EOF
            {
            pushFollow(FOLLOW_stat_in_statOnly4406);
            s=stat();

            state._fsp--;
            if (state.failed) return n;

            match(input,EOF,FOLLOW_EOF_in_statOnly4410); if (state.failed) return n;

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
    // ShellCommand.g:1102:1: stat returns [ASTStatement n] : s= singleStat ( SEMI s2= singleStat )* ;
    public final ShellCommandParser.stat_return stat() throws RecognitionException {
        ShellCommandParser.stat_return retval = new ShellCommandParser.stat_return();
        retval.start = input.LT(1);


        ASTStatement s =null;

        ASTStatement s2 =null;



          ASTSequenceStatement seq = new ASTSequenceStatement(((Token)retval.start));

        try {
            // ShellCommand.g:1106:3: (s= singleStat ( SEMI s2= singleStat )* )
            // ShellCommand.g:1107:3: s= singleStat ( SEMI s2= singleStat )*
            {
            pushFollow(FOLLOW_singleStat_in_stat4445);
            s=singleStat();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {seq.addStatement(s);}

            // ShellCommand.g:1108:3: ( SEMI s2= singleStat )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==SEMI) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ShellCommand.g:1109:5: SEMI s2= singleStat
            	    {
            	    match(input,SEMI,FOLLOW_SEMI_in_stat4457); if (state.failed) return retval;

            	    pushFollow(FOLLOW_singleStat_in_stat4467);
            	    s2=singleStat();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {seq.addStatement(s2); }

            	    }
            	    break;

            	default :
            	    break loop56;
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
    // ShellCommand.g:1121:1: singleStat returns [ASTStatement n] : (emp= emptyStat | ( statStartingWithExpr )=>sse= statStartingWithExpr |vas= varAssignStat |ocs= objCreateStat |ods= objDestroyStat |lis= lnkInsStat |lds= lnkDelStat |ces= condExStat |its= iterStat |whs= whileStat |blk= blockStat );
    public final ASTStatement singleStat() throws RecognitionException {
        ASTStatement n = null;


        ASTEmptyStatement emp =null;

        ShellCommandParser.statStartingWithExpr_return sse =null;

        ASTStatement vas =null;

        ShellCommandParser.objCreateStat_return ocs =null;

        ShellCommandParser.objDestroyStat_return ods =null;

        ShellCommandParser.lnkInsStat_return lis =null;

        ShellCommandParser.lnkDelStat_return lds =null;

        ShellCommandParser.condExStat_return ces =null;

        ShellCommandParser.iterStat_return its =null;

        ShellCommandParser.whileStat_return whs =null;

        ShellCommandParser.blockStat_return blk =null;


        try {
            // ShellCommand.g:1122:5: (emp= emptyStat | ( statStartingWithExpr )=>sse= statStartingWithExpr |vas= varAssignStat |ocs= objCreateStat |ods= objDestroyStat |lis= lnkInsStat |lds= lnkDelStat |ces= condExStat |its= iterStat |whs= whileStat |blk= blockStat )
            int alt57=11;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==EOF||LA57_0==SEMI||(LA57_0 >= 68 && LA57_0 <= 69)) ) {
                alt57=1;
            }
            else if ( (LA57_0==82) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==MINUS||LA57_0==PLUS||LA57_0==84) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==100) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==73) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==INT) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==REAL) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==STRING) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==54) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==53) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==51) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==52) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==47) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==HASH) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==IDENT) ) {
                int LA57_18 = input.LA(2);

                if ( (synpred7_ShellCommand()) ) {
                    alt57=2;
                }
                else if ( (true) ) {
                    alt57=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 18, input);

                    throw nvae;

                }
            }
            else if ( (LA57_0==44||LA57_0==46||(LA57_0 >= 48 && LA57_0 <= 49)) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==87) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==45) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==91) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==55) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==85) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==50) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==STAR) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==AT) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==81) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==86||(LA57_0 >= 89 && LA57_0 <= 90)||(LA57_0 >= 96 && LA57_0 <= 97)) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==88) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==LPAREN) && (synpred7_ShellCommand())) {
                alt57=2;
            }
            else if ( (LA57_0==76) ) {
                int LA57_32 = input.LA(2);

                if ( (synpred7_ShellCommand()) ) {
                    alt57=2;
                }
                else if ( (true) ) {
                    alt57=8;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return n;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 32, input);

                    throw nvae;

                }
            }
            else if ( (LA57_0==83) ) {
                alt57=4;
            }
            else if ( (LA57_0==65) ) {
                alt57=5;
            }
            else if ( (LA57_0==79) ) {
                alt57=6;
            }
            else if ( (LA57_0==64) ) {
                alt57=7;
            }
            else if ( (LA57_0==74) ) {
                alt57=9;
            }
            else if ( (LA57_0==101) ) {
                alt57=10;
            }
            else if ( (LA57_0==59) ) {
                alt57=11;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }
            switch (alt57) {
                case 1 :
                    // ShellCommand.g:1123:5: emp= emptyStat
                    {
                    pushFollow(FOLLOW_emptyStat_in_singleStat4507);
                    emp=emptyStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = emp; }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:1125:5: ( statStartingWithExpr )=>sse= statStartingWithExpr
                    {
                    pushFollow(FOLLOW_statStartingWithExpr_in_singleStat4533);
                    sse=statStartingWithExpr();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (sse!=null?sse.n:null); }

                    }
                    break;
                case 3 :
                    // ShellCommand.g:1126:5: vas= varAssignStat
                    {
                    pushFollow(FOLLOW_varAssignStat_in_singleStat4545);
                    vas=varAssignStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = vas; }

                    }
                    break;
                case 4 :
                    // ShellCommand.g:1127:5: ocs= objCreateStat
                    {
                    pushFollow(FOLLOW_objCreateStat_in_singleStat4559);
                    ocs=objCreateStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (ocs!=null?ocs.n:null); }

                    }
                    break;
                case 5 :
                    // ShellCommand.g:1128:5: ods= objDestroyStat
                    {
                    pushFollow(FOLLOW_objDestroyStat_in_singleStat4573);
                    ods=objDestroyStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (ods!=null?ods.n:null); }

                    }
                    break;
                case 6 :
                    // ShellCommand.g:1129:5: lis= lnkInsStat
                    {
                    pushFollow(FOLLOW_lnkInsStat_in_singleStat4586);
                    lis=lnkInsStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lis!=null?lis.n:null); }

                    }
                    break;
                case 7 :
                    // ShellCommand.g:1130:5: lds= lnkDelStat
                    {
                    pushFollow(FOLLOW_lnkDelStat_in_singleStat4603);
                    lds=lnkDelStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (lds!=null?lds.n:null); }

                    }
                    break;
                case 8 :
                    // ShellCommand.g:1131:5: ces= condExStat
                    {
                    pushFollow(FOLLOW_condExStat_in_singleStat4620);
                    ces=condExStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (ces!=null?ces.n:null); }

                    }
                    break;
                case 9 :
                    // ShellCommand.g:1132:5: its= iterStat
                    {
                    pushFollow(FOLLOW_iterStat_in_singleStat4637);
                    its=iterStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (its!=null?its.n:null); }

                    }
                    break;
                case 10 :
                    // ShellCommand.g:1134:5: whs= whileStat
                    {
                    pushFollow(FOLLOW_whileStat_in_singleStat4659);
                    whs=whileStat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (whs!=null?whs.n:null); }

                    }
                    break;
                case 11 :
                    // ShellCommand.g:1135:5: blk= blockStat
                    {
                    pushFollow(FOLLOW_blockStat_in_singleStat4677);
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
    // ShellCommand.g:1142:1: emptyStat returns [ASTEmptyStatement n] : nothing ;
    public final ASTEmptyStatement emptyStat() throws RecognitionException {
        ASTEmptyStatement n = null;


        try {
            // ShellCommand.g:1143:3: ( nothing )
            // ShellCommand.g:1144:3: nothing
            {
            pushFollow(FOLLOW_nothing_in_emptyStat4704);
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
    // ShellCommand.g:1149:1: statStartingWithExpr returns [ASTStatement n] : expr= inSoilExpression (aas= attAssignStat[$expr.n] )? ;
    public final ShellCommandParser.statStartingWithExpr_return statStartingWithExpr() throws RecognitionException {
        ShellCommandParser.statStartingWithExpr_return retval = new ShellCommandParser.statStartingWithExpr_return();
        retval.start = input.LT(1);


        ASTExpression expr =null;

        ASTAttributeAssignmentStatement aas =null;


        try {
            // ShellCommand.g:1150:3: (expr= inSoilExpression (aas= attAssignStat[$expr.n] )? )
            // ShellCommand.g:1151:3: expr= inSoilExpression (aas= attAssignStat[$expr.n] )?
            {
            pushFollow(FOLLOW_inSoilExpression_in_statStartingWithExpr4730);
            expr=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            // ShellCommand.g:1152:3: (aas= attAssignStat[$expr.n] )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==DOT) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ShellCommand.g:1153:5: aas= attAssignStat[$expr.n]
                    {
                    pushFollow(FOLLOW_attAssignStat_in_statStartingWithExpr4744);
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
    // ShellCommand.g:1165:1: varAssignStat returns [ASTStatement n] : varName= IDENT COLON_EQUAL rVal= rValue ;
    public final ASTStatement varAssignStat() throws RecognitionException {
        ASTStatement n = null;


        Token varName=null;
        ASTRValue rVal =null;


        try {
            // ShellCommand.g:1166:3: (varName= IDENT COLON_EQUAL rVal= rValue )
            // ShellCommand.g:1167:3: varName= IDENT COLON_EQUAL rVal= rValue
            {
            varName=(Token)match(input,IDENT,FOLLOW_IDENT_in_varAssignStat4782); if (state.failed) return n;

            match(input,COLON_EQUAL,FOLLOW_COLON_EQUAL_in_varAssignStat4786); if (state.failed) return n;

            pushFollow(FOLLOW_rValue_in_varAssignStat4794);
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
    // ShellCommand.g:1179:1: attAssignStat[ASTExpression exp] returns [ASTAttributeAssignmentStatement n] : DOT attName= IDENT COLON_EQUAL r= rValue ;
    public final ASTAttributeAssignmentStatement attAssignStat(ASTExpression exp) throws RecognitionException {
        ASTAttributeAssignmentStatement n = null;


        Token attName=null;
        ASTRValue r =null;


        try {
            // ShellCommand.g:1180:3: ( DOT attName= IDENT COLON_EQUAL r= rValue )
            // ShellCommand.g:1181:3: DOT attName= IDENT COLON_EQUAL r= rValue
            {
            match(input,DOT,FOLLOW_DOT_in_attAssignStat4818); if (state.failed) return n;

            attName=(Token)match(input,IDENT,FOLLOW_IDENT_in_attAssignStat4827); if (state.failed) return n;

            match(input,COLON_EQUAL,FOLLOW_COLON_EQUAL_in_attAssignStat4831); if (state.failed) return n;

            pushFollow(FOLLOW_rValue_in_attAssignStat4839);
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
    // ShellCommand.g:1193:1: objCreateStat returns [ASTStatement n] : 'new' ident= simpleType ( LPAREN (objName= inSoilExpression )? RPAREN )? ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )? ;
    public final ShellCommandParser.objCreateStat_return objCreateStat() throws RecognitionException {
        ShellCommandParser.objCreateStat_return retval = new ShellCommandParser.objCreateStat_return();
        retval.start = input.LT(1);


        ASTSimpleType ident =null;

        ASTExpression objName =null;

        ShellCommandParser.rValListMin2WithOptionalQualifiers_return p =null;


        try {
            // ShellCommand.g:1194:3: ( 'new' ident= simpleType ( LPAREN (objName= inSoilExpression )? RPAREN )? ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )? )
            // ShellCommand.g:1195:3: 'new' ident= simpleType ( LPAREN (objName= inSoilExpression )? RPAREN )? ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )?
            {
            match(input,83,FOLLOW_83_in_objCreateStat4865); if (state.failed) return retval;

            pushFollow(FOLLOW_simpleType_in_objCreateStat4873);
            ident=simpleType();

            state._fsp--;
            if (state.failed) return retval;

            // ShellCommand.g:1197:3: ( LPAREN (objName= inSoilExpression )? RPAREN )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==LPAREN) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ShellCommand.g:1198:5: LPAREN (objName= inSoilExpression )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_objCreateStat4883); if (state.failed) return retval;

                    // ShellCommand.g:1199:7: (objName= inSoilExpression )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==AT||LA59_0==HASH||(LA59_0 >= IDENT && LA59_0 <= INT)||(LA59_0 >= LPAREN && LA59_0 <= MINUS)||LA59_0==PLUS||LA59_0==REAL||(LA59_0 >= STAR && LA59_0 <= STRING)||(LA59_0 >= 44 && LA59_0 <= 55)||LA59_0==73||LA59_0==76||(LA59_0 >= 81 && LA59_0 <= 82)||(LA59_0 >= 84 && LA59_0 <= 91)||(LA59_0 >= 96 && LA59_0 <= 97)||LA59_0==100) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // ShellCommand.g:1199:8: objName= inSoilExpression
                            {
                            pushFollow(FOLLOW_inSoilExpression_in_objCreateStat4896);
                            objName=inSoilExpression();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_objCreateStat4904); if (state.failed) return retval;

                    }
                    break;

            }


            // ShellCommand.g:1203:3: ( 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==60) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ShellCommand.g:1204:5: 'between' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN
                    {
                    match(input,60,FOLLOW_60_in_objCreateStat4922); if (state.failed) return retval;

                    match(input,LPAREN,FOLLOW_LPAREN_in_objCreateStat4930); if (state.failed) return retval;

                    pushFollow(FOLLOW_rValListMin2WithOptionalQualifiers_in_objCreateStat4944);
                    p=rValListMin2WithOptionalQualifiers();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,RPAREN,FOLLOW_RPAREN_in_objCreateStat4952); if (state.failed) return retval;

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
    // ShellCommand.g:1223:1: objDestroyStat returns [ASTStatement n] : 'destroy' el= exprListMin1 ;
    public final ShellCommandParser.objDestroyStat_return objDestroyStat() throws RecognitionException {
        ShellCommandParser.objDestroyStat_return retval = new ShellCommandParser.objDestroyStat_return();
        retval.start = input.LT(1);


        List<ASTExpression> el =null;


        try {
            // ShellCommand.g:1224:3: ( 'destroy' el= exprListMin1 )
            // ShellCommand.g:1225:3: 'destroy' el= exprListMin1
            {
            match(input,65,FOLLOW_65_in_objDestroyStat4988); if (state.failed) return retval;

            pushFollow(FOLLOW_exprListMin1_in_objDestroyStat4996);
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
    // ShellCommand.g:1244:1: lnkInsStat returns [ASTLinkInsertionStatement n] : 'insert' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'into' ass= IDENT ;
    public final ShellCommandParser.lnkInsStat_return lnkInsStat() throws RecognitionException {
        ShellCommandParser.lnkInsStat_return retval = new ShellCommandParser.lnkInsStat_return();
        retval.start = input.LT(1);


        Token ass=null;
        ShellCommandParser.rValListMin2WithOptionalQualifiers_return p =null;


        try {
            // ShellCommand.g:1245:3: ( 'insert' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'into' ass= IDENT )
            // ShellCommand.g:1246:3: 'insert' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'into' ass= IDENT
            {
            match(input,79,FOLLOW_79_in_lnkInsStat5022); if (state.failed) return retval;

            match(input,LPAREN,FOLLOW_LPAREN_in_lnkInsStat5026); if (state.failed) return retval;

            pushFollow(FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkInsStat5036);
            p=rValListMin2WithOptionalQualifiers();

            state._fsp--;
            if (state.failed) return retval;

            match(input,RPAREN,FOLLOW_RPAREN_in_lnkInsStat5040); if (state.failed) return retval;

            match(input,80,FOLLOW_80_in_lnkInsStat5044); if (state.failed) return retval;

            ass=(Token)match(input,IDENT,FOLLOW_IDENT_in_lnkInsStat5052); if (state.failed) return retval;

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
    // ShellCommand.g:1256:1: rValListMin2WithOptionalQualifiers returns [List<ASTRValue> participans, List<List<ASTRValue>> qualifiers] : r= rValue ( LBRACE qualifierValues= rValList RBRACE )? COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )* ;
    public final ShellCommandParser.rValListMin2WithOptionalQualifiers_return rValListMin2WithOptionalQualifiers() throws RecognitionException {
        ShellCommandParser.rValListMin2WithOptionalQualifiers_return retval = new ShellCommandParser.rValListMin2WithOptionalQualifiers_return();
        retval.start = input.LT(1);


        ASTRValue r =null;

        List<ASTRValue> qualifierValues =null;



          retval.participans = new ArrayList<ASTRValue>();
          retval.qualifiers = new ArrayList<List<ASTRValue>>();
          List<ASTRValue> currentQualifiers = Collections.emptyList();

        try {
            // ShellCommand.g:1262:3: (r= rValue ( LBRACE qualifierValues= rValList RBRACE )? COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )* )
            // ShellCommand.g:1263:3: r= rValue ( LBRACE qualifierValues= rValList RBRACE )? COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )*
            {
            pushFollow(FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5081);
            r=rValue();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.participans.add(r); }

            // ShellCommand.g:1264:3: ( LBRACE qualifierValues= rValList RBRACE )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==LBRACE) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ShellCommand.g:1265:4: LBRACE qualifierValues= rValList RBRACE
                    {
                    match(input,LBRACE,FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5092); if (state.failed) return retval;

                    pushFollow(FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5101);
                    qualifierValues=rValList();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {currentQualifiers = qualifierValues;}

                    match(input,RBRACE,FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5108); if (state.failed) return retval;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                retval.qualifiers.add(currentQualifiers);
                currentQualifiers = Collections.emptyList();
              }

            match(input,COMMA,FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers5124); if (state.failed) return retval;

            pushFollow(FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5135);
            r=rValue();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.participans.add(r); }

            // ShellCommand.g:1277:3: ( LBRACE qualifierValues= rValList RBRACE )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==LBRACE) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ShellCommand.g:1278:4: LBRACE qualifierValues= rValList RBRACE
                    {
                    match(input,LBRACE,FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5146); if (state.failed) return retval;

                    pushFollow(FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5155);
                    qualifierValues=rValList();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {currentQualifiers = qualifierValues;}

                    match(input,RBRACE,FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5162); if (state.failed) return retval;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                retval.qualifiers.add(currentQualifiers);
                currentQualifiers = Collections.emptyList();
              }

            // ShellCommand.g:1287:3: ( COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )? )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==COMMA) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // ShellCommand.g:1288:5: COMMA r= rValue ( LBRACE qualifierValues= rValList RBRACE )?
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers5184); if (state.failed) return retval;

            	    pushFollow(FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5199);
            	    r=rValue();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { retval.participans.add(r); }

            	    // ShellCommand.g:1292:5: ( LBRACE qualifierValues= rValList RBRACE )?
            	    int alt64=2;
            	    int LA64_0 = input.LA(1);

            	    if ( (LA64_0==LBRACE) ) {
            	        alt64=1;
            	    }
            	    switch (alt64) {
            	        case 1 :
            	            // ShellCommand.g:1293:6: LBRACE qualifierValues= rValList RBRACE
            	            {
            	            match(input,LBRACE,FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5219); if (state.failed) return retval;

            	            pushFollow(FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5230);
            	            qualifierValues=rValList();

            	            state._fsp--;
            	            if (state.failed) return retval;

            	            if ( state.backtracking==0 ) {currentQualifiers = qualifierValues;}

            	            match(input,RBRACE,FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5239); if (state.failed) return retval;

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
            	    break loop65;
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
    // ShellCommand.g:1308:1: lnkDelStat returns [ASTLinkDeletionStatement n] : 'delete' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'from' ass= IDENT ;
    public final ShellCommandParser.lnkDelStat_return lnkDelStat() throws RecognitionException {
        ShellCommandParser.lnkDelStat_return retval = new ShellCommandParser.lnkDelStat_return();
        retval.start = input.LT(1);


        Token ass=null;
        ShellCommandParser.rValListMin2WithOptionalQualifiers_return p =null;


        try {
            // ShellCommand.g:1309:3: ( 'delete' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'from' ass= IDENT )
            // ShellCommand.g:1310:3: 'delete' LPAREN p= rValListMin2WithOptionalQualifiers RPAREN 'from' ass= IDENT
            {
            match(input,64,FOLLOW_64_in_lnkDelStat5280); if (state.failed) return retval;

            match(input,LPAREN,FOLLOW_LPAREN_in_lnkDelStat5284); if (state.failed) return retval;

            pushFollow(FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkDelStat5294);
            p=rValListMin2WithOptionalQualifiers();

            state._fsp--;
            if (state.failed) return retval;

            match(input,RPAREN,FOLLOW_RPAREN_in_lnkDelStat5298); if (state.failed) return retval;

            match(input,75,FOLLOW_75_in_lnkDelStat5302); if (state.failed) return retval;

            ass=(Token)match(input,IDENT,FOLLOW_IDENT_in_lnkDelStat5311); if (state.failed) return retval;

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
    // ShellCommand.g:1324:1: condExStat returns [ASTConditionalExecutionStatement n] : 'if' con= inSoilExpression 'then' ts= statOrImplicitBlock ( 'else' es= statOrImplicitBlock )? 'end' ;
    public final ShellCommandParser.condExStat_return condExStat() throws RecognitionException {
        ShellCommandParser.condExStat_return retval = new ShellCommandParser.condExStat_return();
        retval.start = input.LT(1);


        ASTExpression con =null;

        ASTStatement ts =null;

        ASTStatement es =null;



          ASTStatement elseStat = new ASTEmptyStatement();

        try {
            // ShellCommand.g:1328:3: ( 'if' con= inSoilExpression 'then' ts= statOrImplicitBlock ( 'else' es= statOrImplicitBlock )? 'end' )
            // ShellCommand.g:1329:3: 'if' con= inSoilExpression 'then' ts= statOrImplicitBlock ( 'else' es= statOrImplicitBlock )? 'end'
            {
            match(input,76,FOLLOW_76_in_condExStat5342); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_condExStat5351);
            con=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            match(input,99,FOLLOW_99_in_condExStat5355); if (state.failed) return retval;

            pushFollow(FOLLOW_statOrImplicitBlock_in_condExStat5364);
            ts=statOrImplicitBlock();

            state._fsp--;
            if (state.failed) return retval;

            // ShellCommand.g:1333:3: ( 'else' es= statOrImplicitBlock )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==68) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ShellCommand.g:1334:5: 'else' es= statOrImplicitBlock
                    {
                    match(input,68,FOLLOW_68_in_condExStat5375); if (state.failed) return retval;

                    pushFollow(FOLLOW_statOrImplicitBlock_in_condExStat5387);
                    es=statOrImplicitBlock();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { elseStat = es; }

                    }
                    break;

            }


            match(input,69,FOLLOW_69_in_condExStat5399); if (state.failed) return retval;

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
    // ShellCommand.g:1345:1: iterStat returns [ASTIterationStatement n] : 'for' var= IDENT 'in' set= inSoilExpression 'do' s= statOrImplicitBlock 'end' ;
    public final ShellCommandParser.iterStat_return iterStat() throws RecognitionException {
        ShellCommandParser.iterStat_return retval = new ShellCommandParser.iterStat_return();
        retval.start = input.LT(1);


        Token var=null;
        ASTExpression set =null;

        ASTStatement s =null;


        try {
            // ShellCommand.g:1346:3: ( 'for' var= IDENT 'in' set= inSoilExpression 'do' s= statOrImplicitBlock 'end' )
            // ShellCommand.g:1347:3: 'for' var= IDENT 'in' set= inSoilExpression 'do' s= statOrImplicitBlock 'end'
            {
            match(input,74,FOLLOW_74_in_iterStat5424); if (state.failed) return retval;

            var=(Token)match(input,IDENT,FOLLOW_IDENT_in_iterStat5432); if (state.failed) return retval;

            match(input,78,FOLLOW_78_in_iterStat5436); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_iterStat5444);
            set=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            match(input,67,FOLLOW_67_in_iterStat5448); if (state.failed) return retval;

            pushFollow(FOLLOW_statOrImplicitBlock_in_iterStat5456);
            s=statOrImplicitBlock();

            state._fsp--;
            if (state.failed) return retval;

            match(input,69,FOLLOW_69_in_iterStat5461); if (state.failed) return retval;

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
    // ShellCommand.g:1362:1: whileStat returns [ASTWhileStatement n] : 'while' cond= inSoilExpression 'do' s= statOrImplicitBlock 'end' ;
    public final ShellCommandParser.whileStat_return whileStat() throws RecognitionException {
        ShellCommandParser.whileStat_return retval = new ShellCommandParser.whileStat_return();
        retval.start = input.LT(1);


        ASTExpression cond =null;

        ASTStatement s =null;


        try {
            // ShellCommand.g:1363:3: ( 'while' cond= inSoilExpression 'do' s= statOrImplicitBlock 'end' )
            // ShellCommand.g:1364:3: 'while' cond= inSoilExpression 'do' s= statOrImplicitBlock 'end'
            {
            match(input,101,FOLLOW_101_in_whileStat5487); if (state.failed) return retval;

            pushFollow(FOLLOW_inSoilExpression_in_whileStat5495);
            cond=inSoilExpression();

            state._fsp--;
            if (state.failed) return retval;

            match(input,67,FOLLOW_67_in_whileStat5499); if (state.failed) return retval;

            pushFollow(FOLLOW_statOrImplicitBlock_in_whileStat5507);
            s=statOrImplicitBlock();

            state._fsp--;
            if (state.failed) return retval;

            match(input,69,FOLLOW_69_in_whileStat5512); if (state.failed) return retval;

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
    // ShellCommand.g:1376:1: blockStat returns [ASTBlockStatement n] : 'begin' ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )? s= stat 'end' ;
    public final ShellCommandParser.blockStat_return blockStat() throws RecognitionException {
        ShellCommandParser.blockStat_return retval = new ShellCommandParser.blockStat_return();
        retval.start = input.LT(1);


        ASTVariableDeclaration vd =null;

        ASTVariableDeclaration vd1 =null;

        ShellCommandParser.stat_return s =null;



          retval.n = new ASTBlockStatement(((Token)retval.start), org.tzi.use.config.Options.explicitVariableDeclarations);

        try {
            // ShellCommand.g:1380:2: ( 'begin' ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )? s= stat 'end' )
            // ShellCommand.g:1381:2: 'begin' ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )? s= stat 'end'
            {
            match(input,59,FOLLOW_59_in_blockStat5542); if (state.failed) return retval;

            // ShellCommand.g:1382:2: ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==63) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ShellCommand.g:1382:4: 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI
                    {
                    match(input,63,FOLLOW_63_in_blockStat5547); if (state.failed) return retval;

                    pushFollow(FOLLOW_variableDeclaration_in_blockStat5553);
                    vd=variableDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd);}

                    // ShellCommand.g:1382:73: ( COMMA vd1= variableDeclaration )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==COMMA) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ShellCommand.g:1382:75: COMMA vd1= variableDeclaration
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_blockStat5559); if (state.failed) return retval;

                    	    pushFollow(FOLLOW_variableDeclaration_in_blockStat5565);
                    	    vd1=variableDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd1);}

                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);


                    match(input,SEMI,FOLLOW_SEMI_in_blockStat5572); if (state.failed) return retval;

                    }
                    break;

            }


            pushFollow(FOLLOW_stat_in_blockStat5582);
            s=stat();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n.setBody((s!=null?s.n:null)); }

            match(input,69,FOLLOW_69_in_blockStat5587); if (state.failed) return retval;

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
    // ShellCommand.g:1391:1: implicitBlockStat returns [ASTBlockStatement n] : 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI s= stat ;
    public final ShellCommandParser.implicitBlockStat_return implicitBlockStat() throws RecognitionException {
        ShellCommandParser.implicitBlockStat_return retval = new ShellCommandParser.implicitBlockStat_return();
        retval.start = input.LT(1);


        ASTVariableDeclaration vd =null;

        ASTVariableDeclaration vd1 =null;

        ShellCommandParser.stat_return s =null;



          retval.n = new ASTBlockStatement(((Token)retval.start), false);

        try {
            // ShellCommand.g:1395:3: ( 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI s= stat )
            // ShellCommand.g:1396:3: 'declare' vd= variableDeclaration ( COMMA vd1= variableDeclaration )* SEMI s= stat
            {
            match(input,63,FOLLOW_63_in_implicitBlockStat5613); if (state.failed) return retval;

            pushFollow(FOLLOW_variableDeclaration_in_implicitBlockStat5619);
            vd=variableDeclaration();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd);}

            // ShellCommand.g:1396:72: ( COMMA vd1= variableDeclaration )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==COMMA) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ShellCommand.g:1396:74: COMMA vd1= variableDeclaration
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_implicitBlockStat5625); if (state.failed) return retval;

            	    pushFollow(FOLLOW_variableDeclaration_in_implicitBlockStat5631);
            	    vd1=variableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { retval.n.addVariableDeclaration(vd1);}

            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);


            match(input,SEMI,FOLLOW_SEMI_in_implicitBlockStat5638); if (state.failed) return retval;

            pushFollow(FOLLOW_stat_in_implicitBlockStat5646);
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
    // ShellCommand.g:1400:1: statOrImplicitBlock returns [ASTStatement n] : (s1= stat |s2= implicitBlockStat ) ;
    public final ASTStatement statOrImplicitBlock() throws RecognitionException {
        ASTStatement n = null;


        ShellCommandParser.stat_return s1 =null;

        ShellCommandParser.implicitBlockStat_return s2 =null;


        try {
            // ShellCommand.g:1401:3: ( (s1= stat |s2= implicitBlockStat ) )
            // ShellCommand.g:1402:3: (s1= stat |s2= implicitBlockStat )
            {
            // ShellCommand.g:1402:3: (s1= stat |s2= implicitBlockStat )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==AT||LA70_0==HASH||(LA70_0 >= IDENT && LA70_0 <= INT)||(LA70_0 >= LPAREN && LA70_0 <= MINUS)||LA70_0==PLUS||LA70_0==REAL||LA70_0==SEMI||(LA70_0 >= STAR && LA70_0 <= STRING)||(LA70_0 >= 44 && LA70_0 <= 55)||LA70_0==59||(LA70_0 >= 64 && LA70_0 <= 65)||(LA70_0 >= 68 && LA70_0 <= 69)||(LA70_0 >= 73 && LA70_0 <= 74)||LA70_0==76||LA70_0==79||(LA70_0 >= 81 && LA70_0 <= 91)||(LA70_0 >= 96 && LA70_0 <= 97)||(LA70_0 >= 100 && LA70_0 <= 101)) ) {
                alt70=1;
            }
            else if ( (LA70_0==63) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }
            switch (alt70) {
                case 1 :
                    // ShellCommand.g:1402:4: s1= stat
                    {
                    pushFollow(FOLLOW_stat_in_statOrImplicitBlock5669);
                    s1=stat();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = (s1!=null?s1.n:null); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:1402:31: s2= implicitBlockStat
                    {
                    pushFollow(FOLLOW_implicitBlockStat_in_statOrImplicitBlock5679);
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
    // ShellCommand.g:1416:1: nothing :;
    public final void nothing() throws RecognitionException {
        try {
            // ShellCommand.g:1417:1: ()
            // ShellCommand.g:1418:1: 
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
    // ShellCommand.g:1424:1: rValue returns [ASTRValue n] : (e= inSoilExpression |oc= objCreateStat );
    public final ASTRValue rValue() throws RecognitionException {
        ASTRValue n = null;


        ASTExpression e =null;

        ShellCommandParser.objCreateStat_return oc =null;


        try {
            // ShellCommand.g:1425:5: (e= inSoilExpression |oc= objCreateStat )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==AT||LA71_0==HASH||(LA71_0 >= IDENT && LA71_0 <= INT)||(LA71_0 >= LPAREN && LA71_0 <= MINUS)||LA71_0==PLUS||LA71_0==REAL||(LA71_0 >= STAR && LA71_0 <= STRING)||(LA71_0 >= 44 && LA71_0 <= 55)||LA71_0==73||LA71_0==76||(LA71_0 >= 81 && LA71_0 <= 82)||(LA71_0 >= 84 && LA71_0 <= 91)||(LA71_0 >= 96 && LA71_0 <= 97)||LA71_0==100) ) {
                alt71=1;
            }
            else if ( (LA71_0==83) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }
            switch (alt71) {
                case 1 :
                    // ShellCommand.g:1426:5: e= inSoilExpression
                    {
                    pushFollow(FOLLOW_inSoilExpression_in_rValue5725);
                    e=inSoilExpression();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ASTRValueExpressionOrOpCall(e); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:1427:5: oc= objCreateStat
                    {
                    pushFollow(FOLLOW_objCreateStat_in_rValue5737);
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
    // ShellCommand.g:1440:1: rValList returns [List<ASTRValue> n] : ( nothing |rl= rValListMin1 );
    public final List<ASTRValue> rValList() throws RecognitionException {
        List<ASTRValue> n = null;


        List<ASTRValue> rl =null;


        try {
            // ShellCommand.g:1441:3: ( nothing |rl= rValListMin1 )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RBRACE) ) {
                alt72=1;
            }
            else if ( (LA72_0==AT||LA72_0==HASH||(LA72_0 >= IDENT && LA72_0 <= INT)||(LA72_0 >= LPAREN && LA72_0 <= MINUS)||LA72_0==PLUS||LA72_0==REAL||(LA72_0 >= STAR && LA72_0 <= STRING)||(LA72_0 >= 44 && LA72_0 <= 55)||LA72_0==73||LA72_0==76||(LA72_0 >= 81 && LA72_0 <= 91)||(LA72_0 >= 96 && LA72_0 <= 97)||LA72_0==100) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }
            switch (alt72) {
                case 1 :
                    // ShellCommand.g:1442:3: nothing
                    {
                    pushFollow(FOLLOW_nothing_in_rValList5760);
                    nothing();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = Collections.<ASTRValue>emptyList(); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:1445:3: rl= rValListMin1
                    {
                    pushFollow(FOLLOW_rValListMin1_in_rValList5787);
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
    // ShellCommand.g:1453:1: rValListMin1 returns [List<ASTRValue> n] : r= rValue ( COMMA r= rValue )* ;
    public final List<ASTRValue> rValListMin1() throws RecognitionException {
        List<ASTRValue> n = null;


        ASTRValue r =null;



          n = new ArrayList<ASTRValue>();

        try {
            // ShellCommand.g:1457:3: (r= rValue ( COMMA r= rValue )* )
            // ShellCommand.g:1458:3: r= rValue ( COMMA r= rValue )*
            {
            pushFollow(FOLLOW_rValue_in_rValListMin15820);
            r=rValue();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add(r); }

            // ShellCommand.g:1460:3: ( COMMA r= rValue )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==COMMA) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // ShellCommand.g:1461:5: COMMA r= rValue
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_rValListMin15834); if (state.failed) return n;

            	    pushFollow(FOLLOW_rValue_in_rValListMin15844);
            	    r=rValue();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n.add(r); }

            	    }
            	    break;

            	default :
            	    break loop73;
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
    // ShellCommand.g:1471:1: rValListMin2 returns [List<ASTRValue> n] : r= rValue COMMA r= rValue ( COMMA r= rValue )* ;
    public final List<ASTRValue> rValListMin2() throws RecognitionException {
        List<ASTRValue> n = null;


        ASTRValue r =null;



          n = new ArrayList<ASTRValue>();

        try {
            // ShellCommand.g:1475:3: (r= rValue COMMA r= rValue ( COMMA r= rValue )* )
            // ShellCommand.g:1476:3: r= rValue COMMA r= rValue ( COMMA r= rValue )*
            {
            pushFollow(FOLLOW_rValue_in_rValListMin25883);
            r=rValue();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add(r); }

            match(input,COMMA,FOLLOW_COMMA_in_rValListMin25891); if (state.failed) return n;

            pushFollow(FOLLOW_rValue_in_rValListMin25899);
            r=rValue();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add(r); }

            // ShellCommand.g:1481:3: ( COMMA r= rValue )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==COMMA) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ShellCommand.g:1482:5: COMMA r= rValue
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_rValListMin25913); if (state.failed) return n;

            	    pushFollow(FOLLOW_rValue_in_rValListMin25923);
            	    r=rValue();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { n.add(r); }

            	    }
            	    break;

            	default :
            	    break loop74;
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
    // ShellCommand.g:1492:1: inSoilExpression returns [ASTExpression n] : e= expression ;
    public final ASTExpression inSoilExpression() throws RecognitionException {
        ASTExpression n = null;


        ShellCommandParser.expression_return e =null;


        try {
            // ShellCommand.g:1493:3: (e= expression )
            // ShellCommand.g:1494:3: e= expression
            {
            pushFollow(FOLLOW_expression_in_inSoilExpression5957);
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
    // ShellCommand.g:1503:1: exprList returns [List<ASTExpression> n] : ( nothing |el= exprListMin1 );
    public final List<ASTExpression> exprList() throws RecognitionException {
        List<ASTExpression> n = null;


        List<ASTExpression> el =null;


        try {
            // ShellCommand.g:1504:3: ( nothing |el= exprListMin1 )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RPAREN) ) {
                alt75=1;
            }
            else if ( (LA75_0==AT||LA75_0==HASH||(LA75_0 >= IDENT && LA75_0 <= INT)||(LA75_0 >= LPAREN && LA75_0 <= MINUS)||LA75_0==PLUS||LA75_0==REAL||(LA75_0 >= STAR && LA75_0 <= STRING)||(LA75_0 >= 44 && LA75_0 <= 55)||LA75_0==73||LA75_0==76||(LA75_0 >= 81 && LA75_0 <= 82)||(LA75_0 >= 84 && LA75_0 <= 91)||(LA75_0 >= 96 && LA75_0 <= 97)||LA75_0==100) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }
            switch (alt75) {
                case 1 :
                    // ShellCommand.g:1505:3: nothing
                    {
                    pushFollow(FOLLOW_nothing_in_exprList5986);
                    nothing();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ArrayList<ASTExpression>(); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:1508:3: el= exprListMin1
                    {
                    pushFollow(FOLLOW_exprListMin1_in_exprList6004);
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
    // ShellCommand.g:1516:1: exprListMin1 returns [List<ASTExpression> n] : e= inSoilExpression ( COMMA e= inSoilExpression )* ;
    public final List<ASTExpression> exprListMin1() throws RecognitionException {
        List<ASTExpression> n = null;


        ASTExpression e =null;



          n = new ArrayList<ASTExpression>();

        try {
            // ShellCommand.g:1520:3: (e= inSoilExpression ( COMMA e= inSoilExpression )* )
            // ShellCommand.g:1521:3: e= inSoilExpression ( COMMA e= inSoilExpression )*
            {
            pushFollow(FOLLOW_inSoilExpression_in_exprListMin16037);
            e=inSoilExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            // ShellCommand.g:1523:3: ( COMMA e= inSoilExpression )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==COMMA) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ShellCommand.g:1524:5: COMMA e= inSoilExpression
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_exprListMin16052); if (state.failed) return n;

            	    pushFollow(FOLLOW_inSoilExpression_in_exprListMin16062);
            	    e=inSoilExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            	    }
            	    break;

            	default :
            	    break loop76;
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
    // ShellCommand.g:1534:1: exprListMin2 returns [List<ASTExpression> n] : e= inSoilExpression COMMA e= inSoilExpression ( COMMA e= inSoilExpression )* ;
    public final List<ASTExpression> exprListMin2() throws RecognitionException {
        List<ASTExpression> n = null;


        ASTExpression e =null;



          n = new ArrayList<ASTExpression>();

        try {
            // ShellCommand.g:1538:3: (e= inSoilExpression COMMA e= inSoilExpression ( COMMA e= inSoilExpression )* )
            // ShellCommand.g:1539:3: e= inSoilExpression COMMA e= inSoilExpression ( COMMA e= inSoilExpression )*
            {
            pushFollow(FOLLOW_inSoilExpression_in_exprListMin26102);
            e=inSoilExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            match(input,COMMA,FOLLOW_COMMA_in_exprListMin26110); if (state.failed) return n;

            pushFollow(FOLLOW_inSoilExpression_in_exprListMin26118);
            e=inSoilExpression();

            state._fsp--;
            if (state.failed) return n;

            if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            // ShellCommand.g:1544:3: ( COMMA e= inSoilExpression )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==COMMA) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ShellCommand.g:1545:5: COMMA e= inSoilExpression
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_exprListMin26132); if (state.failed) return n;

            	    pushFollow(FOLLOW_inSoilExpression_in_exprListMin26142);
            	    e=inSoilExpression();

            	    state._fsp--;
            	    if (state.failed) return n;

            	    if ( state.backtracking==0 ) { if (e != null) n.add(e); }

            	    }
            	    break;

            	default :
            	    break loop77;
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
    // ShellCommand.g:1555:1: identList returns [List<String> n] : ( nothing |il= identListMin1 );
    public final List<String> identList() throws RecognitionException {
        List<String> n = null;


        List<String> il =null;


        try {
            // ShellCommand.g:1556:3: ( nothing |il= identListMin1 )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==EOF||LA78_0==RBRACE||(LA78_0 >= RPAREN && LA78_0 <= SEMI)||(LA78_0 >= 68 && LA78_0 <= 69)) ) {
                alt78=1;
            }
            else if ( (LA78_0==IDENT) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return n;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;

            }
            switch (alt78) {
                case 1 :
                    // ShellCommand.g:1557:3: nothing
                    {
                    pushFollow(FOLLOW_nothing_in_identList6172);
                    nothing();

                    state._fsp--;
                    if (state.failed) return n;

                    if ( state.backtracking==0 ) { n = new ArrayList<String>(); }

                    }
                    break;
                case 2 :
                    // ShellCommand.g:1560:3: il= identListMin1
                    {
                    pushFollow(FOLLOW_identListMin1_in_identList6189);
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
    // ShellCommand.g:1568:1: identListMin1 returns [List<String> n] : id= IDENT ( COMMA id= IDENT )* ;
    public final List<String> identListMin1() throws RecognitionException {
        List<String> n = null;


        Token id=null;


          n = new ArrayList<String>();

        try {
            // ShellCommand.g:1572:3: (id= IDENT ( COMMA id= IDENT )* )
            // ShellCommand.g:1573:3: id= IDENT ( COMMA id= IDENT )*
            {
            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_identListMin16223); if (state.failed) return n;

            if ( state.backtracking==0 ) { n.add((id!=null?id.getText():null)); }

            // ShellCommand.g:1575:3: ( COMMA id= IDENT )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==COMMA) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // ShellCommand.g:1576:5: COMMA id= IDENT
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_identListMin16237); if (state.failed) return n;

            	    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_identListMin16247); if (state.failed) return n;

            	    if ( state.backtracking==0 ) {
            	        n.add((id!=null?id.getText():null)); }

            	    }
            	    break;

            	default :
            	    break loop79;
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

    // $ANTLR start synpred1_ShellCommand
    public final void synpred1_ShellCommand_fragment() throws RecognitionException {
        // ShellCommand.g:87:3: ( stat )
        // ShellCommand.g:87:4: stat
        {
        pushFollow(FOLLOW_stat_in_synpred1_ShellCommand57);
        stat();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_ShellCommand

    // $ANTLR start synpred2_ShellCommand
    public final void synpred2_ShellCommand_fragment() throws RecognitionException {
        // ShellCommand.g:90:3: ( legacyStat )
        // ShellCommand.g:90:4: legacyStat
        {
        pushFollow(FOLLOW_legacyStat_in_synpred2_ShellCommand78);
        legacyStat();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_ShellCommand

    // $ANTLR start synpred3_ShellCommand
    public final void synpred3_ShellCommand_fragment() throws RecognitionException {
        // ShellCommand.g:100:3: ( legacyStat )
        // ShellCommand.g:100:4: legacyStat
        {
        pushFollow(FOLLOW_legacyStat_in_synpred3_ShellCommand110);
        legacyStat();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_ShellCommand

    // $ANTLR start synpred4_ShellCommand
    public final void synpred4_ShellCommand_fragment() throws RecognitionException {
        // ShellCommand.g:103:3: ( stat )
        // ShellCommand.g:103:4: stat
        {
        pushFollow(FOLLOW_stat_in_synpred4_ShellCommand133);
        stat();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_ShellCommand

    // $ANTLR start synpred5_ShellCommand
    public final void synpred5_ShellCommand_fragment() throws RecognitionException {
        // ShellCommand.g:339:13: ( inSoilExpression )
        // ShellCommand.g:339:14: inSoilExpression
        {
        pushFollow(FOLLOW_inSoilExpression_in_synpred5_ShellCommand813);
        inSoilExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_ShellCommand

    // $ANTLR start synpred6_ShellCommand
    public final void synpred6_ShellCommand_fragment() throws RecognitionException {
        // ShellCommand.g:967:7: ( COLON type EQUAL )
        // ShellCommand.g:967:8: COLON type EQUAL
        {
        match(input,COLON,FOLLOW_COLON_in_synpred6_ShellCommand3924); if (state.failed) return ;

        pushFollow(FOLLOW_type_in_synpred6_ShellCommand3926);
        type();

        state._fsp--;
        if (state.failed) return ;

        match(input,EQUAL,FOLLOW_EQUAL_in_synpred6_ShellCommand3928); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_ShellCommand

    // $ANTLR start synpred7_ShellCommand
    public final void synpred7_ShellCommand_fragment() throws RecognitionException {
        // ShellCommand.g:1125:5: ( statStartingWithExpr )
        // ShellCommand.g:1125:6: statStartingWithExpr
        {
        pushFollow(FOLLOW_statStartingWithExpr_in_synpred7_ShellCommand4525);
        statStartingWithExpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred7_ShellCommand

    // Delegated rules

    public final boolean synpred4_ShellCommand() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_ShellCommand_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_ShellCommand() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_ShellCommand_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_ShellCommand() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_ShellCommand_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_ShellCommand() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_ShellCommand_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_ShellCommand() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_ShellCommand_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_ShellCommand() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_ShellCommand_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_ShellCommand() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_ShellCommand_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_stat_in_shellCommandOnly65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyStat_in_shellCommandOnly86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyStat_in_shellCommand118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_shellCommand120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_shellCommand141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_shellCommand143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyOpEnter_in_legacyStat177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyOpExit_in_legacyStat193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nextLegacyStat_in_legacyStat206 = new BitSet(new long[]{0x4400000000000002L,0x0000000400048103L});
    public static final BitSet FOLLOW_nextLegacyStat_in_legacyStat217 = new BitSet(new long[]{0x4400000000000002L,0x0000000400048103L});
    public static final BitSet FOLLOW_singleLegacyStat_in_nextLegacyStat251 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_SEMI_in_nextLegacyStat255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyCreate_in_singleLegacyStat288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyCreateAssign_in_singleLegacyStat307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyCreateInsert_in_singleLegacyStat320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyLet_in_singleLegacyStat333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyExecute_in_singleLegacyStat361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objDestroyStat_in_singleLegacyStat379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_singleLegacyStat392 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_singleLegacyStat396 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_attAssignStat_in_singleLegacyStat402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lnkInsStat_in_singleLegacyStat415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lnkDelStat_in_singleLegacyStat436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_legacyCreate472 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_identListMin1_in_legacyCreate480 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_legacyCreate484 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_simpleType_in_legacyCreate492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_legacyCreateAssign529 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_identListMin1_in_legacyCreateAssign537 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_EQUAL_in_legacyCreateAssign541 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_legacyCreateAssign545 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_simpleType_in_legacyCreateAssign553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_legacyCreateInsert587 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_legacyCreateInsert595 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_legacyCreateInsert599 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_simpleType_in_legacyCreateInsert607 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_legacyCreateInsert611 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_legacyCreateInsert615 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValListMin2WithOptionalQualifiers_in_legacyCreateInsert625 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_legacyCreateInsert629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_legacyLet662 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_legacyLet670 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_COLON_in_legacyLet680 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_legacyLet690 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_legacyLet699 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_inSoilExpression_in_legacyLet707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_legacyOpEnter740 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_inSoilExpression_in_legacyOpEnter748 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_legacyOpEnter756 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_legacyOpEnter760 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_exprList_in_legacyOpEnter770 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_legacyOpEnter774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_legacyOpExit809 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_inSoilExpression_in_legacyOpExit821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nothing_in_legacyOpExit825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_legacyExecute858 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_legacyExecute862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionOnly897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expressionOnly899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_expression947 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_expression958 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_COLON_in_expression962 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_expression966 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_expression971 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_expression975 = new BitSet(new long[]{0x0000000000000400L,0x0000000000004000L});
    public static final BitSet FOLLOW_COMMA_in_expression1013 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_expression1025 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_COLON_in_expression1029 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_expression1033 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_expression1038 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_expression1042 = new BitSet(new long[]{0x0000000000000400L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_expression1083 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_identicalExpression_in_expression1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_paramList1132 = new BitSet(new long[]{0x0000001000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_paramList1149 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_paramList1161 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_paramList1165 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_RPAREN_in_paramList1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_idList1214 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_idList1224 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_idList1228 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_IDENT_in_variableDeclaration1259 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_variableDeclaration1261 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_variableDeclaration1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalImpliesExpression_in_identicalExpression1296 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_DOT_in_identicalExpression1314 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_identicalExpression1318 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_identicalExpression1320 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_conditionalImpliesExpression_in_identicalExpression1324 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_identicalExpression1326 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression1369 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_conditionalImpliesExpression1382 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_conditionalOrExpression_in_conditionalImpliesExpression1386 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_conditionalXOrExpression_in_conditionalOrExpression1431 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_conditionalOrExpression1444 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_conditionalXOrExpression_in_conditionalOrExpression1448 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalXOrExpression1492 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_conditionalXOrExpression1505 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalXOrExpression1509 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_equalityExpression_in_conditionalAndExpression1553 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_conditionalAndExpression1566 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_equalityExpression_in_conditionalAndExpression1570 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression1618 = new BitSet(new long[]{0x0000000040002002L});
    public static final BitSet FOLLOW_set_in_equalityExpression1637 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression1647 = new BitSet(new long[]{0x0000000040002002L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1696 = new BitSet(new long[]{0x0000000001818002L});
    public static final BitSet FOLLOW_set_in_relationalExpression1714 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_relationalExpression1732 = new BitSet(new long[]{0x0000000001818002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1782 = new BitSet(new long[]{0x0000000084000002L});
    public static final BitSet FOLLOW_set_in_additiveExpression1800 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1810 = new BitSet(new long[]{0x0000000084000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1860 = new BitSet(new long[]{0x0000014000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression1878 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1892 = new BitSet(new long[]{0x0000014000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_unaryExpression1954 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpression_in_postfixExpression2031 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_ARROW_in_postfixExpression2049 = new BitSet(new long[]{0x0000000000080000L,0x0000000307420000L});
    public static final BitSet FOLLOW_DOT_in_postfixExpression2055 = new BitSet(new long[]{0x0000000000080000L,0x0000000307420000L});
    public static final BitSet FOLLOW_propertyCall_in_postfixExpression2066 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_literal_in_primaryExpression2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectReference_in_primaryExpression2120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyCall_in_primaryExpression2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression2143 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_primaryExpression2147 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifExpression_in_primaryExpression2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primaryExpression2173 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_DOT_in_primaryExpression2175 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_primaryExpression2177 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_AT_in_primaryExpression2200 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_primaryExpression2202 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression2220 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression2222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primaryExpression2235 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_DOT_in_primaryExpression2237 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_primaryExpression2239 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression2243 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_primaryExpression2247 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression2249 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AT_in_primaryExpression2269 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_primaryExpression2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_objectReference2297 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_objectReference2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_queryExpression_in_propertyCall2370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iterateExpression_in_propertyCall2383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operationExpression_in_propertyCall2396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeExpression_in_propertyCall2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inStateExpression_in_propertyCall2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_queryExpression2457 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_queryExpression2464 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_elemVarsDeclaration_in_queryExpression2475 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_BAR_in_queryExpression2479 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_queryExpression2490 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_queryExpression2498 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_queryExpression2502 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_queryExpression2513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_iterateExpression2545 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_iterateExpression2551 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_elemVarsDeclaration_in_iterateExpression2559 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMI_in_iterateExpression2561 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableInitialization_in_iterateExpression2569 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_BAR_in_iterateExpression2571 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_iterateExpression2579 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_iterateExpression2585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_operationExpression2629 = new BitSet(new long[]{0x0000000002400022L});
    public static final BitSet FOLLOW_LBRACK_in_operationExpression2651 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_operationExpression2664 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_COMMA_in_operationExpression2677 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_operationExpression2681 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_RBRACK_in_operationExpression2693 = new BitSet(new long[]{0x0000000002400022L});
    public static final BitSet FOLLOW_LBRACK_in_operationExpression2710 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_operationExpression2725 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_COMMA_in_operationExpression2740 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_operationExpression2744 = new BitSet(new long[]{0x0000000400000400L});
    public static final BitSet FOLLOW_RBRACK_in_operationExpression2758 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_AT_in_operationExpression2783 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_operationExpression2785 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_operationExpression2810 = new BitSet(new long[]{0x00FFF318861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_operationExpression2831 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_operationExpression2843 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_operationExpression2847 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_RPAREN_in_operationExpression2867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_inStateExpression2904 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_inStateExpression2909 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_inStateExpression2918 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_inStateExpression2923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeExpression2959 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_typeExpression2983 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_typeExpression2987 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_typeExpression2989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_elemVarsDeclaration3027 = new BitSet(new long[]{0x0000000000000482L});
    public static final BitSet FOLLOW_COLON_in_elemVarsDeclaration3030 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_elemVarsDeclaration3034 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_elemVarsDeclaration3044 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_elemVarsDeclaration3050 = new BitSet(new long[]{0x0000000000000482L});
    public static final BitSet FOLLOW_COLON_in_elemVarsDeclaration3053 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_elemVarsDeclaration3059 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_IDENT_in_variableInitialization3087 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_variableInitialization3089 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_variableInitialization3093 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_variableInitialization3095 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_variableInitialization3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ifExpression3131 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_ifExpression3135 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_ifExpression3137 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_ifExpression3141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ifExpression3143 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_ifExpression3147 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ifExpression3149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_literal3188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_literal3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_literal3215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_literal3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_literal3244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_literal3254 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal3256 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3260 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3262 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3266 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal3268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_literal3278 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal3280 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3284 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3286 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3290 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal3292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_literal3302 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal3304 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_conditionalImpliesExpression_in_literal3308 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3310 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3314 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_literal3326 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal3328 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3332 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3334 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3338 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal3340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_literal3350 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_literal3352 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3356 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3358 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3362 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3364 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3368 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_literal3370 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF21200L});
    public static final BitSet FOLLOW_additiveExpression_in_literal3374 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_literal3376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HASH_in_literal3393 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_literal3397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_literal3409 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_COLON_in_literal3411 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_literal3415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionLiteral_in_literal3427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emptyCollectionLiteral_in_literal3439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_undefinedLiteral_in_literal3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleLiteral_in_literal3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_literal3475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionLiteral3513 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LBRACE_in_collectionLiteral3542 = new BitSet(new long[]{0x00FFF30A861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_collectionItem_in_collectionLiteral3559 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_COMMA_in_collectionLiteral3572 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_collectionItem_in_collectionLiteral3576 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_RBRACE_in_collectionLiteral3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_collectionItem3624 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_DOTDOT_in_collectionItem3635 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_collectionItem3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_emptyCollectionLiteral3668 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_emptyCollectionLiteral3670 = new BitSet(new long[]{0x0003700000000000L});
    public static final BitSet FOLLOW_collectionType_in_emptyCollectionLiteral3674 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_emptyCollectionLiteral3676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_emptyCollectionLiteral3692 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LBRACE_in_emptyCollectionLiteral3694 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_emptyCollectionLiteral3696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_undefinedLiteral3726 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_undefinedLiteral3728 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_undefinedLiteral3732 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_undefinedLiteral3734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_undefinedLiteral3748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_undefinedLiteral3762 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_undefinedLiteral3764 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_undefinedLiteral3768 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_undefinedLiteral3770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_undefinedLiteral3784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_tupleLiteral3823 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LBRACE_in_tupleLiteral3829 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tupleItem_in_tupleLiteral3837 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_COMMA_in_tupleLiteral3848 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tupleItem_in_tupleLiteral3852 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_RBRACE_in_tupleLiteral3863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_tupleItem3894 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_COLON_in_tupleItem3933 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_tupleItem3937 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_tupleItem3939 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_tupleItem3943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tupleItem3965 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_expression_in_tupleItem3975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleType_in_type4041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionType_in_type4053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleType_in_type4065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_uncertaintyType_in_type4077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_uncertaintyType4108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeOnly4146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_typeOnly4148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_simpleType4176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionType4214 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_collectionType4241 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_collectionType4245 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_collectionType4247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_tupleType4281 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_tupleType4283 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tuplePart_in_tupleType4292 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_COMMA_in_tupleType4303 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_tuplePart_in_tupleType4307 = new BitSet(new long[]{0x0000001000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tupleType4319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_tuplePart4351 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_tuplePart4353 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_tuplePart4357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_statOnly4406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_statOnly4410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleStat_in_stat4445 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_SEMI_in_stat4457 = new BitSet(new long[]{0x08FFF308861A0020L,0x000000330FFE9603L});
    public static final BitSet FOLLOW_singleStat_in_stat4467 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_emptyStat_in_singleStat4507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statStartingWithExpr_in_singleStat4533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varAssignStat_in_singleStat4545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCreateStat_in_singleStat4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objDestroyStat_in_singleStat4573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lnkInsStat_in_singleStat4586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lnkDelStat_in_singleStat4603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condExStat_in_singleStat4620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iterStat_in_singleStat4637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStat_in_singleStat4659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStat_in_singleStat4677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nothing_in_emptyStat4704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inSoilExpression_in_statStartingWithExpr4730 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_attAssignStat_in_statStartingWithExpr4744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_varAssignStat4782 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_EQUAL_in_varAssignStat4786 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValue_in_varAssignStat4794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_attAssignStat4818 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_attAssignStat4827 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_EQUAL_in_attAssignStat4831 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValue_in_attAssignStat4839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_objCreateStat4865 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_simpleType_in_objCreateStat4873 = new BitSet(new long[]{0x1000000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_objCreateStat4883 = new BitSet(new long[]{0x00FFF318861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_inSoilExpression_in_objCreateStat4896 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_objCreateStat4904 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60_in_objCreateStat4922 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_objCreateStat4930 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValListMin2WithOptionalQualifiers_in_objCreateStat4944 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_objCreateStat4952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_objDestroyStat4988 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_exprListMin1_in_objDestroyStat4996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_lnkInsStat5022 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_lnkInsStat5026 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkInsStat5036 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_lnkInsStat5040 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_lnkInsStat5044 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_lnkInsStat5052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5081 = new BitSet(new long[]{0x0000000000200400L});
    public static final BitSet FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5092 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5101 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5108 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers5124 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5135 = new BitSet(new long[]{0x0000000000200402L});
    public static final BitSet FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5146 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5155 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5162 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin2WithOptionalQualifiers5184 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValue_in_rValListMin2WithOptionalQualifiers5199 = new BitSet(new long[]{0x0000000000200402L});
    public static final BitSet FOLLOW_LBRACE_in_rValListMin2WithOptionalQualifiers5219 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValList_in_rValListMin2WithOptionalQualifiers5230 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACE_in_rValListMin2WithOptionalQualifiers5239 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_64_in_lnkDelStat5280 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_LPAREN_in_lnkDelStat5284 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValListMin2WithOptionalQualifiers_in_lnkDelStat5294 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RPAREN_in_lnkDelStat5298 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_lnkDelStat5302 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_lnkDelStat5311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_condExStat5342 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_inSoilExpression_in_condExStat5351 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_condExStat5355 = new BitSet(new long[]{0x88FFF308861A0020L,0x000000330FFE9603L});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_condExStat5364 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_68_in_condExStat5375 = new BitSet(new long[]{0x88FFF308861A0020L,0x000000330FFE9603L});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_condExStat5387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_condExStat5399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_iterStat5424 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_iterStat5432 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_iterStat5436 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_inSoilExpression_in_iterStat5444 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_iterStat5448 = new BitSet(new long[]{0x88FFF308861A0020L,0x000000330FFE9603L});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_iterStat5456 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_iterStat5461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_whileStat5487 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_inSoilExpression_in_whileStat5495 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_whileStat5499 = new BitSet(new long[]{0x88FFF308861A0020L,0x000000330FFE9603L});
    public static final BitSet FOLLOW_statOrImplicitBlock_in_whileStat5507 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_whileStat5512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_blockStat5542 = new BitSet(new long[]{0x88FFF308861A0020L,0x000000330FFE9603L});
    public static final BitSet FOLLOW_63_in_blockStat5547 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_blockStat5553 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_COMMA_in_blockStat5559 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_blockStat5565 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_SEMI_in_blockStat5572 = new BitSet(new long[]{0x08FFF308861A0020L,0x000000330FFE9603L});
    public static final BitSet FOLLOW_stat_in_blockStat5582 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_blockStat5587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_implicitBlockStat5613 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_implicitBlockStat5619 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_COMMA_in_implicitBlockStat5625 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_variableDeclaration_in_implicitBlockStat5631 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_SEMI_in_implicitBlockStat5638 = new BitSet(new long[]{0x08FFF308861A0020L,0x000000330FFE9603L});
    public static final BitSet FOLLOW_stat_in_implicitBlockStat5646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_statOrImplicitBlock5669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicitBlockStat_in_statOrImplicitBlock5679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inSoilExpression_in_rValue5725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCreateStat_in_rValue5737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nothing_in_rValList5760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rValListMin1_in_rValList5787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rValue_in_rValListMin15820 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin15834 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValue_in_rValListMin15844 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rValue_in_rValListMin25883 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin25891 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValue_in_rValListMin25899 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_rValListMin25913 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FFE1200L});
    public static final BitSet FOLLOW_rValue_in_rValListMin25923 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_expression_in_inSoilExpression5957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nothing_in_exprList5986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exprListMin1_in_exprList6004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin16037 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_exprListMin16052 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin16062 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin26102 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_exprListMin26110 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin26118 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_exprListMin26132 = new BitSet(new long[]{0x00FFF308861A0020L,0x000000130FF61200L});
    public static final BitSet FOLLOW_inSoilExpression_in_exprListMin26142 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_nothing_in_identList6172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identListMin1_in_identList6189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_identListMin16223 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_COMMA_in_identListMin16237 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENT_in_identListMin16247 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_stat_in_synpred1_ShellCommand57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyStat_in_synpred2_ShellCommand78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_legacyStat_in_synpred3_ShellCommand110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stat_in_synpred4_ShellCommand133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inSoilExpression_in_synpred5_ShellCommand813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_synpred6_ShellCommand3924 = new BitSet(new long[]{0x007FF00000080000L});
    public static final BitSet FOLLOW_type_in_synpred6_ShellCommand3926 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_synpred6_ShellCommand3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statStartingWithExpr_in_synpred7_ShellCommand4525 = new BitSet(new long[]{0x0000000000000002L});

}