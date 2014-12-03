// $ANTLR 3.4 /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g 2014-12-03 17:03:46

package antlr.projekt1;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class MGPLParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ANIMATION", "CIRCLE", "DIGIT", "DOWNARROW", "IDF", "LEFTARROW", "LOWCASE", "NUMBER", "ON", "RECTANGLE", "RIGHTARROW", "SINGLE_COMMENT", "SPACE", "TOUCHES", "TRIANGLE", "UPARROW", "UPCASE", "WS", "'!'", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "';'", "'<'", "'<='", "'='", "'=='", "'['", "']'", "'else'", "'for'", "'game'", "'if'", "'int'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int ANIMATION=4;
    public static final int CIRCLE=5;
    public static final int DIGIT=6;
    public static final int DOWNARROW=7;
    public static final int IDF=8;
    public static final int LEFTARROW=9;
    public static final int LOWCASE=10;
    public static final int NUMBER=11;
    public static final int ON=12;
    public static final int RECTANGLE=13;
    public static final int RIGHTARROW=14;
    public static final int SINGLE_COMMENT=15;
    public static final int SPACE=16;
    public static final int TOUCHES=17;
    public static final int TRIANGLE=18;
    public static final int UPARROW=19;
    public static final int UPCASE=20;
    public static final int WS=21;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "attrAssList", "var", "decl", "unary", "assStmt", "forStmt", 
    "attrAss", "objType", "konjunkt", "atom", "stmt", "add", "eventBlock", 
    "animBlock", "init", "keyStroke", "block", "expr", "mult", "ifStmt", 
    "op", "stmtBlock", "relat", "objDecl", "prog", "varDecl"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public MGPLParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public MGPLParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this,port,adaptor);
        setDebugListener(proxy);
        setTokenStream(new DebugTokenStream(input,proxy));
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);
        proxy.setTreeAdaptor(adap);
    }

public MGPLParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg);
     
    TreeAdaptor adap = new CommonTreeAdaptor();
    setTreeAdaptor(adap);


}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

protected DebugTreeAdaptor adaptor;
public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = new DebugTreeAdaptor(dbg,adaptor);


}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}

    public String[] getTokenNames() { return MGPLParser.tokenNames; }
    public String getGrammarFileName() { return "/home/nvetter/Projekte/Uni/Compilerbau/MGPL.g"; }


    public static class prog_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "prog"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:34:1: prog : 'game' IDF '(' ( attrAssList )? ')' ( decl )* stmtBlock ( block )* ;
    public final MGPLParser.prog_return prog() throws RecognitionException {
        MGPLParser.prog_return retval = new MGPLParser.prog_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal1=null;
        Token IDF2=null;
        Token char_literal3=null;
        Token char_literal5=null;
        MGPLParser.attrAssList_return attrAssList4 =null;

        MGPLParser.decl_return decl6 =null;

        MGPLParser.stmtBlock_return stmtBlock7 =null;

        MGPLParser.block_return block8 =null;


        Object string_literal1_tree=null;
        Object IDF2_tree=null;
        Object char_literal3_tree=null;
        Object char_literal5_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "prog");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(34, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:34:14: ( 'game' IDF '(' ( attrAssList )? ')' ( decl )* stmtBlock ( block )* )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:34:16: 'game' IDF '(' ( attrAssList )? ')' ( decl )* stmtBlock ( block )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(34,16);
            string_literal1=(Token)match(input,41,FOLLOW_41_in_prog280); 
            string_literal1_tree = 
            (Object)adaptor.create(string_literal1)
            ;
            adaptor.addChild(root_0, string_literal1_tree);

            dbg.location(34,23);
            IDF2=(Token)match(input,IDF,FOLLOW_IDF_in_prog282); 
            IDF2_tree = 
            (Object)adaptor.create(IDF2)
            ;
            adaptor.addChild(root_0, IDF2_tree);

            dbg.location(34,27);
            char_literal3=(Token)match(input,24,FOLLOW_24_in_prog284); 
            char_literal3_tree = 
            (Object)adaptor.create(char_literal3)
            ;
            adaptor.addChild(root_0, char_literal3_tree);

            dbg.location(34,31);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:34:31: ( attrAssList )?
            int alt1=2;
            try { dbg.enterSubRule(1);
            try { dbg.enterDecision(1, decisionCanBacktrack[1]);

            int LA1_0 = input.LA(1);

            if ( (LA1_0==IDF) ) {
                alt1=1;
            }
            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:34:31: attrAssList
                    {
                    dbg.location(34,31);
                    pushFollow(FOLLOW_attrAssList_in_prog286);
                    attrAssList4=attrAssList();

                    state._fsp--;

                    adaptor.addChild(root_0, attrAssList4.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(1);}

            dbg.location(34,44);
            char_literal5=(Token)match(input,25,FOLLOW_25_in_prog289); 
            char_literal5_tree = 
            (Object)adaptor.create(char_literal5)
            ;
            adaptor.addChild(root_0, char_literal5_tree);

            dbg.location(34,48);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:34:48: ( decl )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==CIRCLE||LA2_0==RECTANGLE||LA2_0==TRIANGLE||LA2_0==43) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:34:48: decl
            	    {
            	    dbg.location(34,48);
            	    pushFollow(FOLLOW_decl_in_prog291);
            	    decl6=decl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, decl6.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}

            dbg.location(34,54);
            pushFollow(FOLLOW_stmtBlock_in_prog294);
            stmtBlock7=stmtBlock();

            state._fsp--;

            adaptor.addChild(root_0, stmtBlock7.getTree());
            dbg.location(34,64);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:34:64: ( block )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==ANIMATION||LA3_0==ON) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:34:64: block
            	    {
            	    dbg.location(34,64);
            	    pushFollow(FOLLOW_block_in_prog296);
            	    block8=block();

            	    state._fsp--;

            	    adaptor.addChild(root_0, block8.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);
            } finally {dbg.exitSubRule(3);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(34, 69);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "prog");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "prog"


    public static class decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "decl"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:35:1: decl : ( varDecl ';' | objDecl ';' );
    public final MGPLParser.decl_return decl() throws RecognitionException {
        MGPLParser.decl_return retval = new MGPLParser.decl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal10=null;
        Token char_literal12=null;
        MGPLParser.varDecl_return varDecl9 =null;

        MGPLParser.objDecl_return objDecl11 =null;


        Object char_literal10_tree=null;
        Object char_literal12_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "decl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(35, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:35:14: ( varDecl ';' | objDecl ';' )
            int alt4=2;
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==43) ) {
                alt4=1;
            }
            else if ( (LA4_0==CIRCLE||LA4_0==RECTANGLE||LA4_0==TRIANGLE) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:35:16: varDecl ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(35,16);
                    pushFollow(FOLLOW_varDecl_in_decl312);
                    varDecl9=varDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, varDecl9.getTree());
                    dbg.location(35,24);
                    char_literal10=(Token)match(input,32,FOLLOW_32_in_decl314); 
                    char_literal10_tree = 
                    (Object)adaptor.create(char_literal10)
                    ;
                    adaptor.addChild(root_0, char_literal10_tree);


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:35:30: objDecl ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(35,30);
                    pushFollow(FOLLOW_objDecl_in_decl318);
                    objDecl11=objDecl();

                    state._fsp--;

                    adaptor.addChild(root_0, objDecl11.getTree());
                    dbg.location(35,38);
                    char_literal12=(Token)match(input,32,FOLLOW_32_in_decl320); 
                    char_literal12_tree = 
                    (Object)adaptor.create(char_literal12)
                    ;
                    adaptor.addChild(root_0, char_literal12_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(35, 40);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "decl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "decl"


    public static class varDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "varDecl"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:36:1: varDecl : 'int' IDF ( ( init )? | '[' NUMBER ']' ) ;
    public final MGPLParser.varDecl_return varDecl() throws RecognitionException {
        MGPLParser.varDecl_return retval = new MGPLParser.varDecl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal13=null;
        Token IDF14=null;
        Token char_literal16=null;
        Token NUMBER17=null;
        Token char_literal18=null;
        MGPLParser.init_return init15 =null;


        Object string_literal13_tree=null;
        Object IDF14_tree=null;
        Object char_literal16_tree=null;
        Object NUMBER17_tree=null;
        Object char_literal18_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "varDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(36, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:36:14: ( 'int' IDF ( ( init )? | '[' NUMBER ']' ) )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:36:16: 'int' IDF ( ( init )? | '[' NUMBER ']' )
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(36,16);
            string_literal13=(Token)match(input,43,FOLLOW_43_in_varDecl332); 
            string_literal13_tree = 
            (Object)adaptor.create(string_literal13)
            ;
            adaptor.addChild(root_0, string_literal13_tree);

            dbg.location(36,22);
            IDF14=(Token)match(input,IDF,FOLLOW_IDF_in_varDecl334); 
            IDF14_tree = 
            (Object)adaptor.create(IDF14)
            ;
            adaptor.addChild(root_0, IDF14_tree);

            dbg.location(36,26);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:36:26: ( ( init )? | '[' NUMBER ']' )
            int alt6=2;
            try { dbg.enterSubRule(6);
            try { dbg.enterDecision(6, decisionCanBacktrack[6]);

            int LA6_0 = input.LA(1);

            if ( (LA6_0==32||LA6_0==35) ) {
                alt6=1;
            }
            else if ( (LA6_0==37) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:36:27: ( init )?
                    {
                    dbg.location(36,27);
                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:36:27: ( init )?
                    int alt5=2;
                    try { dbg.enterSubRule(5);
                    try { dbg.enterDecision(5, decisionCanBacktrack[5]);

                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==35) ) {
                        alt5=1;
                    }
                    } finally {dbg.exitDecision(5);}

                    switch (alt5) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:36:27: init
                            {
                            dbg.location(36,27);
                            pushFollow(FOLLOW_init_in_varDecl337);
                            init15=init();

                            state._fsp--;

                            adaptor.addChild(root_0, init15.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(5);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:36:35: '[' NUMBER ']'
                    {
                    dbg.location(36,35);
                    char_literal16=(Token)match(input,37,FOLLOW_37_in_varDecl342); 
                    char_literal16_tree = 
                    (Object)adaptor.create(char_literal16)
                    ;
                    adaptor.addChild(root_0, char_literal16_tree);

                    dbg.location(36,39);
                    NUMBER17=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_varDecl344); 
                    NUMBER17_tree = 
                    (Object)adaptor.create(NUMBER17)
                    ;
                    adaptor.addChild(root_0, NUMBER17_tree);

                    dbg.location(36,46);
                    char_literal18=(Token)match(input,38,FOLLOW_38_in_varDecl346); 
                    char_literal18_tree = 
                    (Object)adaptor.create(char_literal18)
                    ;
                    adaptor.addChild(root_0, char_literal18_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(6);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(36, 50);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "varDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "varDecl"


    public static class init_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "init"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:37:1: init : '=' expr ;
    public final MGPLParser.init_return init() throws RecognitionException {
        MGPLParser.init_return retval = new MGPLParser.init_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal19=null;
        MGPLParser.expr_return expr20 =null;


        Object char_literal19_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "init");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(37, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:37:14: ( '=' expr )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:37:16: '=' expr
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(37,16);
            char_literal19=(Token)match(input,35,FOLLOW_35_in_init363); 
            char_literal19_tree = 
            (Object)adaptor.create(char_literal19)
            ;
            adaptor.addChild(root_0, char_literal19_tree);

            dbg.location(37,20);
            pushFollow(FOLLOW_expr_in_init365);
            expr20=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr20.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(37, 24);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "init");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "init"


    public static class objDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "objDecl"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:38:1: objDecl : objType IDF ( '(' ( attrAssList )? ')' | '[' NUMBER ']' ) ;
    public final MGPLParser.objDecl_return objDecl() throws RecognitionException {
        MGPLParser.objDecl_return retval = new MGPLParser.objDecl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IDF22=null;
        Token char_literal23=null;
        Token char_literal25=null;
        Token char_literal26=null;
        Token NUMBER27=null;
        Token char_literal28=null;
        MGPLParser.objType_return objType21 =null;

        MGPLParser.attrAssList_return attrAssList24 =null;


        Object IDF22_tree=null;
        Object char_literal23_tree=null;
        Object char_literal25_tree=null;
        Object char_literal26_tree=null;
        Object NUMBER27_tree=null;
        Object char_literal28_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "objDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(38, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:38:14: ( objType IDF ( '(' ( attrAssList )? ')' | '[' NUMBER ']' ) )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:38:16: objType IDF ( '(' ( attrAssList )? ')' | '[' NUMBER ']' )
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(38,16);
            pushFollow(FOLLOW_objType_in_objDecl378);
            objType21=objType();

            state._fsp--;

            adaptor.addChild(root_0, objType21.getTree());
            dbg.location(38,24);
            IDF22=(Token)match(input,IDF,FOLLOW_IDF_in_objDecl380); 
            IDF22_tree = 
            (Object)adaptor.create(IDF22)
            ;
            adaptor.addChild(root_0, IDF22_tree);

            dbg.location(38,28);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:38:28: ( '(' ( attrAssList )? ')' | '[' NUMBER ']' )
            int alt8=2;
            try { dbg.enterSubRule(8);
            try { dbg.enterDecision(8, decisionCanBacktrack[8]);

            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            else if ( (LA8_0==37) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(8);}

            switch (alt8) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:38:29: '(' ( attrAssList )? ')'
                    {
                    dbg.location(38,29);
                    char_literal23=(Token)match(input,24,FOLLOW_24_in_objDecl383); 
                    char_literal23_tree = 
                    (Object)adaptor.create(char_literal23)
                    ;
                    adaptor.addChild(root_0, char_literal23_tree);

                    dbg.location(38,33);
                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:38:33: ( attrAssList )?
                    int alt7=2;
                    try { dbg.enterSubRule(7);
                    try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==IDF) ) {
                        alt7=1;
                    }
                    } finally {dbg.exitDecision(7);}

                    switch (alt7) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:38:33: attrAssList
                            {
                            dbg.location(38,33);
                            pushFollow(FOLLOW_attrAssList_in_objDecl385);
                            attrAssList24=attrAssList();

                            state._fsp--;

                            adaptor.addChild(root_0, attrAssList24.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(7);}

                    dbg.location(38,46);
                    char_literal25=(Token)match(input,25,FOLLOW_25_in_objDecl388); 
                    char_literal25_tree = 
                    (Object)adaptor.create(char_literal25)
                    ;
                    adaptor.addChild(root_0, char_literal25_tree);


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:38:52: '[' NUMBER ']'
                    {
                    dbg.location(38,52);
                    char_literal26=(Token)match(input,37,FOLLOW_37_in_objDecl392); 
                    char_literal26_tree = 
                    (Object)adaptor.create(char_literal26)
                    ;
                    adaptor.addChild(root_0, char_literal26_tree);

                    dbg.location(38,56);
                    NUMBER27=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_objDecl394); 
                    NUMBER27_tree = 
                    (Object)adaptor.create(NUMBER27)
                    ;
                    adaptor.addChild(root_0, NUMBER27_tree);

                    dbg.location(38,63);
                    char_literal28=(Token)match(input,38,FOLLOW_38_in_objDecl396); 
                    char_literal28_tree = 
                    (Object)adaptor.create(char_literal28)
                    ;
                    adaptor.addChild(root_0, char_literal28_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(8);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(38, 67);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "objDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "objDecl"


    public static class objType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "objType"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:39:1: objType : ( RECTANGLE | TRIANGLE | CIRCLE );
    public final MGPLParser.objType_return objType() throws RecognitionException {
        MGPLParser.objType_return retval = new MGPLParser.objType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set29=null;

        Object set29_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "objType");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(39, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:39:14: ( RECTANGLE | TRIANGLE | CIRCLE )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(39,14);
            set29=(Token)input.LT(1);

            if ( input.LA(1)==CIRCLE||input.LA(1)==RECTANGLE||input.LA(1)==TRIANGLE ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set29)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(39, 44);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "objType");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "objType"


    public static class attrAssList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attrAssList"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:40:1: attrAssList : attrAss ( ',' attrAss )* ;
    public final MGPLParser.attrAssList_return attrAssList() throws RecognitionException {
        MGPLParser.attrAssList_return retval = new MGPLParser.attrAssList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal31=null;
        MGPLParser.attrAss_return attrAss30 =null;

        MGPLParser.attrAss_return attrAss32 =null;


        Object char_literal31_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "attrAssList");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(40, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:40:13: ( attrAss ( ',' attrAss )* )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:40:15: attrAss ( ',' attrAss )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(40,15);
            pushFollow(FOLLOW_attrAss_in_attrAssList425);
            attrAss30=attrAss();

            state._fsp--;

            adaptor.addChild(root_0, attrAss30.getTree());
            dbg.location(40,23);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:40:23: ( ',' attrAss )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=2;
                try { dbg.enterDecision(9, decisionCanBacktrack[9]);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==28) ) {
                    alt9=1;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:40:24: ',' attrAss
            	    {
            	    dbg.location(40,24);
            	    char_literal31=(Token)match(input,28,FOLLOW_28_in_attrAssList428); 
            	    char_literal31_tree = 
            	    (Object)adaptor.create(char_literal31)
            	    ;
            	    adaptor.addChild(root_0, char_literal31_tree);

            	    dbg.location(40,28);
            	    pushFollow(FOLLOW_attrAss_in_attrAssList430);
            	    attrAss32=attrAss();

            	    state._fsp--;

            	    adaptor.addChild(root_0, attrAss32.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(40, 37);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "attrAssList");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "attrAssList"


    public static class attrAss_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attrAss"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:41:1: attrAss : IDF '=' expr ;
    public final MGPLParser.attrAss_return attrAss() throws RecognitionException {
        MGPLParser.attrAss_return retval = new MGPLParser.attrAss_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IDF33=null;
        Token char_literal34=null;
        MGPLParser.expr_return expr35 =null;


        Object IDF33_tree=null;
        Object char_literal34_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "attrAss");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(41, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:41:9: ( IDF '=' expr )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:41:11: IDF '=' expr
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(41,11);
            IDF33=(Token)match(input,IDF,FOLLOW_IDF_in_attrAss440); 
            IDF33_tree = 
            (Object)adaptor.create(IDF33)
            ;
            adaptor.addChild(root_0, IDF33_tree);

            dbg.location(41,15);
            char_literal34=(Token)match(input,35,FOLLOW_35_in_attrAss442); 
            char_literal34_tree = 
            (Object)adaptor.create(char_literal34)
            ;
            adaptor.addChild(root_0, char_literal34_tree);

            dbg.location(41,19);
            pushFollow(FOLLOW_expr_in_attrAss444);
            expr35=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr35.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(41, 23);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "attrAss");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "attrAss"


    public static class block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:42:1: block : ( animBlock | eventBlock );
    public final MGPLParser.block_return block() throws RecognitionException {
        MGPLParser.block_return retval = new MGPLParser.block_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        MGPLParser.animBlock_return animBlock36 =null;

        MGPLParser.eventBlock_return eventBlock37 =null;



        try { dbg.enterRule(getGrammarFileName(), "block");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(42, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:42:14: ( animBlock | eventBlock )
            int alt10=2;
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

            int LA10_0 = input.LA(1);

            if ( (LA10_0==ANIMATION) ) {
                alt10=1;
            }
            else if ( (LA10_0==ON) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:42:16: animBlock
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(42,16);
                    pushFollow(FOLLOW_animBlock_in_block459);
                    animBlock36=animBlock();

                    state._fsp--;

                    adaptor.addChild(root_0, animBlock36.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:42:28: eventBlock
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(42,28);
                    pushFollow(FOLLOW_eventBlock_in_block463);
                    eventBlock37=eventBlock();

                    state._fsp--;

                    adaptor.addChild(root_0, eventBlock37.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(42, 37);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "block");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "block"


    public static class animBlock_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "animBlock"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:43:1: animBlock : ANIMATION IDF '(' objType IDF ')' stmtBlock ;
    public final MGPLParser.animBlock_return animBlock() throws RecognitionException {
        MGPLParser.animBlock_return retval = new MGPLParser.animBlock_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ANIMATION38=null;
        Token IDF39=null;
        Token char_literal40=null;
        Token IDF42=null;
        Token char_literal43=null;
        MGPLParser.objType_return objType41 =null;

        MGPLParser.stmtBlock_return stmtBlock44 =null;


        Object ANIMATION38_tree=null;
        Object IDF39_tree=null;
        Object char_literal40_tree=null;
        Object IDF42_tree=null;
        Object char_literal43_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "animBlock");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(43, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:43:14: ( ANIMATION IDF '(' objType IDF ')' stmtBlock )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:43:16: ANIMATION IDF '(' objType IDF ')' stmtBlock
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(43,16);
            ANIMATION38=(Token)match(input,ANIMATION,FOLLOW_ANIMATION_in_animBlock473); 
            ANIMATION38_tree = 
            (Object)adaptor.create(ANIMATION38)
            ;
            adaptor.addChild(root_0, ANIMATION38_tree);

            dbg.location(43,26);
            IDF39=(Token)match(input,IDF,FOLLOW_IDF_in_animBlock475); 
            IDF39_tree = 
            (Object)adaptor.create(IDF39)
            ;
            adaptor.addChild(root_0, IDF39_tree);

            dbg.location(43,30);
            char_literal40=(Token)match(input,24,FOLLOW_24_in_animBlock477); 
            char_literal40_tree = 
            (Object)adaptor.create(char_literal40)
            ;
            adaptor.addChild(root_0, char_literal40_tree);

            dbg.location(43,34);
            pushFollow(FOLLOW_objType_in_animBlock479);
            objType41=objType();

            state._fsp--;

            adaptor.addChild(root_0, objType41.getTree());
            dbg.location(43,42);
            IDF42=(Token)match(input,IDF,FOLLOW_IDF_in_animBlock481); 
            IDF42_tree = 
            (Object)adaptor.create(IDF42)
            ;
            adaptor.addChild(root_0, IDF42_tree);

            dbg.location(43,46);
            char_literal43=(Token)match(input,25,FOLLOW_25_in_animBlock483); 
            char_literal43_tree = 
            (Object)adaptor.create(char_literal43)
            ;
            adaptor.addChild(root_0, char_literal43_tree);

            dbg.location(43,50);
            pushFollow(FOLLOW_stmtBlock_in_animBlock485);
            stmtBlock44=stmtBlock();

            state._fsp--;

            adaptor.addChild(root_0, stmtBlock44.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(43, 59);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "animBlock");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "animBlock"


    public static class eventBlock_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eventBlock"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:44:1: eventBlock : ON keyStroke stmtBlock ;
    public final MGPLParser.eventBlock_return eventBlock() throws RecognitionException {
        MGPLParser.eventBlock_return retval = new MGPLParser.eventBlock_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ON45=null;
        MGPLParser.keyStroke_return keyStroke46 =null;

        MGPLParser.stmtBlock_return stmtBlock47 =null;


        Object ON45_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "eventBlock");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(44, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:44:14: ( ON keyStroke stmtBlock )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:44:16: ON keyStroke stmtBlock
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(44,16);
            ON45=(Token)match(input,ON,FOLLOW_ON_in_eventBlock495); 
            ON45_tree = 
            (Object)adaptor.create(ON45)
            ;
            adaptor.addChild(root_0, ON45_tree);

            dbg.location(44,19);
            pushFollow(FOLLOW_keyStroke_in_eventBlock497);
            keyStroke46=keyStroke();

            state._fsp--;

            adaptor.addChild(root_0, keyStroke46.getTree());
            dbg.location(44,29);
            pushFollow(FOLLOW_stmtBlock_in_eventBlock499);
            stmtBlock47=stmtBlock();

            state._fsp--;

            adaptor.addChild(root_0, stmtBlock47.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(44, 38);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "eventBlock");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "eventBlock"


    public static class keyStroke_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyStroke"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:45:1: keyStroke : ( SPACE | LEFTARROW | RIGHTARROW | UPARROW | DOWNARROW );
    public final MGPLParser.keyStroke_return keyStroke() throws RecognitionException {
        MGPLParser.keyStroke_return retval = new MGPLParser.keyStroke_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set48=null;

        Object set48_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "keyStroke");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(45, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:45:14: ( SPACE | LEFTARROW | RIGHTARROW | UPARROW | DOWNARROW )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(45,14);
            set48=(Token)input.LT(1);

            if ( input.LA(1)==DOWNARROW||input.LA(1)==LEFTARROW||input.LA(1)==RIGHTARROW||input.LA(1)==SPACE||input.LA(1)==UPARROW ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set48)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(49, 13);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "keyStroke");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "keyStroke"


    public static class stmtBlock_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stmtBlock"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:50:1: stmtBlock : '{' ( stmt )* '}' ;
    public final MGPLParser.stmtBlock_return stmtBlock() throws RecognitionException {
        MGPLParser.stmtBlock_return retval = new MGPLParser.stmtBlock_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal49=null;
        Token char_literal51=null;
        MGPLParser.stmt_return stmt50 =null;


        Object char_literal49_tree=null;
        Object char_literal51_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "stmtBlock");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(50, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:50:14: ( '{' ( stmt )* '}' )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:50:16: '{' ( stmt )* '}'
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(50,16);
            char_literal49=(Token)match(input,44,FOLLOW_44_in_stmtBlock545); 
            char_literal49_tree = 
            (Object)adaptor.create(char_literal49)
            ;
            adaptor.addChild(root_0, char_literal49_tree);

            dbg.location(50,20);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:50:20: ( stmt )*
            try { dbg.enterSubRule(11);

            loop11:
            do {
                int alt11=2;
                try { dbg.enterDecision(11, decisionCanBacktrack[11]);

                int LA11_0 = input.LA(1);

                if ( (LA11_0==IDF||LA11_0==40||LA11_0==42) ) {
                    alt11=1;
                }


                } finally {dbg.exitDecision(11);}

                switch (alt11) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:50:20: stmt
            	    {
            	    dbg.location(50,20);
            	    pushFollow(FOLLOW_stmt_in_stmtBlock547);
            	    stmt50=stmt();

            	    state._fsp--;

            	    adaptor.addChild(root_0, stmt50.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);
            } finally {dbg.exitSubRule(11);}

            dbg.location(50,26);
            char_literal51=(Token)match(input,46,FOLLOW_46_in_stmtBlock550); 
            char_literal51_tree = 
            (Object)adaptor.create(char_literal51)
            ;
            adaptor.addChild(root_0, char_literal51_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(50, 29);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "stmtBlock");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "stmtBlock"


    public static class stmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stmt"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:51:1: stmt : ( ifStmt | forStmt | assStmt );
    public final MGPLParser.stmt_return stmt() throws RecognitionException {
        MGPLParser.stmt_return retval = new MGPLParser.stmt_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        MGPLParser.ifStmt_return ifStmt52 =null;

        MGPLParser.forStmt_return forStmt53 =null;

        MGPLParser.assStmt_return assStmt54 =null;



        try { dbg.enterRule(getGrammarFileName(), "stmt");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(51, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:51:14: ( ifStmt | forStmt | assStmt )
            int alt12=3;
            try { dbg.enterDecision(12, decisionCanBacktrack[12]);

            switch ( input.LA(1) ) {
            case 42:
                {
                alt12=1;
                }
                break;
            case 40:
                {
                alt12=2;
                }
                break;
            case IDF:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:51:16: ifStmt
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(51,16);
                    pushFollow(FOLLOW_ifStmt_in_stmt566);
                    ifStmt52=ifStmt();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStmt52.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:51:25: forStmt
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(51,25);
                    pushFollow(FOLLOW_forStmt_in_stmt570);
                    forStmt53=forStmt();

                    state._fsp--;

                    adaptor.addChild(root_0, forStmt53.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:51:35: assStmt
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(51,35);
                    pushFollow(FOLLOW_assStmt_in_stmt574);
                    assStmt54=assStmt();

                    state._fsp--;

                    adaptor.addChild(root_0, assStmt54.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(51, 41);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "stmt");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "stmt"


    public static class ifStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStmt"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:52:1: ifStmt : 'if' '(' expr ')' stmtBlock ( 'else' stmtBlock )? ;
    public final MGPLParser.ifStmt_return ifStmt() throws RecognitionException {
        MGPLParser.ifStmt_return retval = new MGPLParser.ifStmt_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal55=null;
        Token char_literal56=null;
        Token char_literal58=null;
        Token string_literal60=null;
        MGPLParser.expr_return expr57 =null;

        MGPLParser.stmtBlock_return stmtBlock59 =null;

        MGPLParser.stmtBlock_return stmtBlock61 =null;


        Object string_literal55_tree=null;
        Object char_literal56_tree=null;
        Object char_literal58_tree=null;
        Object string_literal60_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "ifStmt");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(52, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:52:14: ( 'if' '(' expr ')' stmtBlock ( 'else' stmtBlock )? )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:52:16: 'if' '(' expr ')' stmtBlock ( 'else' stmtBlock )?
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(52,16);
            string_literal55=(Token)match(input,42,FOLLOW_42_in_ifStmt587); 
            string_literal55_tree = 
            (Object)adaptor.create(string_literal55)
            ;
            adaptor.addChild(root_0, string_literal55_tree);

            dbg.location(52,21);
            char_literal56=(Token)match(input,24,FOLLOW_24_in_ifStmt589); 
            char_literal56_tree = 
            (Object)adaptor.create(char_literal56)
            ;
            adaptor.addChild(root_0, char_literal56_tree);

            dbg.location(52,25);
            pushFollow(FOLLOW_expr_in_ifStmt591);
            expr57=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr57.getTree());
            dbg.location(52,30);
            char_literal58=(Token)match(input,25,FOLLOW_25_in_ifStmt593); 
            char_literal58_tree = 
            (Object)adaptor.create(char_literal58)
            ;
            adaptor.addChild(root_0, char_literal58_tree);

            dbg.location(52,34);
            pushFollow(FOLLOW_stmtBlock_in_ifStmt595);
            stmtBlock59=stmtBlock();

            state._fsp--;

            adaptor.addChild(root_0, stmtBlock59.getTree());
            dbg.location(52,44);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:52:44: ( 'else' stmtBlock )?
            int alt13=2;
            try { dbg.enterSubRule(13);
            try { dbg.enterDecision(13, decisionCanBacktrack[13]);

            int LA13_0 = input.LA(1);

            if ( (LA13_0==39) ) {
                alt13=1;
            }
            } finally {dbg.exitDecision(13);}

            switch (alt13) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:52:46: 'else' stmtBlock
                    {
                    dbg.location(52,46);
                    string_literal60=(Token)match(input,39,FOLLOW_39_in_ifStmt599); 
                    string_literal60_tree = 
                    (Object)adaptor.create(string_literal60)
                    ;
                    adaptor.addChild(root_0, string_literal60_tree);

                    dbg.location(52,53);
                    pushFollow(FOLLOW_stmtBlock_in_ifStmt601);
                    stmtBlock61=stmtBlock();

                    state._fsp--;

                    adaptor.addChild(root_0, stmtBlock61.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(13);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(52, 64);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "ifStmt");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "ifStmt"


    public static class forStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "forStmt"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:53:1: forStmt : 'for' '(' assStmt ';' expr ';' assStmt ')' stmtBlock ;
    public final MGPLParser.forStmt_return forStmt() throws RecognitionException {
        MGPLParser.forStmt_return retval = new MGPLParser.forStmt_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal62=null;
        Token char_literal63=null;
        Token char_literal65=null;
        Token char_literal67=null;
        Token char_literal69=null;
        MGPLParser.assStmt_return assStmt64 =null;

        MGPLParser.expr_return expr66 =null;

        MGPLParser.assStmt_return assStmt68 =null;

        MGPLParser.stmtBlock_return stmtBlock70 =null;


        Object string_literal62_tree=null;
        Object char_literal63_tree=null;
        Object char_literal65_tree=null;
        Object char_literal67_tree=null;
        Object char_literal69_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "forStmt");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(53, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:53:14: ( 'for' '(' assStmt ';' expr ';' assStmt ')' stmtBlock )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:53:16: 'for' '(' assStmt ';' expr ';' assStmt ')' stmtBlock
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(53,16);
            string_literal62=(Token)match(input,40,FOLLOW_40_in_forStmt616); 
            string_literal62_tree = 
            (Object)adaptor.create(string_literal62)
            ;
            adaptor.addChild(root_0, string_literal62_tree);

            dbg.location(53,22);
            char_literal63=(Token)match(input,24,FOLLOW_24_in_forStmt618); 
            char_literal63_tree = 
            (Object)adaptor.create(char_literal63)
            ;
            adaptor.addChild(root_0, char_literal63_tree);

            dbg.location(53,26);
            pushFollow(FOLLOW_assStmt_in_forStmt620);
            assStmt64=assStmt();

            state._fsp--;

            adaptor.addChild(root_0, assStmt64.getTree());
            dbg.location(53,34);
            char_literal65=(Token)match(input,32,FOLLOW_32_in_forStmt622); 
            char_literal65_tree = 
            (Object)adaptor.create(char_literal65)
            ;
            adaptor.addChild(root_0, char_literal65_tree);

            dbg.location(53,38);
            pushFollow(FOLLOW_expr_in_forStmt624);
            expr66=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr66.getTree());
            dbg.location(53,43);
            char_literal67=(Token)match(input,32,FOLLOW_32_in_forStmt626); 
            char_literal67_tree = 
            (Object)adaptor.create(char_literal67)
            ;
            adaptor.addChild(root_0, char_literal67_tree);

            dbg.location(53,47);
            pushFollow(FOLLOW_assStmt_in_forStmt628);
            assStmt68=assStmt();

            state._fsp--;

            adaptor.addChild(root_0, assStmt68.getTree());
            dbg.location(53,55);
            char_literal69=(Token)match(input,25,FOLLOW_25_in_forStmt630); 
            char_literal69_tree = 
            (Object)adaptor.create(char_literal69)
            ;
            adaptor.addChild(root_0, char_literal69_tree);

            dbg.location(53,59);
            pushFollow(FOLLOW_stmtBlock_in_forStmt632);
            stmtBlock70=stmtBlock();

            state._fsp--;

            adaptor.addChild(root_0, stmtBlock70.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(53, 67);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "forStmt");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "forStmt"


    public static class assStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assStmt"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:54:1: assStmt : var '=' expr ;
    public final MGPLParser.assStmt_return assStmt() throws RecognitionException {
        MGPLParser.assStmt_return retval = new MGPLParser.assStmt_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal72=null;
        MGPLParser.var_return var71 =null;

        MGPLParser.expr_return expr73 =null;


        Object char_literal72_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "assStmt");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(54, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:54:10: ( var '=' expr )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:54:12: var '=' expr
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(54,12);
            pushFollow(FOLLOW_var_in_assStmt640);
            var71=var();

            state._fsp--;

            adaptor.addChild(root_0, var71.getTree());
            dbg.location(54,16);
            char_literal72=(Token)match(input,35,FOLLOW_35_in_assStmt642); 
            char_literal72_tree = 
            (Object)adaptor.create(char_literal72)
            ;
            adaptor.addChild(root_0, char_literal72_tree);

            dbg.location(54,20);
            pushFollow(FOLLOW_expr_in_assStmt644);
            expr73=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr73.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(54, 24);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assStmt");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "assStmt"


    public static class var_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:55:1: var : IDF ( '[' expr ']' ( '.' IDF )? | '.' IDF )? ;
    public final MGPLParser.var_return var() throws RecognitionException {
        MGPLParser.var_return retval = new MGPLParser.var_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IDF74=null;
        Token char_literal75=null;
        Token char_literal77=null;
        Token char_literal78=null;
        Token IDF79=null;
        Token char_literal80=null;
        Token IDF81=null;
        MGPLParser.expr_return expr76 =null;


        Object IDF74_tree=null;
        Object char_literal75_tree=null;
        Object char_literal77_tree=null;
        Object char_literal78_tree=null;
        Object IDF79_tree=null;
        Object char_literal80_tree=null;
        Object IDF81_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "var");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(55, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:55:14: ( IDF ( '[' expr ']' ( '.' IDF )? | '.' IDF )? )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:56:2: IDF ( '[' expr ']' ( '.' IDF )? | '.' IDF )?
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(56,2);
            IDF74=(Token)match(input,IDF,FOLLOW_IDF_in_var664); 
            IDF74_tree = 
            (Object)adaptor.create(IDF74)
            ;
            adaptor.addChild(root_0, IDF74_tree);

            dbg.location(56,6);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:56:6: ( '[' expr ']' ( '.' IDF )? | '.' IDF )?
            int alt15=3;
            try { dbg.enterSubRule(15);
            try { dbg.enterDecision(15, decisionCanBacktrack[15]);

            int LA15_0 = input.LA(1);

            if ( (LA15_0==37) ) {
                alt15=1;
            }
            else if ( (LA15_0==30) ) {
                alt15=2;
            }
            } finally {dbg.exitDecision(15);}

            switch (alt15) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:56:8: '[' expr ']' ( '.' IDF )?
                    {
                    dbg.location(56,8);
                    char_literal75=(Token)match(input,37,FOLLOW_37_in_var668); 
                    char_literal75_tree = 
                    (Object)adaptor.create(char_literal75)
                    ;
                    adaptor.addChild(root_0, char_literal75_tree);

                    dbg.location(56,12);
                    pushFollow(FOLLOW_expr_in_var670);
                    expr76=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr76.getTree());
                    dbg.location(56,17);
                    char_literal77=(Token)match(input,38,FOLLOW_38_in_var672); 
                    char_literal77_tree = 
                    (Object)adaptor.create(char_literal77)
                    ;
                    adaptor.addChild(root_0, char_literal77_tree);

                    dbg.location(56,21);
                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:56:21: ( '.' IDF )?
                    int alt14=2;
                    try { dbg.enterSubRule(14);
                    try { dbg.enterDecision(14, decisionCanBacktrack[14]);

                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==30) ) {
                        alt14=1;
                    }
                    } finally {dbg.exitDecision(14);}

                    switch (alt14) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:56:23: '.' IDF
                            {
                            dbg.location(56,23);
                            char_literal78=(Token)match(input,30,FOLLOW_30_in_var676); 
                            char_literal78_tree = 
                            (Object)adaptor.create(char_literal78)
                            ;
                            adaptor.addChild(root_0, char_literal78_tree);

                            dbg.location(56,27);
                            IDF79=(Token)match(input,IDF,FOLLOW_IDF_in_var678); 
                            IDF79_tree = 
                            (Object)adaptor.create(IDF79)
                            ;
                            adaptor.addChild(root_0, IDF79_tree);


                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(14);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:57:5: '.' IDF
                    {
                    dbg.location(57,5);
                    char_literal80=(Token)match(input,30,FOLLOW_30_in_var687); 
                    char_literal80_tree = 
                    (Object)adaptor.create(char_literal80)
                    ;
                    adaptor.addChild(root_0, char_literal80_tree);

                    dbg.location(57,9);
                    IDF81=(Token)match(input,IDF,FOLLOW_IDF_in_var689); 
                    IDF81_tree = 
                    (Object)adaptor.create(IDF81)
                    ;
                    adaptor.addChild(root_0, IDF81_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(15);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(58, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "var");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "var"


    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:61:1: expr : ( '(' expr ')' | ( op ( '(' expr ')' )? )* );
    public final MGPLParser.expr_return expr() throws RecognitionException {
        MGPLParser.expr_return retval = new MGPLParser.expr_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal82=null;
        Token char_literal84=null;
        Token char_literal86=null;
        Token char_literal88=null;
        MGPLParser.expr_return expr83 =null;

        MGPLParser.op_return op85 =null;

        MGPLParser.expr_return expr87 =null;


        Object char_literal82_tree=null;
        Object char_literal84_tree=null;
        Object char_literal86_tree=null;
        Object char_literal88_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(61, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:61:7: ( '(' expr ')' | ( op ( '(' expr ')' )? )* )
            int alt18=2;
            try { dbg.enterDecision(18, decisionCanBacktrack[18]);

            int LA18_0 = input.LA(1);

            if ( (LA18_0==24) ) {
                alt18=1;
            }
            else if ( (LA18_0==IDF||LA18_0==NUMBER||LA18_0==22||LA18_0==25||(LA18_0 >= 28 && LA18_0 <= 29)||LA18_0==32||LA18_0==38||LA18_0==40||LA18_0==42||LA18_0==46) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(18);}

            switch (alt18) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:61:10: '(' expr ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(61,10);
                    char_literal82=(Token)match(input,24,FOLLOW_24_in_expr704); 
                    char_literal82_tree = 
                    (Object)adaptor.create(char_literal82)
                    ;
                    adaptor.addChild(root_0, char_literal82_tree);

                    dbg.location(61,14);
                    pushFollow(FOLLOW_expr_in_expr706);
                    expr83=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr83.getTree());
                    dbg.location(61,19);
                    char_literal84=(Token)match(input,25,FOLLOW_25_in_expr708); 
                    char_literal84_tree = 
                    (Object)adaptor.create(char_literal84)
                    ;
                    adaptor.addChild(root_0, char_literal84_tree);


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:62:4: ( op ( '(' expr ')' )? )*
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(62,4);
                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:62:4: ( op ( '(' expr ')' )? )*
                    try { dbg.enterSubRule(17);

                    loop17:
                    do {
                        int alt17=2;
                        try { dbg.enterDecision(17, decisionCanBacktrack[17]);

                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==IDF) ) {
                            alt17=1;
                        }
                        else if ( (LA17_0==NUMBER||LA17_0==22||LA17_0==29) ) {
                            alt17=1;
                        }


                        } finally {dbg.exitDecision(17);}

                        switch (alt17) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:62:5: op ( '(' expr ')' )?
                    	    {
                    	    dbg.location(62,5);
                    	    pushFollow(FOLLOW_op_in_expr715);
                    	    op85=op();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, op85.getTree());
                    	    dbg.location(62,8);
                    	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:62:8: ( '(' expr ')' )?
                    	    int alt16=2;
                    	    try { dbg.enterSubRule(16);
                    	    try { dbg.enterDecision(16, decisionCanBacktrack[16]);

                    	    int LA16_0 = input.LA(1);

                    	    if ( (LA16_0==24) ) {
                    	        alt16=1;
                    	    }
                    	    } finally {dbg.exitDecision(16);}

                    	    switch (alt16) {
                    	        case 1 :
                    	            dbg.enterAlt(1);

                    	            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:62:9: '(' expr ')'
                    	            {
                    	            dbg.location(62,9);
                    	            char_literal86=(Token)match(input,24,FOLLOW_24_in_expr718); 
                    	            char_literal86_tree = 
                    	            (Object)adaptor.create(char_literal86)
                    	            ;
                    	            adaptor.addChild(root_0, char_literal86_tree);

                    	            dbg.location(62,13);
                    	            pushFollow(FOLLOW_expr_in_expr720);
                    	            expr87=expr();

                    	            state._fsp--;

                    	            adaptor.addChild(root_0, expr87.getTree());
                    	            dbg.location(62,18);
                    	            char_literal88=(Token)match(input,25,FOLLOW_25_in_expr722); 
                    	            char_literal88_tree = 
                    	            (Object)adaptor.create(char_literal88)
                    	            ;
                    	            adaptor.addChild(root_0, char_literal88_tree);


                    	            }
                    	            break;

                    	    }
                    	    } finally {dbg.exitSubRule(16);}


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(17);}


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(62, 26);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expr"


    public static class op_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:63:1: op : konjunkt ( '||' konjunkt )* ;
    public final MGPLParser.op_return op() throws RecognitionException {
        MGPLParser.op_return retval = new MGPLParser.op_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal90=null;
        MGPLParser.konjunkt_return konjunkt89 =null;

        MGPLParser.konjunkt_return konjunkt91 =null;


        Object string_literal90_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "op");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(63, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:63:5: ( konjunkt ( '||' konjunkt )* )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:63:7: konjunkt ( '||' konjunkt )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(63,7);
            pushFollow(FOLLOW_konjunkt_in_op736);
            konjunkt89=konjunkt();

            state._fsp--;

            adaptor.addChild(root_0, konjunkt89.getTree());
            dbg.location(63,16);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:63:16: ( '||' konjunkt )*
            try { dbg.enterSubRule(19);

            loop19:
            do {
                int alt19=2;
                try { dbg.enterDecision(19, decisionCanBacktrack[19]);

                int LA19_0 = input.LA(1);

                if ( (LA19_0==45) ) {
                    alt19=1;
                }


                } finally {dbg.exitDecision(19);}

                switch (alt19) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:63:17: '||' konjunkt
            	    {
            	    dbg.location(63,17);
            	    string_literal90=(Token)match(input,45,FOLLOW_45_in_op739); 
            	    string_literal90_tree = 
            	    (Object)adaptor.create(string_literal90)
            	    ;
            	    adaptor.addChild(root_0, string_literal90_tree);

            	    dbg.location(63,22);
            	    pushFollow(FOLLOW_konjunkt_in_op741);
            	    konjunkt91=konjunkt();

            	    state._fsp--;

            	    adaptor.addChild(root_0, konjunkt91.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);
            } finally {dbg.exitSubRule(19);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(63, 32);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "op");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "op"


    public static class konjunkt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "konjunkt"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:64:1: konjunkt : relat ( '&&' relat )* ;
    public final MGPLParser.konjunkt_return konjunkt() throws RecognitionException {
        MGPLParser.konjunkt_return retval = new MGPLParser.konjunkt_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal93=null;
        MGPLParser.relat_return relat92 =null;

        MGPLParser.relat_return relat94 =null;


        Object string_literal93_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "konjunkt");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(64, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:64:10: ( relat ( '&&' relat )* )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:64:12: relat ( '&&' relat )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(64,12);
            pushFollow(FOLLOW_relat_in_konjunkt751);
            relat92=relat();

            state._fsp--;

            adaptor.addChild(root_0, relat92.getTree());
            dbg.location(64,18);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:64:18: ( '&&' relat )*
            try { dbg.enterSubRule(20);

            loop20:
            do {
                int alt20=2;
                try { dbg.enterDecision(20, decisionCanBacktrack[20]);

                int LA20_0 = input.LA(1);

                if ( (LA20_0==23) ) {
                    alt20=1;
                }


                } finally {dbg.exitDecision(20);}

                switch (alt20) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:64:19: '&&' relat
            	    {
            	    dbg.location(64,19);
            	    string_literal93=(Token)match(input,23,FOLLOW_23_in_konjunkt754); 
            	    string_literal93_tree = 
            	    (Object)adaptor.create(string_literal93)
            	    ;
            	    adaptor.addChild(root_0, string_literal93_tree);

            	    dbg.location(64,24);
            	    pushFollow(FOLLOW_relat_in_konjunkt756);
            	    relat94=relat();

            	    state._fsp--;

            	    adaptor.addChild(root_0, relat94.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);
            } finally {dbg.exitSubRule(20);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(64, 31);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "konjunkt");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "konjunkt"


    public static class relat_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "relat"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:65:1: relat : add ( ( '==' | '<' | '<=' ) add )* ;
    public final MGPLParser.relat_return relat() throws RecognitionException {
        MGPLParser.relat_return retval = new MGPLParser.relat_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set96=null;
        MGPLParser.add_return add95 =null;

        MGPLParser.add_return add97 =null;


        Object set96_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "relat");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(65, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:65:7: ( add ( ( '==' | '<' | '<=' ) add )* )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:65:9: add ( ( '==' | '<' | '<=' ) add )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(65,9);
            pushFollow(FOLLOW_add_in_relat766);
            add95=add();

            state._fsp--;

            adaptor.addChild(root_0, add95.getTree());
            dbg.location(65,13);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:65:13: ( ( '==' | '<' | '<=' ) add )*
            try { dbg.enterSubRule(21);

            loop21:
            do {
                int alt21=2;
                try { dbg.enterDecision(21, decisionCanBacktrack[21]);

                int LA21_0 = input.LA(1);

                if ( ((LA21_0 >= 33 && LA21_0 <= 34)||LA21_0==36) ) {
                    alt21=1;
                }


                } finally {dbg.exitDecision(21);}

                switch (alt21) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:65:14: ( '==' | '<' | '<=' ) add
            	    {
            	    dbg.location(65,14);
            	    set96=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 33 && input.LA(1) <= 34)||input.LA(1)==36 ) {
            	        input.consume();
            	        adaptor.addChild(root_0, 
            	        (Object)adaptor.create(set96)
            	        );
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }

            	    dbg.location(65,34);
            	    pushFollow(FOLLOW_add_in_relat781);
            	    add97=add();

            	    state._fsp--;

            	    adaptor.addChild(root_0, add97.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);
            } finally {dbg.exitSubRule(21);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(65, 39);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "relat");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "relat"


    public static class add_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "add"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:66:1: add : mult ( ( '+' | '-' ) mult )* ;
    public final MGPLParser.add_return add() throws RecognitionException {
        MGPLParser.add_return retval = new MGPLParser.add_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set99=null;
        MGPLParser.mult_return mult98 =null;

        MGPLParser.mult_return mult100 =null;


        Object set99_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "add");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(66, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:66:5: ( mult ( ( '+' | '-' ) mult )* )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:66:7: mult ( ( '+' | '-' ) mult )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(66,7);
            pushFollow(FOLLOW_mult_in_add791);
            mult98=mult();

            state._fsp--;

            adaptor.addChild(root_0, mult98.getTree());
            dbg.location(66,12);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:66:12: ( ( '+' | '-' ) mult )*
            try { dbg.enterSubRule(22);

            loop22:
            do {
                int alt22=2;
                try { dbg.enterDecision(22, decisionCanBacktrack[22]);

                int LA22_0 = input.LA(1);

                if ( (LA22_0==29) ) {
                    alt22=1;
                }
                else if ( (LA22_0==27) ) {
                    alt22=1;
                }


                } finally {dbg.exitDecision(22);}

                switch (alt22) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:66:13: ( '+' | '-' ) mult
            	    {
            	    dbg.location(66,13);
            	    set99=(Token)input.LT(1);

            	    if ( input.LA(1)==27||input.LA(1)==29 ) {
            	        input.consume();
            	        adaptor.addChild(root_0, 
            	        (Object)adaptor.create(set99)
            	        );
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }

            	    dbg.location(66,25);
            	    pushFollow(FOLLOW_mult_in_add802);
            	    mult100=mult();

            	    state._fsp--;

            	    adaptor.addChild(root_0, mult100.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);
            } finally {dbg.exitSubRule(22);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(66, 31);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "add");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "add"


    public static class mult_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mult"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:67:1: mult : unary ( ( '*' | '/' ) unary )* ;
    public final MGPLParser.mult_return mult() throws RecognitionException {
        MGPLParser.mult_return retval = new MGPLParser.mult_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set102=null;
        MGPLParser.unary_return unary101 =null;

        MGPLParser.unary_return unary103 =null;


        Object set102_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "mult");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(67, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:67:6: ( unary ( ( '*' | '/' ) unary )* )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:67:8: unary ( ( '*' | '/' ) unary )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(67,8);
            pushFollow(FOLLOW_unary_in_mult812);
            unary101=unary();

            state._fsp--;

            adaptor.addChild(root_0, unary101.getTree());
            dbg.location(67,14);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:67:14: ( ( '*' | '/' ) unary )*
            try { dbg.enterSubRule(23);

            loop23:
            do {
                int alt23=2;
                try { dbg.enterDecision(23, decisionCanBacktrack[23]);

                int LA23_0 = input.LA(1);

                if ( (LA23_0==26||LA23_0==31) ) {
                    alt23=1;
                }


                } finally {dbg.exitDecision(23);}

                switch (alt23) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:67:15: ( '*' | '/' ) unary
            	    {
            	    dbg.location(67,15);
            	    set102=(Token)input.LT(1);

            	    if ( input.LA(1)==26||input.LA(1)==31 ) {
            	        input.consume();
            	        adaptor.addChild(root_0, 
            	        (Object)adaptor.create(set102)
            	        );
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }

            	    dbg.location(67,28);
            	    pushFollow(FOLLOW_unary_in_mult824);
            	    unary103=unary();

            	    state._fsp--;

            	    adaptor.addChild(root_0, unary103.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);
            } finally {dbg.exitSubRule(23);}


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(67, 35);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "mult");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "mult"


    public static class unary_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unary"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:68:1: unary : ( '!' | '-' )? atom ;
    public final MGPLParser.unary_return unary() throws RecognitionException {
        MGPLParser.unary_return retval = new MGPLParser.unary_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set104=null;
        MGPLParser.atom_return atom105 =null;


        Object set104_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "unary");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(68, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:68:7: ( ( '!' | '-' )? atom )
            dbg.enterAlt(1);

            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:68:9: ( '!' | '-' )? atom
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(68,9);
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:68:9: ( '!' | '-' )?
            int alt24=2;
            try { dbg.enterSubRule(24);
            try { dbg.enterDecision(24, decisionCanBacktrack[24]);

            int LA24_0 = input.LA(1);

            if ( (LA24_0==22||LA24_0==29) ) {
                alt24=1;
            }
            } finally {dbg.exitDecision(24);}

            switch (alt24) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:
                    {
                    dbg.location(68,9);
                    set104=(Token)input.LT(1);

                    if ( input.LA(1)==22||input.LA(1)==29 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set104)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        dbg.recognitionException(mse);
                        throw mse;
                    }


                    }
                    break;

            }
            } finally {dbg.exitSubRule(24);}

            dbg.location(68,22);
            pushFollow(FOLLOW_atom_in_unary843);
            atom105=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom105.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(68, 26);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "unary");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "unary"


    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atom"
    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:69:1: atom : ( NUMBER | var ( TOUCHES var )? );
    public final MGPLParser.atom_return atom() throws RecognitionException {
        MGPLParser.atom_return retval = new MGPLParser.atom_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NUMBER106=null;
        Token TOUCHES108=null;
        MGPLParser.var_return var107 =null;

        MGPLParser.var_return var109 =null;


        Object NUMBER106_tree=null;
        Object TOUCHES108_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "atom");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(69, 0);

        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:69:7: ( NUMBER | var ( TOUCHES var )? )
            int alt26=2;
            try { dbg.enterDecision(26, decisionCanBacktrack[26]);

            int LA26_0 = input.LA(1);

            if ( (LA26_0==NUMBER) ) {
                alt26=1;
            }
            else if ( (LA26_0==IDF) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(26);}

            switch (alt26) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:69:9: NUMBER
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(69,9);
                    NUMBER106=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_atom852); 
                    NUMBER106_tree = 
                    (Object)adaptor.create(NUMBER106)
                    ;
                    adaptor.addChild(root_0, NUMBER106_tree);


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:70:4: var ( TOUCHES var )?
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(70,4);
                    pushFollow(FOLLOW_var_in_atom858);
                    var107=var();

                    state._fsp--;

                    adaptor.addChild(root_0, var107.getTree());
                    dbg.location(70,9);
                    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:70:9: ( TOUCHES var )?
                    int alt25=2;
                    try { dbg.enterSubRule(25);
                    try { dbg.enterDecision(25, decisionCanBacktrack[25]);

                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==TOUCHES) ) {
                        alt25=1;
                    }
                    } finally {dbg.exitDecision(25);}

                    switch (alt25) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:70:10: TOUCHES var
                            {
                            dbg.location(70,10);
                            TOUCHES108=(Token)match(input,TOUCHES,FOLLOW_TOUCHES_in_atom862); 
                            TOUCHES108_tree = 
                            (Object)adaptor.create(TOUCHES108)
                            ;
                            adaptor.addChild(root_0, TOUCHES108_tree);

                            dbg.location(70,18);
                            pushFollow(FOLLOW_var_in_atom864);
                            var109=var();

                            state._fsp--;

                            adaptor.addChild(root_0, var109.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(25);}


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(70, 23);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "atom");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_41_in_prog280 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDF_in_prog282 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_prog284 = new BitSet(new long[]{0x0000000002000100L});
    public static final BitSet FOLLOW_attrAssList_in_prog286 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_prog289 = new BitSet(new long[]{0x0000180000042020L});
    public static final BitSet FOLLOW_decl_in_prog291 = new BitSet(new long[]{0x0000180000042020L});
    public static final BitSet FOLLOW_stmtBlock_in_prog294 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_block_in_prog296 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_varDecl_in_decl312 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decl314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objDecl_in_decl318 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decl320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_varDecl332 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDF_in_varDecl334 = new BitSet(new long[]{0x0000002800000002L});
    public static final BitSet FOLLOW_init_in_varDecl337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_varDecl342 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_in_varDecl344 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_varDecl346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_init363 = new BitSet(new long[]{0x0000000021400900L});
    public static final BitSet FOLLOW_expr_in_init365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objType_in_objDecl378 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDF_in_objDecl380 = new BitSet(new long[]{0x0000002001000000L});
    public static final BitSet FOLLOW_24_in_objDecl383 = new BitSet(new long[]{0x0000000002000100L});
    public static final BitSet FOLLOW_attrAssList_in_objDecl385 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objDecl388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_objDecl392 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_in_objDecl394 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_objDecl396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrAss_in_attrAssList425 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_attrAssList428 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_attrAss_in_attrAssList430 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_IDF_in_attrAss440 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_attrAss442 = new BitSet(new long[]{0x0000000021400900L});
    public static final BitSet FOLLOW_expr_in_attrAss444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_animBlock_in_block459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eventBlock_in_block463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANIMATION_in_animBlock473 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDF_in_animBlock475 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_animBlock477 = new BitSet(new long[]{0x0000000000042020L});
    public static final BitSet FOLLOW_objType_in_animBlock479 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDF_in_animBlock481 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_animBlock483 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_stmtBlock_in_animBlock485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ON_in_eventBlock495 = new BitSet(new long[]{0x0000000000094280L});
    public static final BitSet FOLLOW_keyStroke_in_eventBlock497 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_stmtBlock_in_eventBlock499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_stmtBlock545 = new BitSet(new long[]{0x0000450000000100L});
    public static final BitSet FOLLOW_stmt_in_stmtBlock547 = new BitSet(new long[]{0x0000450000000100L});
    public static final BitSet FOLLOW_46_in_stmtBlock550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStmt_in_stmt566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStmt_in_stmt570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assStmt_in_stmt574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ifStmt587 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ifStmt589 = new BitSet(new long[]{0x0000000023400900L});
    public static final BitSet FOLLOW_expr_in_ifStmt591 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ifStmt593 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_stmtBlock_in_ifStmt595 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ifStmt599 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_stmtBlock_in_ifStmt601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_forStmt616 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_forStmt618 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_assStmt_in_forStmt620 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_forStmt622 = new BitSet(new long[]{0x0000000121400900L});
    public static final BitSet FOLLOW_expr_in_forStmt624 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_forStmt626 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_assStmt_in_forStmt628 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_forStmt630 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_stmtBlock_in_forStmt632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_assStmt640 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_assStmt642 = new BitSet(new long[]{0x0000000021400900L});
    public static final BitSet FOLLOW_expr_in_assStmt644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDF_in_var664 = new BitSet(new long[]{0x0000002040000002L});
    public static final BitSet FOLLOW_37_in_var668 = new BitSet(new long[]{0x0000004021400900L});
    public static final BitSet FOLLOW_expr_in_var670 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_var672 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_var676 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDF_in_var678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_var687 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDF_in_var689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_expr704 = new BitSet(new long[]{0x0000000023400900L});
    public static final BitSet FOLLOW_expr_in_expr706 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_expr708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_in_expr715 = new BitSet(new long[]{0x0000000021400902L});
    public static final BitSet FOLLOW_24_in_expr718 = new BitSet(new long[]{0x0000000023400900L});
    public static final BitSet FOLLOW_expr_in_expr720 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_expr722 = new BitSet(new long[]{0x0000000020400902L});
    public static final BitSet FOLLOW_konjunkt_in_op736 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_op739 = new BitSet(new long[]{0x0000000020400900L});
    public static final BitSet FOLLOW_konjunkt_in_op741 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_relat_in_konjunkt751 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_konjunkt754 = new BitSet(new long[]{0x0000000020400900L});
    public static final BitSet FOLLOW_relat_in_konjunkt756 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_add_in_relat766 = new BitSet(new long[]{0x0000001600000002L});
    public static final BitSet FOLLOW_set_in_relat769 = new BitSet(new long[]{0x0000000020400900L});
    public static final BitSet FOLLOW_add_in_relat781 = new BitSet(new long[]{0x0000001600000002L});
    public static final BitSet FOLLOW_mult_in_add791 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_set_in_add794 = new BitSet(new long[]{0x0000000020400900L});
    public static final BitSet FOLLOW_mult_in_add802 = new BitSet(new long[]{0x0000000028000002L});
    public static final BitSet FOLLOW_unary_in_mult812 = new BitSet(new long[]{0x0000000084000002L});
    public static final BitSet FOLLOW_set_in_mult815 = new BitSet(new long[]{0x0000000020400900L});
    public static final BitSet FOLLOW_unary_in_mult824 = new BitSet(new long[]{0x0000000084000002L});
    public static final BitSet FOLLOW_atom_in_unary843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_atom852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_atom858 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_TOUCHES_in_atom862 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_var_in_atom864 = new BitSet(new long[]{0x0000000000000002L});

}