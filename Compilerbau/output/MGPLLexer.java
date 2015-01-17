// $ANTLR 3.4 /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g 2014-12-03 17:03:47

package antlr.projekt2;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MGPLLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public MGPLLexer() {} 
    public MGPLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MGPLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/nvetter/Projekte/Uni/Compilerbau/MGPL.g"; }

    // $ANTLR start "ANIMATION"
    public final void mANIMATION() throws RecognitionException {
        try {
            int _type = ANIMATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:6:11: ( 'animation' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:6:13: 'animation'
            {
            match("animation"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ANIMATION"

    // $ANTLR start "CIRCLE"
    public final void mCIRCLE() throws RecognitionException {
        try {
            int _type = CIRCLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:7:8: ( 'circle' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:7:10: 'circle'
            {
            match("circle"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CIRCLE"

    // $ANTLR start "DOWNARROW"
    public final void mDOWNARROW() throws RecognitionException {
        try {
            int _type = DOWNARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:8:11: ( 'downarrow' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:8:13: 'downarrow'
            {
            match("downarrow"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOWNARROW"

    // $ANTLR start "LEFTARROW"
    public final void mLEFTARROW() throws RecognitionException {
        try {
            int _type = LEFTARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:9:11: ( 'leftarrow' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:9:13: 'leftarrow'
            {
            match("leftarrow"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFTARROW"

    // $ANTLR start "ON"
    public final void mON() throws RecognitionException {
        try {
            int _type = ON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:10:4: ( 'on' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:10:6: 'on'
            {
            match("on"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ON"

    // $ANTLR start "RECTANGLE"
    public final void mRECTANGLE() throws RecognitionException {
        try {
            int _type = RECTANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:11:11: ( 'rectangle' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:11:13: 'rectangle'
            {
            match("rectangle"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RECTANGLE"

    // $ANTLR start "RIGHTARROW"
    public final void mRIGHTARROW() throws RecognitionException {
        try {
            int _type = RIGHTARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:12:12: ( 'rightarrow' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:12:14: 'rightarrow'
            {
            match("rightarrow"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHTARROW"

    // $ANTLR start "SPACE"
    public final void mSPACE() throws RecognitionException {
        try {
            int _type = SPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:13:7: ( 'space' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:13:9: 'space'
            {
            match("space"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPACE"

    // $ANTLR start "TOUCHES"
    public final void mTOUCHES() throws RecognitionException {
        try {
            int _type = TOUCHES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:14:9: ( 'touches' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:14:11: 'touches'
            {
            match("touches"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TOUCHES"

    // $ANTLR start "TRIANGLE"
    public final void mTRIANGLE() throws RecognitionException {
        try {
            int _type = TRIANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:15:10: ( 'triangle' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:15:12: 'triangle'
            {
            match("triangle"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRIANGLE"

    // $ANTLR start "UPARROW"
    public final void mUPARROW() throws RecognitionException {
        try {
            int _type = UPARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:16:9: ( 'uparrow' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:16:11: 'uparrow'
            {
            match("uparrow"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UPARROW"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:17:7: ( '!' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:17:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:18:7: ( '&&' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:18:9: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:19:7: ( '(' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:19:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:20:7: ( ')' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:20:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:21:7: ( '*' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:21:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:22:7: ( '+' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:22:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:23:7: ( ',' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:23:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:24:7: ( '-' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:24:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:25:7: ( '.' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:25:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:26:7: ( '/' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:26:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:27:7: ( ';' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:27:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:28:7: ( '<' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:28:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:29:7: ( '<=' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:29:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:30:7: ( '=' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:30:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:31:7: ( '==' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:31:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:32:7: ( '[' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:32:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:33:7: ( ']' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:33:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:34:7: ( 'else' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:34:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:35:7: ( 'for' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:35:9: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:36:7: ( 'game' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:36:9: 'game'
            {
            match("game"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:37:7: ( 'if' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:37:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:38:7: ( 'int' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:38:9: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:39:7: ( '{' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:39:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:40:7: ( '||' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:40:9: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:41:7: ( '}' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:41:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "IDF"
    public final void mIDF() throws RecognitionException {
        try {
            int _type = IDF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:73:22: ( ( LOWCASE | UPCASE ) ( '_' | DIGIT | LOWCASE | UPCASE )* )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:73:26: ( LOWCASE | UPCASE ) ( '_' | DIGIT | LOWCASE | UPCASE )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:73:46: ( '_' | DIGIT | LOWCASE | UPCASE )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDF"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:74:22: ( ( DIGIT )+ )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:74:26: ( DIGIT )+
            {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:74:26: ( DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "LOWCASE"
    public final void mLOWCASE() throws RecognitionException {
        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:75:22: ( 'a' .. 'z' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:
            {
            if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOWCASE"

    // $ANTLR start "UPCASE"
    public final void mUPCASE() throws RecognitionException {
        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:76:22: ( 'A' .. 'Z' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UPCASE"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:77:22: ( '0' .. '9' )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:78:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:78:7: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "SINGLE_COMMENT"
    public final void mSINGLE_COMMENT() throws RecognitionException {
        try {
            int _type = SINGLE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:81:16: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:81:18: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); 



            // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:81:23: (~ ( '\\r' | '\\n' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


             skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SINGLE_COMMENT"

    public void mTokens() throws RecognitionException {
        // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:8: ( ANIMATION | CIRCLE | DOWNARROW | LEFTARROW | ON | RECTANGLE | RIGHTARROW | SPACE | TOUCHES | TRIANGLE | UPARROW | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | IDF | NUMBER | WS | SINGLE_COMMENT )
        int alt4=40;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:10: ANIMATION
                {
                mANIMATION(); 


                }
                break;
            case 2 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:20: CIRCLE
                {
                mCIRCLE(); 


                }
                break;
            case 3 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:27: DOWNARROW
                {
                mDOWNARROW(); 


                }
                break;
            case 4 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:37: LEFTARROW
                {
                mLEFTARROW(); 


                }
                break;
            case 5 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:47: ON
                {
                mON(); 


                }
                break;
            case 6 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:50: RECTANGLE
                {
                mRECTANGLE(); 


                }
                break;
            case 7 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:60: RIGHTARROW
                {
                mRIGHTARROW(); 


                }
                break;
            case 8 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:71: SPACE
                {
                mSPACE(); 


                }
                break;
            case 9 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:77: TOUCHES
                {
                mTOUCHES(); 


                }
                break;
            case 10 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:85: TRIANGLE
                {
                mTRIANGLE(); 


                }
                break;
            case 11 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:94: UPARROW
                {
                mUPARROW(); 


                }
                break;
            case 12 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:102: T__22
                {
                mT__22(); 


                }
                break;
            case 13 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:108: T__23
                {
                mT__23(); 


                }
                break;
            case 14 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:114: T__24
                {
                mT__24(); 


                }
                break;
            case 15 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:120: T__25
                {
                mT__25(); 


                }
                break;
            case 16 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:126: T__26
                {
                mT__26(); 


                }
                break;
            case 17 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:132: T__27
                {
                mT__27(); 


                }
                break;
            case 18 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:138: T__28
                {
                mT__28(); 


                }
                break;
            case 19 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:144: T__29
                {
                mT__29(); 


                }
                break;
            case 20 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:150: T__30
                {
                mT__30(); 


                }
                break;
            case 21 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:156: T__31
                {
                mT__31(); 


                }
                break;
            case 22 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:162: T__32
                {
                mT__32(); 


                }
                break;
            case 23 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:168: T__33
                {
                mT__33(); 


                }
                break;
            case 24 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:174: T__34
                {
                mT__34(); 


                }
                break;
            case 25 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:180: T__35
                {
                mT__35(); 


                }
                break;
            case 26 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:186: T__36
                {
                mT__36(); 


                }
                break;
            case 27 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:192: T__37
                {
                mT__37(); 


                }
                break;
            case 28 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:198: T__38
                {
                mT__38(); 


                }
                break;
            case 29 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:204: T__39
                {
                mT__39(); 


                }
                break;
            case 30 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:210: T__40
                {
                mT__40(); 


                }
                break;
            case 31 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:216: T__41
                {
                mT__41(); 


                }
                break;
            case 32 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:222: T__42
                {
                mT__42(); 


                }
                break;
            case 33 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:228: T__43
                {
                mT__43(); 


                }
                break;
            case 34 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:234: T__44
                {
                mT__44(); 


                }
                break;
            case 35 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:240: T__45
                {
                mT__45(); 


                }
                break;
            case 36 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:246: T__46
                {
                mT__46(); 


                }
                break;
            case 37 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:252: IDF
                {
                mIDF(); 


                }
                break;
            case 38 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:256: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 39 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:263: WS
                {
                mWS(); 


                }
                break;
            case 40 :
                // /home/nvetter/Projekte/Uni/Compilerbau/MGPL.g:1:266: SINGLE_COMMENT
                {
                mSINGLE_COMMENT(); 


                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\1\uffff\11\40\11\uffff\1\57\1\uffff\1\61\1\63\2\uffff\4\40\6\uffff"+
        "\4\40\1\75\6\40\6\uffff\3\40\1\107\5\40\1\uffff\7\40\1\124\1\40"+
        "\1\uffff\1\126\12\40\1\141\1\uffff\1\142\1\uffff\6\40\1\151\3\40"+
        "\2\uffff\1\40\1\156\4\40\1\uffff\4\40\1\uffff\4\40\1\173\1\40\1"+
        "\175\5\40\1\uffff\1\u0083\1\uffff\1\u0084\1\u0085\1\u0086\1\u0087"+
        "\1\40\5\uffff\1\u0089\1\uffff";
    static final String DFA4_eofS =
        "\u008a\uffff";
    static final String DFA4_minS =
        "\1\11\1\156\1\151\1\157\1\145\1\156\1\145\1\160\1\157\1\160\11\uffff"+
        "\1\57\1\uffff\2\75\2\uffff\1\154\1\157\1\141\1\146\6\uffff\1\151"+
        "\1\162\1\167\1\146\1\60\1\143\1\147\1\141\1\165\1\151\1\141\6\uffff"+
        "\1\163\1\162\1\155\1\60\1\164\1\155\1\143\1\156\1\164\1\uffff\1"+
        "\164\1\150\2\143\1\141\1\162\1\145\1\60\1\145\1\uffff\1\60\1\141"+
        "\1\154\3\141\1\164\1\145\1\150\1\156\1\162\1\60\1\uffff\1\60\1\uffff"+
        "\1\164\1\145\2\162\1\156\1\141\1\60\1\145\1\147\1\157\2\uffff\1"+
        "\151\1\60\2\162\1\147\1\162\1\uffff\1\163\1\154\1\167\1\157\1\uffff"+
        "\2\157\1\154\1\162\1\60\1\145\1\60\1\156\2\167\1\145\1\157\1\uffff"+
        "\1\60\1\uffff\4\60\1\167\5\uffff\1\60\1\uffff";
    static final String DFA4_maxS =
        "\1\175\1\156\1\151\1\157\1\145\1\156\1\151\1\160\1\162\1\160\11"+
        "\uffff\1\57\1\uffff\2\75\2\uffff\1\154\1\157\1\141\1\156\6\uffff"+
        "\1\151\1\162\1\167\1\146\1\172\1\143\1\147\1\141\1\165\1\151\1\141"+
        "\6\uffff\1\163\1\162\1\155\1\172\1\164\1\155\1\143\1\156\1\164\1"+
        "\uffff\1\164\1\150\2\143\1\141\1\162\1\145\1\172\1\145\1\uffff\1"+
        "\172\1\141\1\154\3\141\1\164\1\145\1\150\1\156\1\162\1\172\1\uffff"+
        "\1\172\1\uffff\1\164\1\145\2\162\1\156\1\141\1\172\1\145\1\147\1"+
        "\157\2\uffff\1\151\1\172\2\162\1\147\1\162\1\uffff\1\163\1\154\1"+
        "\167\1\157\1\uffff\2\157\1\154\1\162\1\172\1\145\1\172\1\156\2\167"+
        "\1\145\1\157\1\uffff\1\172\1\uffff\4\172\1\167\5\uffff\1\172\1\uffff";
    static final String DFA4_acceptS =
        "\12\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\uffff\1"+
        "\26\2\uffff\1\33\1\34\4\uffff\1\42\1\43\1\44\1\45\1\46\1\47\13\uffff"+
        "\1\50\1\25\1\30\1\27\1\32\1\31\11\uffff\1\5\11\uffff\1\40\14\uffff"+
        "\1\36\1\uffff\1\41\12\uffff\1\35\1\37\6\uffff\1\10\4\uffff\1\2\14"+
        "\uffff\1\11\1\uffff\1\13\5\uffff\1\12\1\1\1\3\1\4\1\6\1\uffff\1"+
        "\7";
    static final String DFA4_specialS =
        "\u008a\uffff}>";
    static final String[] DFA4_transitionS = {
            "\2\42\1\uffff\2\42\22\uffff\1\42\1\12\4\uffff\1\13\1\uffff\1"+
            "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\12\41\1\uffff\1\24\1"+
            "\25\1\26\3\uffff\32\40\1\27\1\uffff\1\30\3\uffff\1\1\1\40\1"+
            "\2\1\3\1\31\1\32\1\33\1\40\1\34\2\40\1\4\2\40\1\5\2\40\1\6\1"+
            "\7\1\10\1\11\5\40\1\35\1\36\1\37",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50\3\uffff\1\51",
            "\1\52",
            "\1\53\2\uffff\1\54",
            "\1\55",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\56",
            "",
            "\1\60",
            "\1\62",
            "",
            "",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67\7\uffff\1\70",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\104",
            "\1\105",
            "\1\106",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\125",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\152",
            "\1\153",
            "\1\154",
            "",
            "",
            "\1\155",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\174",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u0088",
            "",
            "",
            "",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ANIMATION | CIRCLE | DOWNARROW | LEFTARROW | ON | RECTANGLE | RIGHTARROW | SPACE | TOUCHES | TRIANGLE | UPARROW | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | IDF | NUMBER | WS | SINGLE_COMMENT );";
        }
    }
 

}