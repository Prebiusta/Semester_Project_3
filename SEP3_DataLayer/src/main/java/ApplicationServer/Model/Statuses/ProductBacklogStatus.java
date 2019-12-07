package ApplicationServer.Model.Statuses;

public enum ProductBacklogStatus {
    LOCKED("locked"),
    UNLOCKED("unlocked");

    private String status;

    ProductBacklogStatus (String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
