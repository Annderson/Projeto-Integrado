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
            var endPoint = new API_OrgaoRegulador.EndPoint();
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

                var timeIdx = Projeto_Integrado_A_v2.CalculaIndiceDoTime(nd);
                var timeStr = Projeto_Integrado_A_v2.NomeDoTime(timeIdx);
                tap[c] = timeStr;
                rt = rt + nd.ToString("00") + " - " + timeStr + "\n";
            }


            double va = 0;
            if (a >= 3)
                va = endPoint.obterPremioPorAcertos(a);

            for (int c = 0; c < qd; c++)
                if (ts == tap[c])
                    va += 5.00;

            string recibo = "Mega Time\n\nNº do protocolo: " + protocolo + "\n\nDezenas e times apostados:\n===================\n\n" + rt + "Nº de acertos: " + a + "\n\nPremio: R$" + va;
            MessageBox.Show(recibo);

            // Hu3 Hu3 API BUG:
            // É necessário forçar o Dealoc da API para não dar crash na próxima gravação.
            // Sem mais IOException
            var gen = GC.GetGeneration(endPoint);
            GC.Collect(gen, GCCollectionMode.Forced, true);
        }

    }
}
