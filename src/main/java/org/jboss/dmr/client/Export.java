package org.jboss.dmr.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import org.timepedia.exporter.client.ExporterUtil;

/**
 * @author Heiko Braun
 * @date 4/8/13
 */
public class Export implements EntryPoint {

    public void onModuleLoad() {

        GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {

            public void onUncaughtException(Throwable throwable) {
                Window.alert("Uncaught DMR exception: " + throwable.getMessage());
            }
        });

        ExporterUtil.exportAll();
    }
}
