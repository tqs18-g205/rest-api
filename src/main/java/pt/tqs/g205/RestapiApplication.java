package pt.tqs.g205;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pt.tqs.g205.domain.CategoriaPrato;
import pt.tqs.g205.domain.Cliente;
import pt.tqs.g205.domain.Ingrediente;
import pt.tqs.g205.domain.IngredientesPorPrato;
import pt.tqs.g205.domain.Morada;
import pt.tqs.g205.domain.Prato;
import pt.tqs.g205.repositories.CategoriaPratoRepository;
import pt.tqs.g205.repositories.ClienteRepository;
import pt.tqs.g205.repositories.IngredienteRepository;
import pt.tqs.g205.repositories.IngredientesPorPratoRepository;
import pt.tqs.g205.repositories.MoradaRepository;
import pt.tqs.g205.repositories.PratoRepository;

import java.util.Arrays;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private CategoriaPratoRepository categoriaPratoRepo;

  @Autowired
  private IngredienteRepository ingredienteRepo;

  @Autowired
  private PratoRepository pratoRepo;

  @Autowired
  private IngredientesPorPratoRepository ingredientesPorPratoRepo;

  @Autowired
  private ClienteRepository clienteRepo;

  @Autowired
  private MoradaRepository moradaRepo;

  public static void main(String[] args) {
    SpringApplication.run(RestapiApplication.class, args);
  }
  
  @Override
  public void run(String... args) throws Exception {
    Cliente cli = new Cliente(null, "Chico Matos", beCryptPasswordEncoder.encode("1234"),
        "999999999", "chicomatos@ua.pt");

    Morada morada = new Morada(null, "Rua xpto", "Aveiro", "3810-610", "Aveiro", cli);

    clienteRepo.saveAll(Arrays.asList(cli));
    cli.setMoradas(Arrays.asList(morada));
    moradaRepo.saveAll(Arrays.asList(morada));
    clienteRepo.saveAll(Arrays.asList(cli));

    final CategoriaPrato c1 = new CategoriaPrato(null, "Carne");
    final CategoriaPrato c2 = new CategoriaPrato(null, "Peixe");
    final CategoriaPrato c3 = new CategoriaPrato(null, "Vegetariano");
    final CategoriaPrato c4 = new CategoriaPrato(null, "Vegan");
    final CategoriaPrato c5 = new CategoriaPrato(null, "Sobremesa");
    final CategoriaPrato c6 = new CategoriaPrato(null, "Sopa");
    final CategoriaPrato c7 = new CategoriaPrato(null, "Entrada");

    final Ingrediente i1 = new Ingrediente(null, "Arroz", 100.0);
    final Ingrediente i2 = new Ingrediente(null, "Pato", 150.0);
    final Ingrediente i3 = new Ingrediente(null, "Cenoura", 50.0);
    final Ingrediente i4 = new Ingrediente(null, "Bacalhau", 150.0);
    final Ingrediente i5 = new Ingrediente(null, "Natas", 250.0);
    final Ingrediente i6 = new Ingrediente(null, "Cogumelos", 150.0);
    final Ingrediente i7 = new Ingrediente(null, "Ervilhas", 50.0);
    final Ingrediente i8 = new Ingrediente(null, "Esparguete", 150.0);
    final Ingrediente i9 = new Ingrediente(null, "Ovo", 180.0);
    final Ingrediente i10 = new Ingrediente(null, "Novilho", 150.0);
    final Ingrediente i11 = new Ingrediente(null, "Dourada", 50.0);
    final Ingrediente i12 = new Ingrediente(null, "Batata", 150.0);
    final Ingrediente i13 = new Ingrediente(null, "Carapau", 200.0);
    final Ingrediente i14 = new Ingrediente(null, "Tomate", 18.0);
    final Ingrediente i15 = new Ingrediente(null, "Cebola", 40.0);
    final Ingrediente i16 = new Ingrediente(null, "Alho", 35.0);
    final Ingrediente i17 = new Ingrediente(null, "Pão", 265.0);
    final Ingrediente i18 = new Ingrediente(null, "Pimenta", 200.0);
    final Ingrediente i19 = new Ingrediente(null, "Entrecosto", 280.0);
    final Ingrediente i20 = new Ingrediente(null, "Polvo", 190.0);
    final Ingrediente i21 = new Ingrediente(null, "Feijão Verde", 115.0);
    final Ingrediente i22 = new Ingrediente(null, "Cação", 130.0);
    final Ingrediente i23 = new Ingrediente(null, "Febra de Porco", 250.0);
    final Ingrediente i24 = new Ingrediente(null, "Limão", 30.0);
    final Ingrediente i25 = new Ingrediente(null, "Azeitona", 40.0);
    final Ingrediente i26 = new Ingrediente(null, "Salsa", 35.0);
    final Ingrediente i27 = new Ingrediente(null, "Leite", 45.0);
    final Ingrediente i28 = new Ingrediente(null, "Açucar", 387.0);
    final Ingrediente i29 = new Ingrediente(null, "Farinha", 364.0);
    final Ingrediente i30 = new Ingrediente(null, "Canela", 247.0);
    final Ingrediente i31 = new Ingrediente(null, "Coelho", 200.0);
    final Ingrediente i32 = new Ingrediente(null, "Vinho Branco", 82.0);
    final Ingrediente i33 = new Ingrediente(null, "Massa Folhada", 558.0);
    final Ingrediente i34 = new Ingrediente(null, "Cacau", 228.0);
    final Ingrediente i35 = new Ingrediente(null, "Manteiga", 717.0);
    final Ingrediente i36 = new Ingrediente(null, "Fermento", 53.0);
    final Ingrediente i37 = new Ingrediente(null, "Azeite", 884.0);
    final Ingrediente i38 = new Ingrediente(null, "Maionese", 680.0);
    final Ingrediente i39 = new Ingrediente(null, "Mostarda", 66.0);
    final Ingrediente i40 = new Ingrediente(null, "Paprica", 282.0);
    final Ingrediente i41 = new Ingrediente(null, "Camarão", 138.0);


    /*
    ********************************************
    */

    final Prato p1 = new Prato(null, "Arroz de pato", 6.5,
        "https://www.pingodoce.pt/wp-content/uploads/2016/12/arroz-de-pato-617x370.jpg");

    final IngredientesPorPrato ipp1 = new IngredientesPorPrato(p1, i1, 300.0);
    final IngredientesPorPrato ipp2 = new IngredientesPorPrato(p1, i2, 500.0);
    final IngredientesPorPrato ipp3 = new IngredientesPorPrato(p1, i3, 100.0);

    c1.setPratos(Arrays.asList(p1));
    p1.setIngredientes(Arrays.asList(ipp1, ipp2, ipp3));
    p1.setCategorias(Arrays.asList(c1));

    /*
    ********************************************
    */

    final Prato p2 = new Prato(null, "Carapaus fritos com arroz de tomate", 7.0,
        "http://www.foodfromportugal.com/content/uploads/2018/03/carapaus-fritos-com-arroz-de-tomatexx1-575x375.jpg");

    final IngredientesPorPrato ipp21 = new IngredientesPorPrato(p2, i13, 1000.0);
    final IngredientesPorPrato ipp22 = new IngredientesPorPrato(p2, i1, 300.0);
    final IngredientesPorPrato ipp23 = new IngredientesPorPrato(p2, i14, 100.0);
    final IngredientesPorPrato ipp24 = new IngredientesPorPrato(p2, i15, 30.0);
    final IngredientesPorPrato ipp25 = new IngredientesPorPrato(p2, i16, 10.0);

    c2.setPratos(Arrays.asList(p2));
    p2.setIngredientes(Arrays.asList(ipp21, ipp22, ipp23, ipp24, ipp25));
    p2.setCategorias(Arrays.asList(c2));

    /*
    ********************************************
    */

    final Prato p3 = new Prato(null, "Migas com entrecosto", 7.0,
        "http://www.foodfromportugal.com/content/uploads/2016/12/migas-com-entrecosto-1-575x375.jpg");

    final IngredientesPorPrato ipp31 = new IngredientesPorPrato(p3, i17, 1000.0);
    final IngredientesPorPrato ipp32 = new IngredientesPorPrato(p3, i16, 60.0);
    final IngredientesPorPrato ipp33 = new IngredientesPorPrato(p3, i18, 50.0);
    final IngredientesPorPrato ipp34 = new IngredientesPorPrato(p3, i19, 150.0);

    c1.setPratos(Arrays.asList(p3));
    p3.setIngredientes(Arrays.asList(ipp31, ipp32, ipp33, ipp34));
    p3.setCategorias(Arrays.asList(c1));

    /*
    ********************************************
    */

    final Prato p4 = new Prato(null, "Polvo à jardineira", 11.0,
        "http://www.foodfromportugal.com/content/uploads/2016/06/polvo-a-jardineiraxx-575x375.jpg");

    final IngredientesPorPrato ipp41 = new IngredientesPorPrato(p4, i20, 1200.0);
    final IngredientesPorPrato ipp42 = new IngredientesPorPrato(p4, i21, 200.0);
    final IngredientesPorPrato ipp43 = new IngredientesPorPrato(p4, i7, 200.0);
    final IngredientesPorPrato ipp44 = new IngredientesPorPrato(p4, i15, 100.0);
    final IngredientesPorPrato ipp45 = new IngredientesPorPrato(p4, i3, 100.0);
    final IngredientesPorPrato ipp46 = new IngredientesPorPrato(p4, i14, 300.0);
    final IngredientesPorPrato ipp47 = new IngredientesPorPrato(p4, i16, 80.0);
    final IngredientesPorPrato ipp48 = new IngredientesPorPrato(p4, i18, 80.0);
    final IngredientesPorPrato ipp49 = new IngredientesPorPrato(p4, i12, 1000.0);

    c2.setPratos(Arrays.asList(p4));
    p4.setIngredientes(
        Arrays.asList(ipp41, ipp42, ipp43, ipp44, ipp45, ipp46, ipp47, ipp48, ipp49));
    p4.setCategorias(Arrays.asList(c2));

    /*
    ********************************************
    */

    final Prato p5 = new Prato(null, "Sopa de cação à alentejana", 6.0,
        "http://www.foodfromportugal.com/content/uploads/2016/05/sopa-de-cacao-a-alentejanax1-575x375.jpg");

    final IngredientesPorPrato ipp51 = new IngredientesPorPrato(p5, i22, 700.0);
    final IngredientesPorPrato ipp52 = new IngredientesPorPrato(p5, i16, 50.0);
    final IngredientesPorPrato ipp53 = new IngredientesPorPrato(p5, i18, 80.0);
    final IngredientesPorPrato ipp54 = new IngredientesPorPrato(p5, i15, 50.0);
    final IngredientesPorPrato ipp55 = new IngredientesPorPrato(p5, i17, 200.0);

    c6.setPratos(Arrays.asList(p5));
    p5.setIngredientes(Arrays.asList(ipp51, ipp52, ipp53, ipp54, ipp55));
    p5.setCategorias(Arrays.asList(c6));

    /*
    ********************************************
    */

    final Prato p6 = new Prato(null, "Assadura à Monchique", 7.0,
        "http://www.foodfromportugal.com/content/uploads/2015/07/assadura-a-monchiquexx575x375.jpg");

    final IngredientesPorPrato ipp61 = new IngredientesPorPrato(p6, i23, 400.0);
    final IngredientesPorPrato ipp62 = new IngredientesPorPrato(p6, i24, 10.0);
    final IngredientesPorPrato ipp63 = new IngredientesPorPrato(p6, i18, 80.0);
    final IngredientesPorPrato ipp64 = new IngredientesPorPrato(p6, i16, 80.0);

    c2.setPratos(Arrays.asList(p6));
    p6.setIngredientes(Arrays.asList(ipp61, ipp62, ipp63, ipp64));
    p6.setCategorias(Arrays.asList(c2));

    /*
    ********************************************
    */

    final Prato p7 = new Prato(null, "Bacalhau tradicional", 9.0,
        "http://www.foodfromportugal.com/content/uploads/2015/05/bacalhau-tradicional-575x375.jpg");

    final IngredientesPorPrato ipp71 = new IngredientesPorPrato(p7, i4, 500.0);
    final IngredientesPorPrato ipp72 = new IngredientesPorPrato(p7, i16, 80.0);
    final IngredientesPorPrato ipp73 = new IngredientesPorPrato(p7, i18, 80.0);
    final IngredientesPorPrato ipp74 = new IngredientesPorPrato(p7, i15, 50.0);
    final IngredientesPorPrato ipp75 = new IngredientesPorPrato(p7, i12, 600.0);
    final IngredientesPorPrato ipp76 = new IngredientesPorPrato(p7, i37, 10.0);

    c2.setPratos(Arrays.asList(p7));
    p7.setIngredientes(Arrays.asList(ipp71, ipp72, ipp73, ipp74, ipp75, ipp76));
    p7.setCategorias(Arrays.asList(c2));

    /*
    ********************************************
    */

    final Prato p8 = new Prato(null, "Pataniscas de peixe", 6.5,
        "http://www.foodfromportugal.com/content/uploads/2015/05/pataniscas-de-peixe-575x375.jpg");

    final IngredientesPorPrato ipp81 = new IngredientesPorPrato(p8, i22, 400.0);
    final IngredientesPorPrato ipp82 = new IngredientesPorPrato(p8, i26, 10.0);
    final IngredientesPorPrato ipp83 = new IngredientesPorPrato(p8, i15, 70.0);
    final IngredientesPorPrato ipp84 = new IngredientesPorPrato(p8, i18, 80.0);
    final IngredientesPorPrato ipp85 = new IngredientesPorPrato(p8, i9, 70.0);

    c2.setPratos(Arrays.asList(p8));
    p8.setIngredientes(Arrays.asList(ipp81, ipp82, ipp83, ipp84, ipp85));
    p8.setCategorias(Arrays.asList(c2));

    /*
    ********************************************
    */

    final Prato p9 = new Prato(null, "Sericaia", 3.5,
        "http://www.foodfromportugal.com/content/uploads/2014/12/sericaia1-575x375.jpg");

    final IngredientesPorPrato ipp91 = new IngredientesPorPrato(p9, i27, 350.0);
    final IngredientesPorPrato ipp92 = new IngredientesPorPrato(p9, i24, 5.0);
    final IngredientesPorPrato ipp93 = new IngredientesPorPrato(p9, i28, 125.0);
    final IngredientesPorPrato ipp94 = new IngredientesPorPrato(p9, i29, 70.0);
    final IngredientesPorPrato ipp95 = new IngredientesPorPrato(p9, i30, 70.0);
    final IngredientesPorPrato ipp96 = new IngredientesPorPrato(p9, i9, 170.0);

    c5.setPratos(Arrays.asList(p9));
    p9.setIngredientes(Arrays.asList(ipp91, ipp92, ipp93, ipp94, ipp95, ipp96));
    p9.setCategorias(Arrays.asList(c5));

    /*
    ********************************************
    */

    final Prato p10 = new Prato(null, "Coelho estufado com pão frito", 7.0,
        "http://www.foodfromportugal.com/content/uploads/2014/05/coelho-estufado-com-pao-fritox575x375.jpg");

    final IngredientesPorPrato ipp101 = new IngredientesPorPrato(p10, i31, 1200.0);
    final IngredientesPorPrato ipp102 = new IngredientesPorPrato(p10, i15, 100.0);
    final IngredientesPorPrato ipp103 = new IngredientesPorPrato(p10, i16, 50.0);
    final IngredientesPorPrato ipp104 = new IngredientesPorPrato(p10, i32, 100.0);
    final IngredientesPorPrato ipp105 = new IngredientesPorPrato(p10, i17, 200.0);
    final IngredientesPorPrato ipp106 = new IngredientesPorPrato(p10, i18, 100.0);

    c1.setPratos(Arrays.asList(p10));
    p10.setIngredientes(Arrays.asList(ipp101, ipp102, ipp103, ipp104, ipp105, ipp106));
    p10.setCategorias(Arrays.asList(c1));

    /*
    ********************************************
    */

    final Prato p11 = new Prato(null, "Tarte de pastel de nata", 2.5,
        "http://www.foodfromportugal.com/content/uploads/2014/03/tarte-de-pastel-de-nata-1xx575x375.jpg");

    final IngredientesPorPrato ipp111 = new IngredientesPorPrato(p11, i33, 200.0);
    final IngredientesPorPrato ipp112 = new IngredientesPorPrato(p11, i29, 15.0);
    final IngredientesPorPrato ipp113 = new IngredientesPorPrato(p11, i9, 320.0);
    final IngredientesPorPrato ipp114 = new IngredientesPorPrato(p11, i28, 200.0);
    final IngredientesPorPrato ipp115 = new IngredientesPorPrato(p11, i27, 450.0);
    final IngredientesPorPrato ipp116 = new IngredientesPorPrato(p11, i24, 5.0);
    final IngredientesPorPrato ipp117 = new IngredientesPorPrato(p11, i30, 10.0);

    c5.setPratos(Arrays.asList(p11));
    p11.setIngredientes(Arrays.asList(ipp111, ipp112, ipp113, ipp114, ipp115, ipp116, ipp117));
    p11.setCategorias(Arrays.asList(c5));

    /*
    ********************************************
    */

    final Prato p12 = new Prato(null, "Bolo de cacau", 2.5,
        "http://www.foodfromportugal.com/content/uploads/2018/04/bolo-de-cacau-1-575x375.jpg");

    final IngredientesPorPrato ipp121 = new IngredientesPorPrato(p12, i34, 70.0);
    final IngredientesPorPrato ipp122 = new IngredientesPorPrato(p12, i28, 150.0);
    final IngredientesPorPrato ipp123 = new IngredientesPorPrato(p12, i24, 5.0);
    final IngredientesPorPrato ipp124 = new IngredientesPorPrato(p12, i9, 210.0);
    final IngredientesPorPrato ipp125 = new IngredientesPorPrato(p12, i35, 50.0);
    final IngredientesPorPrato ipp126 = new IngredientesPorPrato(p12, i29, 150.0);
    final IngredientesPorPrato ipp127 = new IngredientesPorPrato(p12, i36, 3.0);

    c5.setPratos(Arrays.asList(p12));
    p12.setIngredientes(Arrays.asList(ipp121, ipp122, ipp123, ipp124, ipp125, ipp126, ipp127));
    p12.setCategorias(Arrays.asList(c5));

    /*
    ********************************************
    */

    final Prato p13 = new Prato(null, "Pão frito", 2.5,
        "http://www.foodfromportugal.com/content/uploads/2017/08/pao-frito-575x375.jpg");

    final IngredientesPorPrato ipp131 = new IngredientesPorPrato(p13, i17, 400.0);
    final IngredientesPorPrato ipp132 = new IngredientesPorPrato(p13, i37, 100.0);
    final IngredientesPorPrato ipp133 = new IngredientesPorPrato(p13, i16, 50.0);
    final IngredientesPorPrato ipp134 = new IngredientesPorPrato(p13, i18, 80.0);

    c7.setPratos(Arrays.asList(p13));
    p13.setIngredientes(Arrays.asList(ipp131, ipp132, ipp133, ipp134));
    p13.setCategorias(Arrays.asList(c7));

    /*
    ********************************************
    */

    final Prato p14 = new Prato(null, "Ovos recheados", 2.5,
        "http://www.foodfromportugal.com/content/uploads/2015/08/ovos-recheados-575x375.jpg");

    final IngredientesPorPrato ipp141 = new IngredientesPorPrato(p14, i9, 300.0);
    final IngredientesPorPrato ipp142 = new IngredientesPorPrato(p14, i38, 15.0);
    final IngredientesPorPrato ipp143 = new IngredientesPorPrato(p14, i39, 8.0);
    final IngredientesPorPrato ipp144 = new IngredientesPorPrato(p14, i26, 15.0);
    final IngredientesPorPrato ipp145 = new IngredientesPorPrato(p14, i18, 25.0);
    final IngredientesPorPrato ipp146 = new IngredientesPorPrato(p14, i40, 25.0);

    c7.setPratos(Arrays.asList(p14));
    p14.setIngredientes(Arrays.asList(ipp141, ipp142, ipp143, ipp144, ipp145, ipp146));
    p14.setCategorias(Arrays.asList(c7));

    /*
    ********************************************
    */

    final Prato p15 = new Prato(null, "Camarão simples", 2.5,
        "http://www.foodfromportugal.com/content/uploads/2014/10/camarao-simples-575x375.jpg");

    final IngredientesPorPrato ipp151 = new IngredientesPorPrato(p15, i41, 300.0);
    final IngredientesPorPrato ipp152 = new IngredientesPorPrato(p15, i15, 50.0);
    final IngredientesPorPrato ipp153 = new IngredientesPorPrato(p15, i37, 50.0);
    final IngredientesPorPrato ipp154 = new IngredientesPorPrato(p15, i16, 30.0);
    final IngredientesPorPrato ipp155 = new IngredientesPorPrato(p15, i18, 80.0);
    final IngredientesPorPrato ipp156 = new IngredientesPorPrato(p15, i26, 15.0);

    c7.setPratos(Arrays.asList(p15));
    p15.setIngredientes(Arrays.asList(ipp151, ipp152, ipp153, ipp154, ipp155, ipp156));
    p15.setCategorias(Arrays.asList(c7));

    categoriaPratoRepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
    ingredienteRepo.saveAll(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13,
        i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31,
        i32, i33, i34, i35, i36, i37, i38, i39, i40, i41));
    pratoRepo
        .saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));
    ingredientesPorPratoRepo.saveAll(Arrays.asList(ipp1, ipp2, ipp3, ipp21, ipp22, ipp23, ipp24,
        ipp25, ipp31, ipp32, ipp33, ipp34, ipp41, ipp42, ipp43, ipp44, ipp45, ipp46, ipp47, ipp48,
        ipp49, ipp51, ipp52, ipp53, ipp54, ipp55, ipp61, ipp62, ipp63, ipp64, ipp71, ipp72, ipp73,
        ipp74, ipp75, ipp76, ipp81, ipp82, ipp83, ipp84, ipp85, ipp91, ipp92, ipp93, ipp94, ipp95,
        ipp96, ipp101, ipp102, ipp103, ipp104, ipp105, ipp106, ipp111, ipp112, ipp113, ipp114,
        ipp115, ipp116, ipp117, ipp121, ipp122, ipp123, ipp124, ipp125, ipp126, ipp127, ipp131,
        ipp132, ipp133, ipp134, ipp141, ipp142, ipp143, ipp144, ipp145, ipp146, ipp151, ipp152,
        ipp153, ipp154, ipp155, ipp156));
  }
}
