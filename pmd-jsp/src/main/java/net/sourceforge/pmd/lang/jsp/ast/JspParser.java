/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.jsp.ast;

import java.io.Reader;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.AbstractParser;
import net.sourceforge.pmd.lang.LanguageVersionHandler;
import net.sourceforge.pmd.lang.ParserOptions;
import net.sourceforge.pmd.lang.TokenManager;
import net.sourceforge.pmd.lang.ast.AbstractTokenManager;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.ast.ParseException;
import net.sourceforge.pmd.lang.ast.impl.javacc.CharStreamFactory;

/**
 * Adapter for the JspParser.
 *
 * @deprecated This is internal API, use {@link LanguageVersionHandler#getParser(ParserOptions)}.
 */
@InternalApi
@Deprecated
public class JspParser extends AbstractParser {

    public JspParser(ParserOptions parserOptions) {
        super(parserOptions);
    }

    @Override
    public TokenManager createTokenManager(Reader source) {
        return new JspTokenManager(source);
    }

    @Override
    public Node parse(String fileName, Reader source) throws ParseException {
        AbstractTokenManager.setFileName(fileName);
        return new JspParserImpl(CharStreamFactory.simpleCharStream(source)).CompilationUnit();
    }

}