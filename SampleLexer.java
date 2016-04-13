// $ANTLR 3.5.1 C:\\Users\\Seema\\Desktop\\Sample.g 2016-04-11 23:58:05

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SampleLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
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
	public static final int COMMENT=4;
	public static final int IDENT=5;
	public static final int INT=6;
	public static final int WS=7;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public SampleLexer() {} 
	public SampleLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public SampleLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\Seema\\Desktop\\Sample.g"; }

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:2:6: ( '!' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:2:8: '!'
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
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:3:6: ( '!=' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:3:8: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:4:7: ( '%' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:4:9: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:5:7: ( '(' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:5:9: '('
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
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:6:7: ( ')' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:6:9: ')'
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:7:7: ( '*' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:7:9: '*'
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:8:7: ( '+' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:8:9: '+'
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:9:7: ( ',' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:9:9: ','
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:10:7: ( '-' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:10:9: '-'
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:11:7: ( '/' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:11:9: '/'
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:12:7: ( '<' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:12:9: '<'
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:13:7: ( '<=' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:13:9: '<='
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:14:7: ( '=' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:14:9: '='
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:15:7: ( '>' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:15:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:16:7: ( '>=' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:16:9: '>='
			{
			match(">="); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:17:7: ( 'AND' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:17:9: 'AND'
			{
			match("AND"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:18:7: ( 'BEGIN' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:18:9: 'BEGIN'
			{
			match("BEGIN"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:19:7: ( 'END' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:19:9: 'END'
			{
			match("END"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:20:7: ( 'OR' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:20:9: 'OR'
			{
			match("OR"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:21:7: ( '[' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:21:9: '['
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:22:7: ( ']' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:22:9: ']'
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:23:7: ( 'bool' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:23:9: 'bool'
			{
			match("bool"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:24:7: ( 'ch' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:24:9: 'ch'
			{
			match("ch"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:25:7: ( 'do' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:25:9: 'do'
			{
			match("do"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:26:7: ( 'else' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:26:9: 'else'
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
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:27:7: ( 'elseif' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:27:9: 'elseif'
			{
			match("elseif"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:28:7: ( 'endif' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:28:9: 'endif'
			{
			match("endif"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:29:7: ( 'function' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:29:9: 'function'
			{
			match("function"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:30:7: ( 'if' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:30:9: 'if'
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
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:31:7: ( 'int' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:31:9: 'int'
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
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:32:7: ( 'return' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:32:9: 'return'
			{
			match("return"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:33:7: ( 'string' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:33:9: 'string'
			{
			match("string"); 

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
			// C:\\Users\\Seema\\Desktop\\Sample.g:34:7: ( 'while' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:34:9: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__40"

	// $ANTLR start "IDENT"
	public final void mIDENT() throws RecognitionException {
		try {
			int _type = IDENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:123:8: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// C:\\Users\\Seema\\Desktop\\Sample.g:123:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Seema\\Desktop\\Sample.g:123:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Seema\\Desktop\\Sample.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENT"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:125:5: ( ( '0' .. '9' )+ )
			// C:\\Users\\Seema\\Desktop\\Sample.g:125:10: ( '0' .. '9' )+
			{
			// C:\\Users\\Seema\\Desktop\\Sample.g:125:10: ( '0' .. '9' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\Seema\\Desktop\\Sample.g:
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
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:127:4: ( ( ' ' | '\\n' )+ )
			// C:\\Users\\Seema\\Desktop\\Sample.g:127:7: ( ' ' | '\\n' )+
			{
			// C:\\Users\\Seema\\Desktop\\Sample.g:127:7: ( ' ' | '\\n' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\n'||LA3_0==' ') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\Seema\\Desktop\\Sample.g:
					{
					if ( input.LA(1)=='\n'||input.LA(1)==' ' ) {
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
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Seema\\Desktop\\Sample.g:129:9: ( '/*' ( . )* '/*' )
			// C:\\Users\\Seema\\Desktop\\Sample.g:129:12: '/*' ( . )* '/*'
			{
			match("/*"); 

			// C:\\Users\\Seema\\Desktop\\Sample.g:129:17: ( . )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='/') ) {
					int LA4_1 = input.LA(2);
					if ( (LA4_1=='*') ) {
						alt4=2;
					}
					else if ( ((LA4_1 >= '\u0000' && LA4_1 <= ')')||(LA4_1 >= '+' && LA4_1 <= '\uFFFF')) ) {
						alt4=1;
					}

				}
				else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '.')||(LA4_0 >= '0' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Seema\\Desktop\\Sample.g:129:17: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop4;
				}
			}

			match("/*"); 

			_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\Seema\\Desktop\\Sample.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | IDENT | INT | WS | COMMENT )
		int alt5=37;
		alt5 = dfa5.predict(input);
		switch (alt5) {
			case 1 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:10: T__8
				{
				mT__8(); 

				}
				break;
			case 2 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:15: T__9
				{
				mT__9(); 

				}
				break;
			case 3 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:20: T__10
				{
				mT__10(); 

				}
				break;
			case 4 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:26: T__11
				{
				mT__11(); 

				}
				break;
			case 5 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:32: T__12
				{
				mT__12(); 

				}
				break;
			case 6 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:38: T__13
				{
				mT__13(); 

				}
				break;
			case 7 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:44: T__14
				{
				mT__14(); 

				}
				break;
			case 8 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:50: T__15
				{
				mT__15(); 

				}
				break;
			case 9 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:56: T__16
				{
				mT__16(); 

				}
				break;
			case 10 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:62: T__17
				{
				mT__17(); 

				}
				break;
			case 11 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:68: T__18
				{
				mT__18(); 

				}
				break;
			case 12 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:74: T__19
				{
				mT__19(); 

				}
				break;
			case 13 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:80: T__20
				{
				mT__20(); 

				}
				break;
			case 14 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:86: T__21
				{
				mT__21(); 

				}
				break;
			case 15 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:92: T__22
				{
				mT__22(); 

				}
				break;
			case 16 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:98: T__23
				{
				mT__23(); 

				}
				break;
			case 17 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:104: T__24
				{
				mT__24(); 

				}
				break;
			case 18 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:110: T__25
				{
				mT__25(); 

				}
				break;
			case 19 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:116: T__26
				{
				mT__26(); 

				}
				break;
			case 20 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:122: T__27
				{
				mT__27(); 

				}
				break;
			case 21 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:128: T__28
				{
				mT__28(); 

				}
				break;
			case 22 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:134: T__29
				{
				mT__29(); 

				}
				break;
			case 23 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:140: T__30
				{
				mT__30(); 

				}
				break;
			case 24 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:146: T__31
				{
				mT__31(); 

				}
				break;
			case 25 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:152: T__32
				{
				mT__32(); 

				}
				break;
			case 26 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:158: T__33
				{
				mT__33(); 

				}
				break;
			case 27 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:164: T__34
				{
				mT__34(); 

				}
				break;
			case 28 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:170: T__35
				{
				mT__35(); 

				}
				break;
			case 29 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:176: T__36
				{
				mT__36(); 

				}
				break;
			case 30 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:182: T__37
				{
				mT__37(); 

				}
				break;
			case 31 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:188: T__38
				{
				mT__38(); 

				}
				break;
			case 32 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:194: T__39
				{
				mT__39(); 

				}
				break;
			case 33 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:200: T__40
				{
				mT__40(); 

				}
				break;
			case 34 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:206: IDENT
				{
				mIDENT(); 

				}
				break;
			case 35 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:212: INT
				{
				mINT(); 

				}
				break;
			case 36 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:216: WS
				{
				mWS(); 

				}
				break;
			case 37 :
				// C:\\Users\\Seema\\Desktop\\Sample.g:1:219: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}


	protected DFA5 dfa5 = new DFA5(this);
	static final String DFA5_eotS =
		"\1\uffff\1\40\7\uffff\1\42\1\44\1\uffff\1\46\4\34\2\uffff\11\34\13\uffff"+
		"\3\34\1\71\1\34\1\73\1\74\3\34\1\100\4\34\1\105\1\34\1\107\1\uffff\1\34"+
		"\2\uffff\3\34\1\uffff\1\114\3\34\1\uffff\1\34\1\uffff\1\121\1\123\2\34"+
		"\1\uffff\3\34\1\131\1\uffff\1\34\1\uffff\1\133\3\34\1\137\1\uffff\1\140"+
		"\1\uffff\1\34\1\142\1\143\2\uffff\1\34\2\uffff\1\145\1\uffff";
	static final String DFA5_eofS =
		"\146\uffff";
	static final String DFA5_minS =
		"\1\12\1\75\7\uffff\1\52\1\75\1\uffff\1\75\1\116\1\105\1\116\1\122\2\uffff"+
		"\1\157\1\150\1\157\1\154\1\165\1\146\1\145\1\164\1\150\13\uffff\1\104"+
		"\1\107\1\104\1\60\1\157\2\60\1\163\1\144\1\156\1\60\2\164\1\162\1\151"+
		"\1\60\1\111\1\60\1\uffff\1\154\2\uffff\1\145\1\151\1\143\1\uffff\1\60"+
		"\1\165\1\151\1\154\1\uffff\1\116\1\uffff\2\60\1\146\1\164\1\uffff\1\162"+
		"\1\156\1\145\1\60\1\uffff\1\146\1\uffff\1\60\1\151\1\156\1\147\1\60\1"+
		"\uffff\1\60\1\uffff\1\157\2\60\2\uffff\1\156\2\uffff\1\60\1\uffff";
	static final String DFA5_maxS =
		"\1\172\1\75\7\uffff\1\52\1\75\1\uffff\1\75\1\116\1\105\1\116\1\122\2\uffff"+
		"\1\157\1\150\1\157\1\156\1\165\1\156\1\145\1\164\1\150\13\uffff\1\104"+
		"\1\107\1\104\1\172\1\157\2\172\1\163\1\144\1\156\1\172\2\164\1\162\1\151"+
		"\1\172\1\111\1\172\1\uffff\1\154\2\uffff\1\145\1\151\1\143\1\uffff\1\172"+
		"\1\165\1\151\1\154\1\uffff\1\116\1\uffff\2\172\1\146\1\164\1\uffff\1\162"+
		"\1\156\1\145\1\172\1\uffff\1\146\1\uffff\1\172\1\151\1\156\1\147\1\172"+
		"\1\uffff\1\172\1\uffff\1\157\2\172\2\uffff\1\156\2\uffff\1\172\1\uffff";
	static final String DFA5_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\2\uffff\1\15\5\uffff\1\24\1\25"+
		"\11\uffff\1\42\1\43\1\44\1\2\1\1\1\45\1\12\1\14\1\13\1\17\1\16\22\uffff"+
		"\1\23\1\uffff\1\27\1\30\3\uffff\1\35\4\uffff\1\20\1\uffff\1\22\4\uffff"+
		"\1\36\4\uffff\1\26\1\uffff\1\31\5\uffff\1\21\1\uffff\1\33\3\uffff\1\41"+
		"\1\32\1\uffff\1\37\1\40\1\uffff\1\34";
	static final String DFA5_specialS =
		"\146\uffff}>";
	static final String[] DFA5_transitionS = {
			"\1\36\25\uffff\1\36\1\1\3\uffff\1\2\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10"+
			"\1\uffff\1\11\12\35\2\uffff\1\12\1\13\1\14\2\uffff\1\15\1\16\2\34\1\17"+
			"\11\34\1\20\13\34\1\21\1\uffff\1\22\3\uffff\1\34\1\23\1\24\1\25\1\26"+
			"\1\27\2\34\1\30\10\34\1\31\1\32\3\34\1\33\3\34",
			"\1\37",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\41",
			"\1\43",
			"",
			"\1\45",
			"\1\47",
			"\1\50",
			"\1\51",
			"\1\52",
			"",
			"",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56\1\uffff\1\57",
			"\1\60",
			"\1\61\7\uffff\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\66",
			"\1\67",
			"\1\70",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"\1\72",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"\1\75",
			"\1\76",
			"\1\77",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"\1\106",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"",
			"\1\110",
			"",
			"",
			"\1\111",
			"\1\112",
			"\1\113",
			"",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"\1\115",
			"\1\116",
			"\1\117",
			"",
			"\1\120",
			"",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"\12\34\7\uffff\32\34\6\uffff\10\34\1\122\21\34",
			"\1\124",
			"\1\125",
			"",
			"\1\126",
			"\1\127",
			"\1\130",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"",
			"\1\132",
			"",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"\1\134",
			"\1\135",
			"\1\136",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"",
			"\1\141",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			"",
			"",
			"\1\144",
			"",
			"",
			"\12\34\7\uffff\32\34\6\uffff\32\34",
			""
	};

	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;

	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	protected class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | IDENT | INT | WS | COMMENT );";
		}
	}

}
