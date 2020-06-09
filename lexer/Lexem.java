package lexer;

import java.util.regex.Pattern;

public enum Lexem {
    VAR("^[a-zA-Z][a-zA-Z0-9]*+\\s*$"),
    DIGIT("^(0|([1-9][0-9]*))\\s*$"),
    TYPE("^(list|hashSet)\\s*$"),
    FUN_OP("^(append|delete|get|)\\s*$"),
    ASSIGN_OP("^=\\s*$"),
    OP("^(\\+|-|\\*|/)\\s*$"),
    CONDITION_OP("^if\\s*$"),
    CONDITION("^(>|>=|==|<=|<)\\s*$"),
    CYCLE("^while +\\s*$"),
    OP_PARENTHESIS("^(\\()\\s*$"),
    CL_PARENTHESIS("^(\\))\\s*$"),
    OP_BRACE("^(\\{)\\s*$"),
    CL_BRACE("^(\\})\\s*$"),
    END_LINE("^\n$"),
    MARK("^$"),
    MARK_INDEX("^$"),
    BOOL("true|false");

    private final Pattern pattern;

    Lexem(String regexp) {
        this.pattern = Pattern.compile(regexp);
    }

    public Pattern getPattern() {
        return pattern;
    }
}
