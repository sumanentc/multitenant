package com.example.entity.discriminator;


import java.io.Serializable;

//@Entity
//@Table(name = "city")
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@FilterDef(name = "tenantFilter", parameters = {@ParamDef(name = "tenantId", type = "string")})
//@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
public class City implements Serializable,TenantSupport {
    private static final long serialVersionUID = -4551953276601557391L;
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //@Column(name = "tenant_id")
    private String tenantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", tenantId='").append(tenantId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
