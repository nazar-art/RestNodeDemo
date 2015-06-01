package com.lelyak.edu.utils.logger;

import org.testng.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Nazar_Lelyak
 */
public class TestNgListener extends TestListenerAdapter implements IInvokedMethodListener, ISuiteListener {

    private List<String> processedSuites = new ArrayList<>();

    /**
     * Test class
     */
    @Override
    public void onStart(ITestContext context) {
        Logger.info(buildMessage(Logger.PREFIX_TEST_STARTED, context.getName()));
    }

    @Override
    public void onFinish(ITestContext context) {
        Logger.info(buildMessage(Logger.PREFIX_TEST_FINISHED, context.getName()));
    }

    /**
     * Test Method (Test)
     */
    @Override
    public void onTestStart(ITestResult result) {
        Logger.info(buildMessage(Logger.PREFIX_METHOD_STARTED, getMethodName(result)));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logger.info(buildMessage(Logger.PREFIX_METHOD_SUCCESS, getMethodName(result)));
        processTestResult(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logger.info(buildMessage(Logger.PREFIX_METHOD_FAILED, getMethodName(result)));
    }

    private void processFailure(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger.info(buildMessage(Logger.PREFIX_METHOD_SKIPPED, getMethodName(result)));
    }

    /**
     * Configuration
     */
    @Override
    public void onConfigurationSuccess(ITestResult itr) {
        Logger.info(buildMessage(Logger.PREFIX_CONFIGURATION_SUCCESS, getMethodName(itr)));
        processTestResult(itr);
    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {
        Logger.info(buildMessage(Logger.PREFIX_CONFIGURATION_FAILED, getMethodName(itr)));
    }

    @Override
    public void onConfigurationSkip(ITestResult itr) {
        Logger.info(buildMessage(Logger.PREFIX_CONFIGURATION_SKIPPED, getMethodName(itr)));
    }

    @Override
    public void beforeConfiguration(ITestResult tr) {
        Logger.info(buildMessage(Logger.PREFIX_CONFIGURATION_STARTED, getMethodName(tr)));
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // Do nothing

    }

    private boolean firstAttmptKey = true;

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        int result = testResult.getStatus();

        if (result == ITestResult.FAILURE && firstAttmptKey) {
            processFailure(testResult);
        }

        firstAttmptKey = !firstAttmptKey;
    }

    private String buildMessage(String prefix, String msg) {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        builder.append(" - ");
        builder.append(msg);

        return builder.toString();
    }

    /**
     * Get name and description of Test Method as
     *
     * @param result
     * @return
     */
    private String getMethodName(ITestResult result) {
        StringBuilder builder = new StringBuilder();
        builder.append(result.getTestClass().getRealClass().getSimpleName());
        builder.append(".");
        builder.append(result.getMethod().getMethodName());
        Object description = result.getMethod().getDescription();

        if (null != description) {
            builder.append(" - ");
            builder.append(description);
        }

        return builder.toString();
    }

    private void processTestResult(ITestResult result) {
        if (result.getThrowable() != null) {
            Logger.error("Following error thrown while test execution: ", result.getThrowable());
        }
    }

    /* (non-Javadoc)
     * @see org.testng.ISuiteListener#onStart(org.testng.ISuite)
     */
    @Override
    public void onStart(ISuite suite) {
        // do nothing
    }

    /* (non-Javadoc)
     * @see org.testng.ISuiteListener#onFinish(org.testng.ISuite)
     */
    @Override
    public void onFinish(ISuite suite) {
    }
}
