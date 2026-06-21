package Service.DTO;

public class PixRegistryResponse {
    private String nomeRecebedor;
    private String documentoRecebedor;
    private String tipoRecebedor;
    private String chavePix;
    public PixRegistryResponse(){}
    public PixRegistryResponse(String nomeRecebedor, String documentoRecebedor, String tipoRecebedor, String chavePix) {
        this.nomeRecebedor = nomeRecebedor;
        this.documentoRecebedor = documentoRecebedor;
        this.tipoRecebedor = tipoRecebedor;
        this.chavePix = chavePix;
    }
    public String getNomeRecebedor() {
        return nomeRecebedor;
    }
    public void setNomeRecebedor(String nomeRecebedor) {
        this.nomeRecebedor = nomeRecebedor;
    }
    public String getDocumentoRecebedor() {
        return documentoRecebedor;
    }
    public void setDocumentoRecebedor(String documentoRecebedor) {
        this.documentoRecebedor = documentoRecebedor;
    }
    public String getTipoRecebedor() {
        return tipoRecebedor;
    }
    public void setTipoRecebedor(String tipoRecebedor) {
        this.tipoRecebedor = tipoRecebedor;
    }
    public String getChavePix() {
        return chavePix;
    }
    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
    
}
