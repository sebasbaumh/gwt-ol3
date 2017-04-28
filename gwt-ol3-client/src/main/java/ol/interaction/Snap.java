/*******************************************************************************
 * Copyright 2014, 2016 gwt-ol3
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

import jsinterop.annotations.JsType;
import ol.Feature;
import ol.Map;

/**
 *
 * Handles snapping of vector features while modifying or drawing them. The
 * features can come from a {@link ol.source.Vector} or {@link ol.Collection}. Any interaction
 * object that allows the user to interact with the features using the mouse can
 * benefit from the snapping, as long as it is added before.
 *
 * The snap interaction modifies map browser event coordinate and pixel
 * properties to force the snap to occur to any interaction that them.
 *
 * @author guandalini
 */
@JsType(isNative = true)
public class Snap extends Interaction {

    public Snap(SnapOptions snapOptions) {}
    
    /**
     * Add a feature to the collection of features that we may snap to.
     *
     * @param feature
     */
    public native void addFeature(Feature feature);

    /**
     * Remove a feature from the collection of features that we may snap to.
     *
     * @param feature
     */
    public native void removeFeature(Feature feature);

    /**
     * Get the map associated with this interaction.
     *
     * @return map
     */
    public native Map getMap();

}
