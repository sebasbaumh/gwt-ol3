/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.github.tdesjardins.ol3.demo.client;

import com.github.tdesjardins.ol3.demo.client.example.OL3ExampleType;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

import java.util.HashMap;
import java.util.Map;

/**
 * EntryPoint for playing with GwtOL3-Features.
 *
 * @author Tino Desjardins
 */
public class GwtOL3Playground implements EntryPoint {

    @Override
    public void onModuleLoad() {

        Map<String, Integer> exampleIndexMap = new HashMap<>();

        // choose your example
        TabLayoutPanel tabs = new TabLayoutPanel(27, Style.Unit.PX);

        int index = 0;

        for (OL3ExampleType example : OL3ExampleType.values()) {
            tabs.add(new LazyExampleWidget(example), example.name().replace("Example", ""));
            exampleIndexMap.put(example.name(), index);
            index++;
        }
        RootLayoutPanel.get().add(tabs);

        String token = History.getToken();

        if (token != null && exampleIndexMap.containsKey(token)) {
            tabs.selectTab(exampleIndexMap.get(token));
        }
    }

    private static class LazyExampleWidget extends SimplePanel {

        private final OL3ExampleType example;
        private boolean initialized = false;

        private LazyExampleWidget(OL3ExampleType example) {
            this.example = example;
            this.setSize("100%", "100%");
            this.getElement().setId(example.getExample().toString());
            // set tabindex to "0" to make it focusable (needed for keyboard navigation)
            this.getElement().setTabIndex(0);
        }

        @Override public void setVisible(boolean visible) {
            if (visible && !initialized) {
                Scheduler.get().scheduleDeferred(() -> example.getExample().show(example.getExample().toString()));
                initialized = true;
            }
            super.setVisible(visible);

            if (visible) {
                History.newItem(example.name());
            }
        }

    }

}
