package MavenProject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class extractionjson {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		ObjectMapper om=new ObjectMapper();
		om.readValue("C:\\Users\\Monali_PC\\workspace\\Jsonjava\\customerInfo.json", SdatProject.class);
	}

}
