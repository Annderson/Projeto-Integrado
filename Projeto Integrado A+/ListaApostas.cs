using API_OrgaoRegulador;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Projeto_Integrado_A_
{
    public partial class ListaApostas : Form
    {

        public ListaApostas()
        {
            InitializeComponent();
        }

        private void ListaApostas_Load(object sender, EventArgs e)
        {
            var protocolos = ListaProtocolos();
            LSTapostas.Items.Clear();
            LSTapostas.Items.AddRange(protocolos.Select(p => (object) p.ToString()).ToArray());
        }

        private void BUTcons_Click(object sender, EventArgs e)
        {
            if (LSTapostas.SelectedItem != null)
                ConsultaProtocolo(LSTapostas.SelectedItem.ToString());
        }

        private void BUTsair_Click(object sender, EventArgs e)
        {
            this.Close();
        }


        public static long[] ListaProtocolos()
        {
            List<long> Protocolos = new List<long>();

            if (File.Exists("c:\\temp\\apostas.txt"))
            {
                System.IO.StreamReader file =
                    new System.IO.StreamReader("c:\\temp\\apostas.txt");

                string line;
                while ((line = file.ReadLine()) != null)
                {
                    long protocolo;
                    string protoStr = line.Split('=').First();
                    if (protoStr != null && long.TryParse(protoStr, out protocolo))
                    {
                        Protocolos.Add(protocolo);
                    }
                }

                file.Close();
            }

            return Protocolos.ToArray();
        }

        public static void ConsultaProtocolo(string protocoloStr)
        {
            var endPoint = new EndPoint();
            string rt = "";   //rt - rotulo para armazenar números e times escolhidos.

            int qd = 0, a = 0, nd, c2 = 0, dsCount;
            //qd - quantidade de dezenas da aposta, a - acertos
            //nd = número de uma determinada dezena, c2 - contador auxiliar, cs3 - contador auxiliar
            string da, ds, ts;
            //da - dezenas da aposta, ds - dezenas sorteados, ts - time sorteado

            //tap = times apostados
            long protocolo;
            if (!long.TryParse(protocoloStr, out protocolo))
                protocolo = 0;

            //qd = endPoint.obterQuantidadeDezenasApostadas(protocolo);
            da = endPoint.obterTodasDezenasApostadas(protocolo); // Replace here!!!
            if (da == null)
            {
                MessageBox.Show("Protocolo incorreto.");
                return;
            }

            ds = endPoint.ObterTodosNumerosSorteados();
            ts = endPoint.obterNomeTimeSorteado();

            string[] daSplit = da.Split(',');
            string[] dsSplit = ds.Split(',');
            qd = daSplit.Count();

            string[] tap = new string[qd];

            dsCount = dsSplit.Count();

            //verifica os acertos da aposta

            for (c2 = 0; c2 < dsCount; c2++)
            {
                for (int c = 0; c < qd; c++)
                {
                    if (daSplit[c].Equals(dsSplit[c2]))
                        a++;
                }
            }


            //verifica a quais times as dezenas apostadas pertencem, guara informações na
            //variável recibo para exibição futura, 
            rt = "";
            for (int c = 0; c < qd; c++)
            {
                nd = int.Parse(daSplit[c]); //verificar c+1

                if (nd >= 1 && nd <= 4)
                {
                    tap[c] = "Atletico Mineiro";
                    rt = rt + nd + " Atletico Mineiro\n";
                }
                else if (nd > 4 && nd <= 8)
                {
                    tap[c] = "Atletico Paranaense";
                    rt = rt + nd + " Atletico Paranaense\n";
                }
                else if (nd > 8 && nd <= 12)
                {
                    tap[c] = "Bahia";
                    rt = rt + nd + " Bahia\n";
                }
                else if (nd > 12 && nd <= 16)
                {
                    tap[c] = "Botafogo";
                    rt = rt + nd + " Botafogo\n";
                }
                else if (nd > 16 && nd <= 20)
                {
                    tap[c] = "Ceara";
                    rt = rt + nd + " Ceara\n";
                }
                else if (nd > 20 && nd <= 24)
                {
                    tap[c] = "Corinthians";
                    rt = rt + nd + " Corinthians\n";
                }
                else if (nd > 24 && nd <= 28)
                {
                    tap[c] = "Coritiba";
                    rt = rt + nd + " Coritiba\n";
                }
                else if (nd > 28 && nd <= 32)
                {
                    tap[c] = "Cruzeiro";
                    rt = rt + nd + " Cruzeiro\n";
                }
                else if (nd > 32 && nd <= 36)
                {
                    tap[c] = "Flamengo";
                    rt = rt + nd + " Flamengo\n";
                }
                else if (nd > 36 && nd <= 40)
                {
                    tap[c] = "Fluminense";
                    rt = rt + nd + " Fluminense\n";
                }
                else if (nd > 40 && nd <= 44)
                {
                    tap[c] = "Fortaleza";
                    rt = rt + nd + " Fortaleza\n";
                }
                else if (nd > 44 && nd <= 48)
                {
                    tap[c] = "Goias";
                    rt = rt + nd + " Goias\n";
                }
                else if (nd > 48 && nd <= 52)
                {
                    tap[c] = "Gremio";
                    rt = rt + nd + " Gremio\n";
                }
                else if (nd > 52 && nd <= 56)
                {
                    tap[c] = "Guarani";
                    rt = rt + nd + " Guarani\n";
                }
                else if (nd > 56 && nd <= 60)
                {
                    tap[c] = "Internacional";
                    rt = rt + nd + " Internacional\n";
                }
                else if (nd > 60 && nd <= 64)
                {
                    tap[c] = "Nautico";
                    rt = rt + nd + " Nautico\n";
                }
                else if (nd > 64 && nd <= 68)
                {
                    tap[c] = "Palmeiras";
                    rt = rt + nd + " Palmeiras\n";
                }
                else if (nd > 68 && nd <= 72)
                {
                    tap[c] = "Parana Clube";
                    rt = rt + nd + " Parana Clube\n";
                }
                else if (nd > 72 && nd <= 76)
                {
                    tap[c] = "Ponte Preta";
                    rt = rt + nd + " Ponte Preta\n";
                }
                else if (nd > 76 && nd <= 80)
                {
                    tap[c] = "Santa Cruz";
                    rt = rt + nd + " Santa Cruz\n";
                }
                else if (nd > 80 && nd <= 84)
                {
                    tap[c] = "Santos";
                    rt = rt + nd + " Santos\n";
                }
                else if (nd > 84 && nd <= 88)
                {
                    tap[c] = "São Paulo";
                    rt = rt + nd + " São Paulo\n";
                }
                else if (nd > 88 && nd <= 92)
                {
                    tap[c] = "Sport";
                    rt = rt + nd + " Sport\n";
                }
                else if (nd > 92 && nd <= 96)
                {
                    tap[c] = "Vasco da Gama";
                    rt = rt + nd + " Vasco da Gama\n";
                }
                else if ((nd > 96 && nd <= 99) || (nd == 00))
                {
                    tap[c] = "Vitoria";
                    rt = rt + nd + " Vitoria\n";
                }
            }


            double va = 0;
            if (a >= 3)
            {
                va = endPoint.obterPremioPorAcertos(a);

                for (int c = 0; c < qd; c++)
                    if (ts == tap[c])
                        va = va + 5.00;
            }

            string recibo = "Mega Time\n\nNº do protocolo: " + protocolo + "\n\nDezenas e times apostados:\n===================\n\n" + rt + "Nº de acertos: " + a + "\n\nPremio: R$" + va;
            MessageBox.Show(recibo);
            
            
        }
    }
}
