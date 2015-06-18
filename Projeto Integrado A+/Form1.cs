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
    public partial class Projeto_Integrado_A_v2 : Form
    {

        public Projeto_Integrado_A_v2()
        {
            InitializeComponent();

            //Botões Validar Aposta e Limpar ficarão habilitados somente quando necessário.

            BUTvap.Enabled = false;
            BUTlimp.Enabled = false;
        }

        private void Projeto_Integrado_A_v2_Load(object sender, EventArgs e)
        {
            
        }

        private void TXTent_KeyPress(object sender, KeyPressEventArgs e)
        {
            //Bloqueio para que usuário consiga digitar somente números.


            if (char.IsLetter(e.KeyChar) || e.KeyChar == ' ')
                e.Handled = true;
            else if (char.IsSymbol(e.KeyChar))
                e.Handled = true;
            else if (char.IsPunctuation(e.KeyChar))
                e.Handled = true;

            // Cria mascara para dar espaçamento adequado entre os números digitados.
            if (TXTent.TextLength == 0)
                TXTent.Text = "";
            else
            {
                int pl = TXTent.TextLength - 2;
                if (pl % 3 == 0)
                {
                    TXTent.Text = TXTent.Text + " ";
                    TXTent.SelectionStart = pl + 4;
                }
            }


            var currentLength = TXTent.Text.Count();

            // Backspace
            if (e.KeyChar == 8)
            {
                var newLength = currentLength - 1;
                if (newLength >= 0)
                {
                    TXTent.Text = TXTent.Text.Substring(0, newLength);
                    TXTent.SelectionStart = newLength;
                    currentLength = newLength;
                }

                BUTvap.Enabled = newLength >= 30;
            } 
            else
            {
                // Habilita o botão validar aposto somente quando dez números ou mais forem digitados
                BUTvap.Enabled = currentLength >= 28;
            }

            if (TXTent.Text.Length > 0)
                BUTlimp.Enabled = true;
        }


        private void Processamento_Click(object sender, EventArgs e)
        {
            Button cmd = (Button)sender;

            switch (cmd.AccessibleDescription)
            {
                case "V":
                    VerificaGravaAposta(TXTent.Text);
                    BUTlimp.PerformClick();
                    break;

                //limpar todas as informações inseridas pelo usuário
                case "L":
                    {
                        TXTent.Text = "";
                        BUTvap.Enabled = false;
                        TXTent.Focus();
                        TXTconsult.Text = "";
                        break;
                    }

                //realiza consutla de protocolo e verifica valor do premio, caso se aplique
                case "C":
                    {
                        ListaApostas.ConsultaProtocolo(TXTconsult.Text);
                        TXTconsult.Clear();
                        break;
                    }


                case "R":
                    {
                        var form = new Regras();
                        form.ShowDialog();
                        break;
                    }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form Sorteio = new Projeto_Integrado_A_.Sorteio();
            Sorteio.ShowDialog();
        }

        public static void VerificaGravaAposta(string aposta)
        {
            string[] TIMES = new string[25]{
                "Atletico Mineiro", "Atletico Paranaense", "Bahia", "Botafogo", "Ceara", "Corinthians", "Coritiba", 
                "Cruzeiro", "Flamengo", "Fluminense", "Fortaleza", "Goias", "Gremio", "Guarani", "Internacional", "Nautico", 
                "Palmeiras", "Parana Clube", "Ponte Preta", "Santa Cruz", "Santos", "São Paulo", "Sport", "Vasco da Gama", "Vitoria"
            };

            aposta = aposta.Trim();
            int qna = Convert.ToInt32(aposta.Replace(" ", "").Length / 2), cs = 0, cs2 = 2;

            int[] ne = new int[qna];   //ne - números escolhidos.
            int[] vrg = new int[25];  //vrg - verificador da regra dos grupos.    
            string rt = "";   //rt - rotulo para armazenar números e times escolhidos.

            //verifica a quais times pertencem os números apostados, concatena os números e os times 
            //escolhidos em uma string para uso posterior, printar o recibo.            

            rt = "";
            for (int c = 0; c < qna; c++)
            {
                ne[c] = Convert.ToInt32(aposta.Substring(cs, cs2));
                cs = cs + 3; // verificar se funciona com cs +=3; 
            }

            //ordena os números escolhidos para exibição e comparação
            System.Array.Sort(ne);

            for (int c = 0; c < qna; c++)
            {
                int timeIdx = CalculaIndiceDoTime(ne[c]);
                var timeStr = NomeDoTime(timeIdx);
                vrg[c] = 1;
                rt = rt + ne[c].ToString("00") + " - " + timeStr + "\n";
            }

            //compara se há números repetidos entre os escolhidos e verifica se foram escolhidos menos de
            //cinco times diferentes

            int qta = vrg.Sum();   //qta - quantidade de times apostados
            if (qta < 5)
            {
                MessageBox.Show("É necessário escolher números de ao menos cinco times diferentes. \n\nRefaça sua aposta.");
                return;
            }

            for (int c = 0; c < qna - 1; c++)
            {
                if (ne[c] == ne[c + 1])
                {
                    MessageBox.Show("O jogo Mega Time não aceita números repetidos. \n\nRefaça sua aposta.");
                    return;
                }
            }

            //realiza o calculo do valor da aposta de acordo com as especificações da regra do jogo

            double va = 5;

            if (qna > 10 && qna <= 15)
            {
                va = 5 + ((qna - 10) * 0.75);
            }
            else if (qna > 15 && qna <= 19)
            {
                va = 8.75 + ((qna - 15) * 3.00);
            }
            else if (qna == 20)
                va = 27.75;

            if (qta > 5)
                va = va + ((qta - 5) * 1.25);

            //armazenamento da aposta na API e impressão do recibo

            string txtTratado = aposta.Split(' ').Select(str => int.Parse(str).ToString()).Aggregate((str, acc) => str + "," + acc);
            
            long protocolo;
            
            try
            {
                var endPoint = new API_OrgaoRegulador.EndPoint();
                protocolo = endPoint.gravarAposta(txtTratado);
                var gen = GC.GetGeneration(endPoint);
                GC.Collect(gen, GCCollectionMode.Forced, true);
            }
            catch (IOException)
            {
                var endPoint = new API_OrgaoRegulador.EndPoint();
                protocolo = endPoint.gravarAposta(txtTratado);
            }

            if (protocolo != 0)
            {
                var recibo = "Mega Time\n\n" + "Nº do protocolo: " + protocolo + "\n\nDezenas e times escolhidos:\n" + "===================\n" + rt + "===================\n\n" + "Valor da aposta: " + va.ToString("C");
                MessageBox.Show(recibo);
            }
            else
            {
                MessageBox.Show("Houve uma falha ao salvar sua aposta.\nTente novamente mais tarde.");
            }
        }


        public static int CalculaIndiceDoTime(int nd)
        {
            int timeIdx = 0;
            if (nd != 0)
                timeIdx = (nd - 1) / 4;
            else
                timeIdx = 24;

            return timeIdx;
        }

        public static string NomeDoTime(int idx)
        {
            string[] TIMES = new string[25]{
                "Atletico Mineiro", "Atletico Paranaense", "Bahia", "Botafogo", "Ceara", "Corinthians", "Coritiba", 
                "Cruzeiro", "Flamengo", "Fluminense", "Fortaleza", "Goias", "Gremio", "Guarani", "Internacional", "Nautico", 
                "Palmeiras", "Parana Clube", "Ponte Preta", "Santa Cruz", "Santos", "São Paulo", "Sport", "Vasco da Gama", "Vitoria"
            };

            return TIMES[idx];
        }

        private void BUTlistaapst_Click(object sender, EventArgs e)
        {
            var frm = new ListaApostas();
            frm.ShowDialog();
        }
    }
}
