/*
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package net.lbku.client.api;

import net.lbku.client.invoker.ApiCallback;
import net.lbku.client.invoker.ApiClient;
import net.lbku.client.invoker.ApiException;
import net.lbku.client.invoker.ApiResponse;
import net.lbku.client.invoker.Configuration;
import net.lbku.client.invoker.Pair;

import com.google.gson.reflect.TypeToken;


import net.lbku.client.model.Station;
import net.lbku.client.model.Train;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StationApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public StationApi() {
        this(Configuration.getDefaultApiClient());
    }

    public StationApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for getArrivals
     * @param stationId The unique ID of the station. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved the list of upcoming train arrivals. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal server error. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Station not found. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getArrivalsCall(Integer stationId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/stations/{stationId}/arrivals"
            .replace("{" + "stationId" + "}", localVarApiClient.escapeString(stationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getArrivalsValidateBeforeCall(Integer stationId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'stationId' is set
        if (stationId == null) {
            throw new ApiException("Missing the required parameter 'stationId' when calling getArrivals(Async)");
        }

        return getArrivalsCall(stationId, _callback);

    }

    /**
     * Retrieve upcoming train arrivals for a station.
     * Retrieves a list of upcoming train arrivals for a specific station, identified by the station ID.
     * @param stationId The unique ID of the station. (required)
     * @return List&lt;Train&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved the list of upcoming train arrivals. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal server error. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Station not found. </td><td>  -  </td></tr>
     </table>
     */
    public List<Train> getArrivals(Integer stationId) throws ApiException {
        ApiResponse<List<Train>> localVarResp = getArrivalsWithHttpInfo(stationId);
        return localVarResp.getData();
    }

    /**
     * Retrieve upcoming train arrivals for a station.
     * Retrieves a list of upcoming train arrivals for a specific station, identified by the station ID.
     * @param stationId The unique ID of the station. (required)
     * @return ApiResponse&lt;List&lt;Train&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved the list of upcoming train arrivals. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal server error. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Station not found. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<Train>> getArrivalsWithHttpInfo(Integer stationId) throws ApiException {
        okhttp3.Call localVarCall = getArrivalsValidateBeforeCall(stationId, null);
        Type localVarReturnType = new TypeToken<List<Train>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieve upcoming train arrivals for a station. (asynchronously)
     * Retrieves a list of upcoming train arrivals for a specific station, identified by the station ID.
     * @param stationId The unique ID of the station. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved the list of upcoming train arrivals. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal server error. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Station not found. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getArrivalsAsync(Integer stationId, final ApiCallback<List<Train>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getArrivalsValidateBeforeCall(stationId, _callback);
        Type localVarReturnType = new TypeToken<List<Train>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getStations
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 500 </td><td> Internal server error. </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved the list of train stations. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getStationsCall(final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/stations";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getStationsValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getStationsCall(_callback);

    }

    /**
     * Retrieve the list of train stations.
     * Retrieves the list of all available train stations in the system.
     * @return List&lt;Station&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 500 </td><td> Internal server error. </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved the list of train stations. </td><td>  -  </td></tr>
     </table>
     */
    public List<Station> getStations() throws ApiException {
        ApiResponse<List<Station>> localVarResp = getStationsWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Retrieve the list of train stations.
     * Retrieves the list of all available train stations in the system.
     * @return ApiResponse&lt;List&lt;Station&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 500 </td><td> Internal server error. </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved the list of train stations. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<Station>> getStationsWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getStationsValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<List<Station>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieve the list of train stations. (asynchronously)
     * Retrieves the list of all available train stations in the system.
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 500 </td><td> Internal server error. </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Successfully retrieved the list of train stations. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getStationsAsync(final ApiCallback<List<Station>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getStationsValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<List<Station>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
