package info.batey.eventstore;

import com.datastax.driver.mapping.EnumType;
import com.datastax.driver.mapping.annotations.*;

import java.util.Map;
import java.util.UUID;

@Table(keyspace = "customers", name = "customer_events")
public class CustomerEvent {
    @PartitionKey
    @Column(name = "customer_id")
    private String customerId;

    @ClusteringColumn()
    private UUID time;

    @Column(name = "staff_id")
    private String staffId;

    @Column(name = "store_type")
    @Enumerated(EnumType.STRING) // could be EnumType.ORDINAL
    private StoreType storeType;

    @Column(name = "event_type")
    private String eventType;

    private Map<String, String> tags;

    public CustomerEvent(String customerId, UUID time, String staffId, StoreType storeType, String eventType, Map<String, String> tags) {
        this.customerId = customerId;
        this.time = time;
        this.staffId = staffId;
        this.storeType = storeType;
        this.eventType = eventType;
        this.tags = tags;
    }

    public CustomerEvent() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public UUID getTime() {
        return time;
    }

    public void setTime(UUID time) {
        this.time = time;
    }

    public StoreType getStoreType() {
        return storeType;
    }

    public void setStoreType(StoreType storeType) {
        this.storeType = storeType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }
}
