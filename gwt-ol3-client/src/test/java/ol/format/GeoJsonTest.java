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
package ol.format;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import ol.Coordinate;
import ol.Feature;
import ol.FeatureOptions;
import ol.GwtOL3BaseTestCase;
import ol.OLFactory;
import ol.geom.LineString;

/**
 *
 * @author Tino Desjardins
 *
 */
public class GeoJsonTest extends GwtOL3BaseTestCase {

	private GeoJson geoJsonFormat;
	
	
	
	@Override
	protected void gwtSetUp() throws Exception {
	    injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                geoJsonFormat = new GeoJson();
            }
	        
	    });
	}
	
	public void testFeatureToGeoJson() {

	    injectUrlAndTest(new TestWithInjection() {
            
            @Override
            public void test() {
                
                assertNotNull(geoJsonFormat);

                JavaScriptObject geoJSON = geoJsonFormat.writeFeatureObject(createTestFeature(), null);
                assertNotNull(geoJSON);
                
            }
            
        });

	}

    public void testGeoJsonToFeature() {
        
        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                JavaScriptObject geoJson = geoJsonFormat.writeFeatureObject(createTestFeature(), null);

                // Convert Features from GeoJSON
                Feature featureGeoJson = geoJsonFormat.readFeature(geoJson, null);
                assertNotNull(featureGeoJson);
            }

        });

    }
	
    public void testWriteGeoJSON() {
        
        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                String geoJson = geoJsonFormat.writeFeatures(createTestFeature(), null);
                assertNotNull(geoJson);

                JavaScriptObject javaScriptObject = JsonUtils.safeEval(geoJson);
                assertNotNull(javaScriptObject);
            }
        });

    }
	
    public void testReadFeatureFromGeoJson() {
        
        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                String geoJson = geoJsonFormat.writeFeature(createTestFeature(), null);
                assertNotNull(geoJson);
                Feature feature = geoJsonFormat.readFeature(geoJson, null);

                assertNotNull(feature);
            }
        });

    }
    
    public void testReadFeatureCollectionFromGeoJson() {
        
        injectUrlAndTest(new TestWithInjection() {

            @Override
            public void test() {
                String geoJson = geoJsonFormat.writeFeatures(createTestFeature(), null);
                assertNotNull(geoJson);
                Feature[] features = geoJsonFormat.readFeatures(geoJson, null);

                assertNotNull(features);
                //assertTrue(features.length > 0);
            }
        });

    }
	
	private Feature createTestFeature() {
		
		Coordinate coordinate1 = OLFactory.createCoordinate(1, 1);
		Coordinate coordinate2 = OLFactory.createCoordinate(5, 5);
		Coordinate[] coordinates = { coordinate1, coordinate2 };
		LineString lineString = new LineString(coordinates);

		// Create feature
		FeatureOptions featureOptions = OLFactory.createOptions();
		featureOptions.setGeometry(lineString);
		return new Feature(featureOptions);
		
	}

}
