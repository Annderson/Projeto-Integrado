﻿using API_OrgaoRegulador;
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
        private EndPoint endPoint;
        int c;

        public Projeto_Integrado_A_v2()
        {
            InitializeComponent();



            //Botões Validar Aposta e Limpar ficarão habilitados somente quando necessário.

            BUTvap.Enabled = false;
            BUTlimp.Enabled = false;



        }

        private void Projeto_Integrado_A_v2_Load(object sender, EventArgs e)
        {
            endPoint = new EndPoint();
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

            var protocolosJogados = ListaProtocolos();
            int qtosJogados = protocolosJogados.Count();

            int qna = Convert.ToInt32(TXTent.Text.Replace(" ", "").Length / 2);

            int[] ne = new int[qna];   //ne - números escolhidos.
            int[] vrg = new int[qna];  //vrg - verificador da regra dos grupos.    
            string rt = "";   //rt - rotulo para armazenar números e times escolhidos.


            switch (cmd.AccessibleDescription)
            {
                case "V":
                    VerificaGravaAposta(TXTent.Text);
                    BUTlimp.PerformClick();
                    break;

                //limpar todas as informações inseridas pelo usuário
                case "L":
                    {
                        ne.DefaultIfEmpty();
                        vrg.DefaultIfEmpty();
                        TXTent.Text = "";
                        BUTvap.Enabled = false;
                        TXTent.Focus();
                        TXTconsult.Text = "";
                        break;
                    }

                //realiza consutla de protocolo e verifica valor do premio, caso se aplique
                case "C":
                    {
                        int qd = 0, a = 0, nd, c2 = 0, dsCount;
                        //qd - quantidade de dezenas da aposta, a - acertos
                        //nd = número de uma determinada dezena, c2 - contador auxiliar, cs3 - contador auxiliar
                        string da, ds, ts;
                        //da - dezenas da aposta, ds - dezenas sorteados, ts - time sorteado

                        //tap = times apostados
                        long protocolo;
                        if (!long.TryParse(TXTconsult.Text, out protocolo))
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
                            for (c = 0; c < qd; c++)
                            {
                                if (daSplit[c].Equals(dsSplit[c2]))
                                    a++;
                            }
                        }


                        //verifica a quais times as dezenas apostadas pertencem, guara informações na
                        //variável recibo para exibição futura, 
                        rt = "";
                        for (c = 0; c < qd; c++)
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

                            for (c = 0; c < qd; c++)
                                if (ts == tap[c])
                                    va = va + 5.00;
                        }

                        string recibo = "Mega Time\n\nNº do protocolo: " + protocolo + "\n\nDezenas e times apostados:\n===================\n\n" + rt + "Nº de acertos: " + a + "\n\nPremio: R$" + va;
                        MessageBox.Show(recibo);
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

        private void button1_Click(object sender, EventArgs e)
        {
            Form Sorteio2 = new Projeto_Integrado_A_.ListaApostas();
            Sorteio2.ShowDialog();
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
            var endPoint = new EndPoint();
            long protocolo = endPoint.gravarAposta(txtTratado);
            string recibo;

            recibo = "Mega Time\n\n" + "Nº do protocolo: " + protocolo + "\n\nDezenas e times escolhidos:\n" + "===================\n" + rt + "===================\n\n" + "Valor da aposta: " + va.ToString("C");
            MessageBox.Show(recibo);
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
    }
}
