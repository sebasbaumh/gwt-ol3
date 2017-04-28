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
package com.github.tdesjardins.ol3.demo.client.utils;

import ol.Collection;
import ol.Coordinate;
import ol.OLFactory;
import ol.OLUtil;
import ol.control.Control;
import ol.control.MousePosition;
import ol.geom.Polygon;

/**
 * 
 * @author Tino Desjardins
 *
 */
public final class DemoUtils {
    
    private DemoUtils() {
        throw new AssertionError();
    }
    
    /**
     * Creates some default controls.
     * 
     * @param controls
     */
    public static void addDefaultControls(final Collection<Control> controls) {

        controls.push(OLFactory.createFullScreen());
        controls.push(OLFactory.createZoomSlider());
        MousePosition mousePosition = new MousePosition();
        mousePosition.setCoordinateFormat(Coordinate.createStringXY(5));
        controls.push(mousePosition);
        controls.push(OLFactory.createZoomToExtent());

    }
    
    /**
     * Creates a test polygon geometry (triangle).
     * 
     * @return test polygon geometry (EPSG:3857)
     */
    public static Polygon createTestPolygon() {
    	
    	Coordinate[][] coordinates = new Coordinate[1][4];
    	
    	Coordinate point1 = OLFactory.createCoordinate(13.36, 52.53);
    	Coordinate point2 = OLFactory.createCoordinate(13.36, 52.51);
    	Coordinate point3 = OLFactory.createCoordinate(13.37, 52.52);
    	Coordinate point4 = OLFactory.createCoordinate(13.36, 52.53);
    	
    	coordinates[0][0] = point1;
    	coordinates[0][1] = point2;
    	coordinates[0][2] = point3;
    	coordinates[0][3] = point4;
     	
    	Coordinate[][] tranformedCoordinates = new Coordinate[coordinates.length][coordinates[0].length];
    	
    	tranformedCoordinates[0] = OLUtil.transform(coordinates[0], "EPSG:4326", "EPSG:3857");
    	return OLFactory.createPolygon(tranformedCoordinates);

    }
    
}
