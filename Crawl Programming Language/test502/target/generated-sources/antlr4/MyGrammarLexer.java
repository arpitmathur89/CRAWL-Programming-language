// Generated from MyGrammar.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, NUMBER=28, RELOP=29, EQ=30, NEQ=31, LE=32, 
		LEQ=33, GE=34, GEQ=35, BOOLEAN=36, IDENT=37, STRING=38, WS=39, COMMENT=40;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "NUMBER", "DIGIT", "LETTER", "RELOP", "EQ", "NEQ", "LE", 
		"LEQ", "GE", "GEQ", "BOOLEAN", "IDENT", "STRING", "WS", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'endif'", "'if'", "'('", "')'", "'else'", "'while'", "'endwhile'", 
		"'display'", "','", "'function'", "'{'", "'}'", "'return'", "'/'", "'*'", 
		"'+'", "'-'", "'int'", "'bool'", "'stack'", "'.push'", "'.pop()'", "'.peek()'", 
		"'.isEmpty()'", "'BEGIN'", "'END'", null, null, "'=='", "'!='", "'<'", 
		"'<='", "'>'", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "NUMBER", "RELOP", "EQ", "NEQ", "LE", "LEQ", "GE", 
		"GEQ", "BOOLEAN", "IDENT", "STRING", "WS", "COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MyGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MyGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u0133\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\6\35\u00db\n\35\r\35\16\35\u00dc"+
		"\3\36\6\36\u00e0\n\36\r\36\16\36\u00e1\3\37\3\37\3 \3 \3 \3 \3 \3 \5 "+
		"\u00ec\n \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0107\n\'\3(\3(\7(\u010b\n(\f(\16(\u010e"+
		"\13(\3(\7(\u0111\n(\f(\16(\u0114\13(\3)\3)\7)\u0118\n)\f)\16)\u011b\13"+
		")\3)\3)\3*\6*\u0120\n*\r*\16*\u0121\3*\3*\3+\3+\3+\3+\7+\u012a\n+\f+\16"+
		"+\u012d\13+\3+\3+\3+\3+\3+\4\u0119\u012b\2,\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\2=\2?\37A C!E\"G#I$K%M&O\'Q("+
		"S)U*\3\2\4\4\2C\\c|\5\2\13\f\17\17\"\"\u013d\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5Y\3\2\2\2\7_\3\2\2\2\tb\3"+
		"\2\2\2\13d\3\2\2\2\rf\3\2\2\2\17k\3\2\2\2\21q\3\2\2\2\23z\3\2\2\2\25\u0082"+
		"\3\2\2\2\27\u0084\3\2\2\2\31\u008d\3\2\2\2\33\u008f\3\2\2\2\35\u0091\3"+
		"\2\2\2\37\u0098\3\2\2\2!\u009a\3\2\2\2#\u009c\3\2\2\2%\u009e\3\2\2\2\'"+
		"\u00a0\3\2\2\2)\u00a4\3\2\2\2+\u00a9\3\2\2\2-\u00af\3\2\2\2/\u00b5\3\2"+
		"\2\2\61\u00bc\3\2\2\2\63\u00c4\3\2\2\2\65\u00cf\3\2\2\2\67\u00d5\3\2\2"+
		"\29\u00da\3\2\2\2;\u00df\3\2\2\2=\u00e3\3\2\2\2?\u00eb\3\2\2\2A\u00ed"+
		"\3\2\2\2C\u00f0\3\2\2\2E\u00f3\3\2\2\2G\u00f5\3\2\2\2I\u00f8\3\2\2\2K"+
		"\u00fa\3\2\2\2M\u0106\3\2\2\2O\u0108\3\2\2\2Q\u0115\3\2\2\2S\u011f\3\2"+
		"\2\2U\u0125\3\2\2\2WX\7?\2\2X\4\3\2\2\2YZ\7g\2\2Z[\7p\2\2[\\\7f\2\2\\"+
		"]\7k\2\2]^\7h\2\2^\6\3\2\2\2_`\7k\2\2`a\7h\2\2a\b\3\2\2\2bc\7*\2\2c\n"+
		"\3\2\2\2de\7+\2\2e\f\3\2\2\2fg\7g\2\2gh\7n\2\2hi\7u\2\2ij\7g\2\2j\16\3"+
		"\2\2\2kl\7y\2\2lm\7j\2\2mn\7k\2\2no\7n\2\2op\7g\2\2p\20\3\2\2\2qr\7g\2"+
		"\2rs\7p\2\2st\7f\2\2tu\7y\2\2uv\7j\2\2vw\7k\2\2wx\7n\2\2xy\7g\2\2y\22"+
		"\3\2\2\2z{\7f\2\2{|\7k\2\2|}\7u\2\2}~\7r\2\2~\177\7n\2\2\177\u0080\7c"+
		"\2\2\u0080\u0081\7{\2\2\u0081\24\3\2\2\2\u0082\u0083\7.\2\2\u0083\26\3"+
		"\2\2\2\u0084\u0085\7h\2\2\u0085\u0086\7w\2\2\u0086\u0087\7p\2\2\u0087"+
		"\u0088\7e\2\2\u0088\u0089\7v\2\2\u0089\u008a\7k\2\2\u008a\u008b\7q\2\2"+
		"\u008b\u008c\7p\2\2\u008c\30\3\2\2\2\u008d\u008e\7}\2\2\u008e\32\3\2\2"+
		"\2\u008f\u0090\7\177\2\2\u0090\34\3\2\2\2\u0091\u0092\7t\2\2\u0092\u0093"+
		"\7g\2\2\u0093\u0094\7v\2\2\u0094\u0095\7w\2\2\u0095\u0096\7t\2\2\u0096"+
		"\u0097\7p\2\2\u0097\36\3\2\2\2\u0098\u0099\7\61\2\2\u0099 \3\2\2\2\u009a"+
		"\u009b\7,\2\2\u009b\"\3\2\2\2\u009c\u009d\7-\2\2\u009d$\3\2\2\2\u009e"+
		"\u009f\7/\2\2\u009f&\3\2\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2\7p\2\2\u00a2"+
		"\u00a3\7v\2\2\u00a3(\3\2\2\2\u00a4\u00a5\7d\2\2\u00a5\u00a6\7q\2\2\u00a6"+
		"\u00a7\7q\2\2\u00a7\u00a8\7n\2\2\u00a8*\3\2\2\2\u00a9\u00aa\7u\2\2\u00aa"+
		"\u00ab\7v\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7e\2\2\u00ad\u00ae\7m\2\2"+
		"\u00ae,\3\2\2\2\u00af\u00b0\7\60\2\2\u00b0\u00b1\7r\2\2\u00b1\u00b2\7"+
		"w\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4\7j\2\2\u00b4.\3\2\2\2\u00b5\u00b6"+
		"\7\60\2\2\u00b6\u00b7\7r\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7r\2\2\u00b9"+
		"\u00ba\7*\2\2\u00ba\u00bb\7+\2\2\u00bb\60\3\2\2\2\u00bc\u00bd\7\60\2\2"+
		"\u00bd\u00be\7r\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1"+
		"\7m\2\2\u00c1\u00c2\7*\2\2\u00c2\u00c3\7+\2\2\u00c3\62\3\2\2\2\u00c4\u00c5"+
		"\7\60\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7G\2\2\u00c8"+
		"\u00c9\7o\2\2\u00c9\u00ca\7r\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7{\2\2"+
		"\u00cc\u00cd\7*\2\2\u00cd\u00ce\7+\2\2\u00ce\64\3\2\2\2\u00cf\u00d0\7"+
		"D\2\2\u00d0\u00d1\7G\2\2\u00d1\u00d2\7I\2\2\u00d2\u00d3\7K\2\2\u00d3\u00d4"+
		"\7P\2\2\u00d4\66\3\2\2\2\u00d5\u00d6\7G\2\2\u00d6\u00d7\7P\2\2\u00d7\u00d8"+
		"\7F\2\2\u00d88\3\2\2\2\u00d9\u00db\5;\36\2\u00da\u00d9\3\2\2\2\u00db\u00dc"+
		"\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd:\3\2\2\2\u00de"+
		"\u00e0\4\62;\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2"+
		"\2\2\u00e1\u00e2\3\2\2\2\u00e2<\3\2\2\2\u00e3\u00e4\t\2\2\2\u00e4>\3\2"+
		"\2\2\u00e5\u00ec\5A!\2\u00e6\u00ec\5C\"\2\u00e7\u00ec\5E#\2\u00e8\u00ec"+
		"\5G$\2\u00e9\u00ec\5I%\2\u00ea\u00ec\5K&\2\u00eb\u00e5\3\2\2\2\u00eb\u00e6"+
		"\3\2\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00e8\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ea\3\2\2\2\u00ec@\3\2\2\2\u00ed\u00ee\7?\2\2\u00ee\u00ef\7?\2\2\u00ef"+
		"B\3\2\2\2\u00f0\u00f1\7#\2\2\u00f1\u00f2\7?\2\2\u00f2D\3\2\2\2\u00f3\u00f4"+
		"\7>\2\2\u00f4F\3\2\2\2\u00f5\u00f6\7>\2\2\u00f6\u00f7\7?\2\2\u00f7H\3"+
		"\2\2\2\u00f8\u00f9\7@\2\2\u00f9J\3\2\2\2\u00fa\u00fb\7@\2\2\u00fb\u00fc"+
		"\7?\2\2\u00fcL\3\2\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100"+
		"\7w\2\2\u0100\u0107\7g\2\2\u0101\u0102\7h\2\2\u0102\u0103\7c\2\2\u0103"+
		"\u0104\7n\2\2\u0104\u0105\7u\2\2\u0105\u0107\7g\2\2\u0106\u00fd\3\2\2"+
		"\2\u0106\u0101\3\2\2\2\u0107N\3\2\2\2\u0108\u010c\5=\37\2\u0109\u010b"+
		"\5=\37\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u0112\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0111\59"+
		"\35\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113P\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0119\7$\2\2\u0116"+
		"\u0118\13\2\2\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u011a\3"+
		"\2\2\2\u0119\u0117\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u0119\3\2\2\2\u011c"+
		"\u011d\7$\2\2\u011dR\3\2\2\2\u011e\u0120\t\3\2\2\u011f\u011e\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u0124\b*\2\2\u0124T\3\2\2\2\u0125\u0126\7\61\2\2\u0126\u0127"+
		"\7,\2\2\u0127\u012b\3\2\2\2\u0128\u012a\13\2\2\2\u0129\u0128\3\2\2\2\u012a"+
		"\u012d\3\2\2\2\u012b\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012e\3\2"+
		"\2\2\u012d\u012b\3\2\2\2\u012e\u012f\7,\2\2\u012f\u0130\7\61\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0132\b+\2\2\u0132V\3\2\2\2\f\2\u00dc\u00e1\u00eb"+
		"\u0106\u010c\u0112\u0119\u0121\u012b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}