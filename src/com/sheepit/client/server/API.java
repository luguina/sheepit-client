package com.sheepit.client.server;

import com.sheepit.client.server.datamodel.HeartBeatInfos;
import com.sheepit.client.server.datamodel.JobInfos;
import com.sheepit.client.server.datamodel.ServerConfig;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
	@POST("/server/config.php")
	@FormUrlEncoded Call<ServerConfig> newSession(
			@Field("login") String login,
			@Field("password") String password,
			@Field("cpu_family") String cpuFamily,
			@Field("cpu_model") String cpuModel,
			@Field("cpu_model_name") String cpuModelName,
			@Field("cpu_cores") int cpuCores,
			@Field("os") String os,
			@Field("ram") long ram,
			@Field("bits") String bits,
			@Field("version") String version,
			@Field("hostname") String hostname,
			@Field("ui") String ui,
			@Field("extras") String extras);

	@POST("{path}")
	@FormUrlEncoded Call<JobInfos> requestJob(
			@Path(value="path", encoded = true) String path,
			@Field("computemethod") int computeMethod,
			@Field("cpu_cores") int cpuCores,
			@Field("ram_max") long ramMax,
			@Field("rendertime_max") int rendertimeMax,
			@Field("gpu_model") String gpuModel,
			@Field("gpu_ram") long gpuVram,
			@Field("gpu_type") String gpuType);

	@POST("{path}")
	@FormUrlEncoded Call<HeartBeatInfos> heartBeat(
			@Path(value="path", encoded = true) String path,
			@Field("frame") String frame,
			@Field("job") String job,
			@Field("extras") String extras,
			@Field("rendertime") int rendertime,
			@Field("remainingtime") int remainingtime);
}

//http://simple.sourceforge.net/download/stream/doc/tutorial/tutorial.php
