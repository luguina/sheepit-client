package com.sheepit.client.server.datamodel;

import com.sheepit.client.Error;
import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false, name = "config") @ToString public class ServerConfig {
	//@Text(required = false) // will be null in forged POJO object
	//private String text;    // if empty@Attribute(name = "id", required = false)
	//private int id;

	//@Attribute private Error.ServerCode status;

	@Attribute
	@Getter private int status;

	@ElementList(name = "request", inline = true)
	// @Getter
	private List<RequestEndPoint> requestEndPoints;

	//	@ElementList(inline = true)
	//	List<Error> errors;

	public ServerConfig() {
	}

	public RequestEndPoint getRequestEndPoint(String type) {
		if (requestEndPoints != null) {
			for (RequestEndPoint endPoint : requestEndPoints) {
				if (type.equals(endPoint.getType())) {
					return endPoint;
				}
			}
		}
		return null;
	}
}

//	$ret = '<?xml version="1.0" encoding="utf-8" ?>';
//	$ret .= '<config status="'.ClientProtocol::$OK.'">';
//	$ret .= '<request type="validate-job" path="/server/send_frame.php" />';
//	$ret .= '<request type="request-job" path="/server/request_job.php" />';
//	$ret .= '<request type="download-archive" path="/server/archive.php" />';
//	$ret .= '<request type="error" path="/server/error.php" />';
//	$ret .= '<request type="keepmealive" path="/server/keepmealive.php" max-period="'.ini_get('session.gc_maxlifetime').'" />';
//	$ret .= '<request type="logout" path="/account.php?mode=logout&amp;worker=1" />';
//	$ret .= '<request type="last-render-frame" path="/ajax.php?action=webclient_get_last_render_frame_ui&amp;type=raw" />';
//	$ret .= '</config>';

//@Root(name = "task")
//public class Task {
//	@Element(name = "id")
//	private long id;
//
//	@Element(name = "title")
//	private String title;
//
//	@Element(name = "description")
//	private String description;
//
//	@Attribute(required = false)
//	private String link;
//
//	public Task() {}
