/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.scheduler.cluster

import org.apache.spark.rpc.{RpcAddress, RpcEndpointRef}

/**
 * Grouping of data for an executor used by CoarseGrainedSchedulerBackend.
 *
 * @param executorEndpoint The RpcEndpointRef representing this executor
 * @param executorAddress The network address of this executor
 * @param executorHost The hostname that this executor is running on
 * @param freeCores  The current number of cores available for work on the executor
 * @param totalCores The total number of cores available to the executor
 */
//封装Executor信息的数据结构
private[cluster] class ExecutorData(
   val executorEndpoint: RpcEndpointRef,//CoarseGrainedExecutorBackend端的引用
   val executorAddress: RpcAddress,//CoarseGrainedExecutorBackend的RPC地址
   override val executorHost: String,
   var freeCores: Int, //空闲核数
   override val totalCores: Int,//总核数
   override val logUrlMap: Map[String, String]
) extends ExecutorInfo(executorHost, totalCores, logUrlMap)
