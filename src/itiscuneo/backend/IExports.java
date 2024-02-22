package itiscuneo.backend;

public interface IExports {
    public  static  final String PATH = "data/";
    public  static final String NAME_CSV = "cespite.csv";
    public static final  String NAME_JSON = "cespite.json";

    void scriviCsv(ElencoCespiti elencoCespiti);

    void scriviJson(ElencoCespiti elencoCespiti);
}
