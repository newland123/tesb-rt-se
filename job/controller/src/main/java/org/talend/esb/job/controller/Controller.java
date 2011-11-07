/*
 * #%L
 * Talend :: ESB :: Job :: Controller
 * %%
 * Copyright (C) 2011 Talend Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.talend.esb.job.controller;


import java.util.List;

/**
 * Interface describing Talend job controller behaviors.
 */
public interface Controller {
    /**
     * List of Talend jobs available in the running container.
     *
     * @return the list of Talend jobs.
     * @throws Exception in case of lookup failure.
     */
    List<String> listJobs() throws Exception;

    /**
     * List of Talend routes available in the running container.
     *
     * @return the list of Talend routes
     * @throws Exception in case of lookup failure
     */
    List<String> listRoutes() throws Exception;

    /**
     * List of Talend Data Services available in the running container.
     *
     * @return the list of Talend services
     * @throws Exception in case of lookup failure
     */
    List<String> listServices() throws Exception;

}
