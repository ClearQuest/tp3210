package analyzer.tests;

import analyzer.ast.ParserVisitor;
import analyzer.visitors.ForStmtVisitor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ForStmtTest extends BaseTest {

    private static String m_test_suite_path = "./test-suite/ForStmtTest/data";

    public ForStmtTest(File file) {
        super(file);
    }

    @Test
    public void run() throws Exception {
        ParserVisitor algorithm = new ForStmtVisitor(m_output);
        runAndAssert(algorithm);
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> getFiles() {
        return getFiles(m_test_suite_path);
    }

}
