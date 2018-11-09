package cloud.solr.domain;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;
import java.util.Date;
@SolrDocument(solrCoreName="fbf")
public class Fbf implements Serializable {
    @Id
    @Field
    private String poid;
    @Field
    private String fbfbm;
    @Field
    private String fbfmc;
    @Field
    private String fbffzrxm;
    @Field
    private String fzrzjlx;
    @Field
    private String fzrzjhm;
    @Field
    private String lxdh;
    @Field
    private String fbfdz;
    @Field
    private String yzbm;
    @Field
    private String fbfdcy;
    @Field
    private String fbfdcrq;
    @Field
    private String fbfdcjs;
    @Field
    private String sjxzdm;
    @Field
    private String c1;
    @Field
    private String c2;
    @Field
    private String c3;
    @Field
    private String c4;
    @Field
    private String c5;

    private static final long serialVersionUID = 1L;

    public String getFbfbm() {
        return fbfbm;
    }

    public void setFbfbm(String fbfbm) {
        this.fbfbm = fbfbm == null ? null : fbfbm.trim();
    }

    public String getFbfmc() {
        return fbfmc;
    }

    public void setFbfmc(String fbfmc) {
        this.fbfmc = fbfmc == null ? null : fbfmc.trim();
    }

    public String getFbffzrxm() {
        return fbffzrxm;
    }

    public void setFbffzrxm(String fbffzrxm) {
        this.fbffzrxm = fbffzrxm == null ? null : fbffzrxm.trim();
    }

    public String getFzrzjlx() {
        return fzrzjlx;
    }

    public void setFzrzjlx(String fzrzjlx) {
        this.fzrzjlx = fzrzjlx == null ? null : fzrzjlx.trim();
    }

    public String getFzrzjhm() {
        return fzrzjhm;
    }

    public void setFzrzjhm(String fzrzjhm) {
        this.fzrzjhm = fzrzjhm == null ? null : fzrzjhm.trim();
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh == null ? null : lxdh.trim();
    }

    public String getFbfdz() {
        return fbfdz;
    }

    public void setFbfdz(String fbfdz) {
        this.fbfdz = fbfdz == null ? null : fbfdz.trim();
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm == null ? null : yzbm.trim();
    }

    public String getFbfdcy() {
        return fbfdcy;
    }

    public void setFbfdcy(String fbfdcy) {
        this.fbfdcy = fbfdcy == null ? null : fbfdcy.trim();
    }

    public String getFbfdcrq() {
        return fbfdcrq;
    }

    public void setFbfdcrq(String fbfdcrq) {
        this.fbfdcrq = fbfdcrq;
    }

    public String getFbfdcjs() {
        return fbfdcjs;
    }

    public void setFbfdcjs(String fbfdcjs) {
        this.fbfdcjs = fbfdcjs == null ? null : fbfdcjs.trim();
    }

    public String getPoid() {
        return poid;
    }

    public void setPoid(String poid) {
        this.poid = poid == null ? null : poid.trim();
    }

    public String getSjxzdm() {
        return sjxzdm;
    }

    public void setSjxzdm(String sjxzdm) {
        this.sjxzdm = sjxzdm == null ? null : sjxzdm.trim();
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1 == null ? null : c1.trim();
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2 == null ? null : c2.trim();
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3 == null ? null : c3.trim();
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4 == null ? null : c4.trim();
    }

    public String getC5() {
        return c5;
    }

    public void setC5(String c5) {
        this.c5 = c5 == null ? null : c5.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fbfbm=").append(fbfbm);
        sb.append(", fbfmc=").append(fbfmc);
        sb.append(", fbffzrxm=").append(fbffzrxm);
        sb.append(", fzrzjlx=").append(fzrzjlx);
        sb.append(", fzrzjhm=").append(fzrzjhm);
        sb.append(", lxdh=").append(lxdh);
        sb.append(", fbfdz=").append(fbfdz);
        sb.append(", yzbm=").append(yzbm);
        sb.append(", fbfdcy=").append(fbfdcy);
        sb.append(", fbfdcrq=").append(fbfdcrq);
        sb.append(", fbfdcjs=").append(fbfdcjs);
        sb.append(", poid=").append(poid);
        sb.append(", sjxzdm=").append(sjxzdm);
        sb.append(", c1=").append(c1);
        sb.append(", c2=").append(c2);
        sb.append(", c3=").append(c3);
        sb.append(", c4=").append(c4);
        sb.append(", c5=").append(c5);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}