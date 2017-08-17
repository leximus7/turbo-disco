package ru.lebedev.javalearn.codewars.simplexer;

public class Token {
    String value;
    String identifier;

    public Token(String x, String identifier) {
        this.value = value;
        this.identifier = identifier;
    }

    public String getValue() {
        return value;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        if (value != null ? !value.equals(token.value) : token.value != null) return false;
        return identifier != null ? identifier.equals(token.identifier) : token.identifier == null;
    }

}
