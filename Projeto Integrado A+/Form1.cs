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

                if (ne[c] >= 1 && ne[c] <= 4)
                {
                    vrg[0] = 1;
                    rt = rt + ne[c] + " - Vasco da Gama\n";
                }
                else if (ne[c] > 4 && ne[c] <= 8)
                {
                    vrg[1] = 1;
                    rt = rt + ne[c] + " - Atletico Paranaense\n";
                }
                else if (ne[c] > 8 && ne[c] <= 12)
                {
                    vrg[2] = 1;
                    rt = rt + ne[c] + " - Bahia\n";
                }
                else if (ne[c] > 12 && ne[c] <= 16)
                {
                    vrg[3] = 1;
                    rt = rt + ne[c] + " - Botafogo\n";
                }
                else if (ne[c] > 16 && ne[c] <= 20)
                {
                    vrg[4] = 1;
                    rt = rt + ne[c] + " - Ceara\n";
                }
                else if (ne[c] > 20 && ne[c] <= 24)
                {
                    vrg[5] = 1;
                    rt = rt + ne[c] + " - Corinthians\n";
                }
                else if (ne[c] > 24 && ne[c] <= 28)
                {
                    vrg[6] = 1;
                    rt = rt + ne[c] + " - Coritiba\n";
                }
                else if (ne[c] > 28 && ne[c] <= 32)
                {
                    vrg[7] = 1;
                    rt = rt + ne[c] + " - Cruzeiro\n";
                }
                else if (ne[c] > 32 && ne[c] <= 36)
                {
                    vrg[8] = 1;
                    rt = rt + ne[c] + " - Flamengo\n";
                }
                else if (ne[c] > 36 && ne[c] <= 40)
                {
                    vrg[9] = 1;
                    rt = rt + ne[c] + " - Fluminense\n";
                }
                else if (ne[c] > 40 && ne[c] <= 44)
                {
                    vrg[10] = 1;
                    rt = rt + ne[c] + " - Fortaleza\n";
                }
                else if (ne[c] > 44 && ne[c] <= 48)
                {
                    vrg[11] = 1;
                    rt = rt + ne[c] + " - Goias\n";
                }
                else if (ne[c] > 48 && ne[c] <= 52)
                {
                    vrg[12] = 1;
                    rt = rt + ne[c] + " - Gremio\n";
                }
                else if (ne[c] > 52 && ne[c] <= 56)
                {
                    vrg[13] = 1;
                    rt = rt + ne[c] + " - Guarani\n";
                }
                else if (ne[c] > 56 && ne[c] <= 60)
                {
                    vrg[14] = 1;
                    rt = rt + ne[c] + " - Internacional\n";
                }
                else if (ne[c] > 60 && ne[c] <= 64)
                {
                    vrg[15] = 1;
                    rt = rt + ne[c] + " - Nautico\n";
                }
                else if (ne[c] > 64 && ne[c] <= 68)
                {
                    vrg[16] = 1;
                    rt = rt + ne[c] + " - Palmeiras\n";
                }
                else if (ne[c] > 68 && ne[c] <= 72)
                {
                    vrg[17] = 1;
                    rt = rt + ne[c] + " - Parana Clube\n";
                }
                else if (ne[c] > 72 && ne[c] <= 76)
                {
                    vrg[18] = 1;
                    rt = rt + ne[c] + " - Ponte Preta\n";
                }
                else if (ne[c] > 76 && ne[c] <= 80)
                {
                    vrg[19] = 1;
                    rt = rt + ne[c] + " - Santa Cruz\n";
                }
                else if (ne[c] > 80 && ne[c] <= 84)
                {
                    vrg[20] = 1;
                    rt = rt + ne[c] + " - Santos\n";
                }
                else if (ne[c] > 84 && ne[c] <= 88)
                {
                    vrg[21] = 1;
                    rt = rt + ne[c] + " - Sao Paulo\n";
                }
                else if (ne[c] > 88 && ne[c] <= 92)
                {
                    vrg[22] = 1;
                    rt = rt + ne[c] + " - Sport\n";
                }
                else if (ne[c] > 92 && ne[c] <= 96)
                {
                    vrg[23] = 1;
                    rt = rt + ne[c] + " - Vasco da Gama\n";
                }
                else if ((ne[c] > 96 && ne[c] <= 99) || (ne[c] == 0))
                {
                    vrg[24] = 1;
                    rt = rt + ne[c] + " - Vitoria\n";
                }
            }


            //ordena os números escolhidos para realizar comparação
            System.Array.Sort(ne);

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
                var endPoint = new EndPoint();
                protocolo = endPoint.gravarAposta(txtTratado);
                var gen = GC.GetGeneration(endPoint);
                GC.Collect(gen, GCCollectionMode.Forced, true);
            }
            catch (IOException)
            {
                var endPoint = new EndPoint();
                protocolo = endPoint.gravarAposta(txtTratado);
            }

            string recibo;

            recibo = "Mega Time\n\n" + "Nº do protocolo: " + protocolo + "\n\nDezenas e times escolhidos:\n" + "===================\n" + rt + "===================\n\n" + "Valor da aposta: " + va.ToString("C");
            MessageBox.Show(recibo);
        }

        private void BUTlistaapst_Click(object sender, EventArgs e)
        {
            var frm = new ListaApostas();
            frm.ShowDialog();
        }
    }
}
