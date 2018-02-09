package analyzer.tests;

import analyzer.ast.ParserVisitor;
import analyzer.visitors.DumpTreeVisitor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Collection;

/**
 * Created: 17-08-02
 * Last Changed: 17-08-02
 * Author: Nicolas Cloutier
 *
 * Description: This test the PrintVisitor. So it will basically test that the tree can be written into valid
 * source code.
 */

@RunWith(Parameterized.class)
public class DumpTreeTest extends BaseTest {

    private static String m_test_suite_path = "./test-suite/DumpTreeTest/data";

    public DumpTreeTest(File file) {
        super(file);
    }

    @Test
    public void run() throws Exception {
        ParserVisitor algorithm = new DumpTreeVisitor(m_output);
        runAndAssert(algorithm);
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> getFiles() {
        return getFiles(m_test_suite_path);
    }

}
