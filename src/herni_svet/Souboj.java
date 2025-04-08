    package herni_svet;

    import postavy.Hrac;
    import postavy.Nepritel;
    import postavy.Postava;
    import predmety.Predmet;

    import java.util.Random;
    import java.util.Scanner;

    /**
     * Trida Souboj slouzi k provedeni souboje mezi hracem a nepritelem.
     *
     * @author Tomas Voborny
     */
    public class Souboj {

        private Hrac hrac;
        private Svet svet;
        private Nepritel nepritel;

        /**
         * Konstruktor pro vytvoreni souboje mezi hracem a nepritelem.
         *
         * @param hrac Hrac, ktery se zucastnuje souboje
         * @param nepritel Nepritel, proti kteremu hrac bojuje
         * @param svet Svet, ve kterem se souboj odehrava
         */
        public Souboj(Hrac hrac, Nepritel nepritel, Svet svet) {
            this.hrac = hrac;
            this.nepritel = nepritel;
            this.svet = svet;
        }

        /**
         * Zahajuje souboj mezi hracem a nepritelem. Hrac muze volit mezi utokem a obranou.
         * Nepritel muze reagovat ruznymi zpusoby. Souboj pokracuje, dokud nekdo neztrati vsechny zivoty.
         *
         * @param sc Scanner pro vstupy od uzivatele
         * @return Zprava o vysledku souboje
         */
        public String zahajitSouboj(Scanner sc) {

            System.out.println("Narazil jsi na nepritele: " + nepritel.getJmeno());
            System.out.println(nepritel.getDialog());


            if (nepritel.getJmeno().equalsIgnoreCase("Veleslav")) {
                for (Predmet predmet : hrac.getInventar().getInventar()) {
                    if (predmet.getJmeno().equalsIgnoreCase("Lektvar odvahy")) {
                        System.out.println("Mas Lektvar odvahy! Chces ho pouzit? (ano/ne)");
                        String odpoved = sc.nextLine().toLowerCase();

                        if (odpoved.equals("ano")) {
                            hrac.getInventar().odstraneniPredmetu(predmet);
                            hrac.setSila(hrac.getSila() + 10);
                            System.out.println("Pouzil jsi Lektvar odvahy! Tvoje sila je docasne zvysena.");
                        }
                        break;
                    }
                }
            }

            while (hrac.getZivoty() > 0 && nepritel.getZivoty() > 0) {
                System.out.println("\nTvoje zivoty: " + hrac.getZivoty() + " | Zivoty nepritele: " + nepritel.getZivoty());
                System.out.println("Vyber akci: 1. Utok | 2. Obrana");
                int volba = sc.nextInt();

                if (volba == 1) {
                    int hracUtok = hrac.getSila();
                    nepritel.setZivoty(nepritel.getZivoty() - hracUtok);
                    System.out.println("Zautocil jsi a zpusobil " + hracUtok + " poskozeni.");
                } else if (volba == 2) {
                    System.out.println("Pripravil jsi se na obranu! Poskozeni nepritele se snizi.");
                }


                if (nepritel.getZivoty() > 0) {
                    Random random = new Random();
                    int nepritelVolba;
                    if (random.nextInt(10) < 7) {
                        nepritelVolba = 1;
                    } else {
                        nepritelVolba = 2;
                    }
                    if (nepritelVolba == 1) {
                        int nepritelUtok = nepritel.getSila();
                        if (volba == 2) {
                            nepritelUtok /= 2;
                        }
                        hrac.setZivoty(hrac.getZivoty() - nepritelUtok);
                        System.out.println("Nepritel zautocil a zpusobil " + nepritelUtok + " poskozeni.");
                    } else {
                        System.out.println("Nepritel se pripravil na obranu.");
                    }
                }

                if(hrac.getZivoty() <= 0) {
                    System.out.println("Prohral jsi... Nepritel te premohl.");
                    System.exit(0);
                }

                if (nepritel.getZivoty() <= 0) {
                    switch (nepritel.getJmeno()) {
                        case "Vlk":
                            nepritel.setZivoty(10);
                            hrac.setVlciKosti(hrac.getVlciKosti()+2);
                            break;
                        case "Veleslav" :
                            System.out.println("Porazil jsi Veleslava a osvobodil jsi Temny les!");
                            System.out.println("HRA SKONCILA. Gratulujeme k vitezstvi!");
                            System.exit(0);
                            break;
                        default:
                            svet.getPostavy().remove(nepritel);
                            return "Vitezstvi! Porazil jsi " + nepritel.getJmeno();
                    }
                }
            }
            return "Vitezstvi! Porazil jsi " + nepritel.getJmeno();
        }
    }