package com.acme.prime.eval.test;

import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;
import com.acme.prime.eval.api.Eval;

public class EvalTest {

    private final BundleContext context =
    		FrameworkUtil.getBundle(this.getClass()).getBundleContext();
    
    
    <T> T getService(Class<T> clazz) throws InterruptedException {
    	ServiceTracker<T,T> st = new ServiceTracker<>(context, clazz, null);
    	st.open();
    	return st.waitForService(1000);
    }

    @Test
    public void testEval() throws Exception {
    	Assert.assertNotNull(context);
    	Assert.assertNotNull(getService(Eval.class));
    }
    
    @Test
    public void trig() throws Exception {
    	Assert.assertSame(1, (int)getService(Eval.class).eval("sin(1)*sin(1)+cos(1)*cos(1)"));
    }

    @Test
    public void add() throws Exception {
    	Assert.assertSame(46, (int)getService(Eval.class).eval("12+34"));
    }

    @Test
    public void subtract() throws Exception {
    	Assert.assertSame(-22, (int)getService(Eval.class).eval("12-34"));
    }

    @Test
    public void multiply() throws Exception {
    	Assert.assertSame(12, (int)getService(Eval.class).eval("2*6"));
    }

    @Test
    public void divide() throws Exception {
    	Assert.assertSame(16, (int)getService(Eval.class).eval("160/10"));
    }

}
