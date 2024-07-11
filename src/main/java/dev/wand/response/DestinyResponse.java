package dev.wand.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class DestinyResponse<T> {
    @JsonProperty("ErrorCode")
    private int ErrorCode;

    @JsonProperty("ThrottleSeconds")
    private int ThrottleSeconds;

    @JsonProperty("ErrorStatus")
    private String ErrorStatus;

    @JsonProperty("Message")
    private String Message;

    @JsonProperty("MessageData")
    private Map<String, Object> MessageData;

    @JsonProperty("Response")
    private T Response;

    @Override
    public String toString() {
        return "ApiResponse{" +
                "ErrorCode=" + ErrorCode +
                ", ThrottleSeconds=" + ThrottleSeconds +
                ", ErrorStatus='" + ErrorStatus + '\'' +
                ", Message='" + Message + '\'' +
                ", MessageData=" + MessageData +
                ", Response=" + Response +
                '}';
    }
}
