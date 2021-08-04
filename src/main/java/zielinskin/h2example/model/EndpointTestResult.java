package zielinskin.h2example.model;

//todo: is this possible to use?
public class EndpointTestResult {
    private final Integer waitingTime;
    private final Integer contentDownloadTime;

    public EndpointTestResult(Integer waitingTime, Integer contentDownloadTime) {
        this.waitingTime = waitingTime;
        this.contentDownloadTime = contentDownloadTime;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public Integer getContentDownloadTime() {
        return contentDownloadTime;
    }
}
