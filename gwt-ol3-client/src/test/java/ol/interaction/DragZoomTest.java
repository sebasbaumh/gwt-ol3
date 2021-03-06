/*******************************************************************************
 * Copyright 2014, 2018 gwt-ol3
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
package ol.interaction;

import ol.GwtOLBaseTestCase;
import ol.Observable;

/**
 * 
 * @author Tino Desjardins
 *
 */
public class DragZoomTest extends GwtOLBaseTestCase {

    public void testDragZoom() {

        injectUrlAndTest(() -> {

            DragZoomOptions dragZoomOptions = new DragZoomOptions();
            DragZoom dragZoom = new DragZoom(dragZoomOptions);

            assertNotNull(dragZoom);
            assertTrue(dragZoom instanceof Observable);
            assertTrue(dragZoom instanceof Interaction);
            assertTrue(dragZoom instanceof Pointer);
        });

    }

}
