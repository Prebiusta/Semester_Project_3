package ApplicationServer.Model;

import ApplicationServer.Model.Statuses.ProductBacklogStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product_backlog")
public class ProductBacklog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_backlog_id")
    private int productBacklogId;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "status")
    private ProductBacklogStatus status;

    public ProductBacklog() {
    }

    public ProductBacklog(int projectId, ProductBacklogStatus status) {
        this.projectId = projectId;
        this.status = status;
    }

    public int getProductBacklogId() {
        return productBacklogId;
    }

    public void setProductBacklogId(int productBacklogId) {
        this.productBacklogId = productBacklogId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public ProductBacklogStatus getStatus() {
        return status;
    }

    public void setStatus(ProductBacklogStatus status) {
        this.status = status;
    }
}
