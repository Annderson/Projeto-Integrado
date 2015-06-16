﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Projeto_Integrado_A_;

namespace Projeto_Integrado_A_
{
    public partial class Teste : Form
    {

        List<int> Sorteados;
        IEnumerable<Button> BotoesDeNumero;

        public Teste()
        {
            InitializeComponent();
            Sorteados = new List<int>();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {

            Random rand = new Random();

            // Impede de gerar repetidos
            int S;
            do
            {
                S = rand.Next(00, 99);
            } while (Sorteados.Any(n => n == S));

            Sorteados.Add(S);

            // Para de sortear quando tem 20
            if (Sorteados.Count() >= 20)
            {
                BUTstop.PerformClick();
            }

            if (Sorteados.Count() >= 10)
            {
                BUTapost.Enabled = true;
            }
            else
            {
                BUTapost.Enabled = false;
            }


            // Marca a cor no botão

            foreach (var but in BotoesDeNumero)
            {
                if (int.Parse(but.Text) == S)
                {
                    but.BackColor = Color.Red;
                }
            }

            // Poe no text box
            TXTsortiados.Text = TXTsortiados.Text + S.ToString("00") + " ";

        }

        private void Sorteio_Load(object sender, EventArgs e)
        {
            BotoesDeNumero = this.Controls.OfType<GroupBox>().First().Controls.OfType<Button>();
        }

        private void BUTstar_Click(object sender, EventArgs e)
        {
            if (Sorteados.Count >= 20)
                BUTlimp.PerformClick();

            timer1.Start();
        }

        private void BUTstop_Click(object sender, EventArgs e)
        {
            timer1.Stop();

            if (Sorteados.Count >= 10)
                BUTapost.Enabled = true;
        }

        private void BUTapost_Click(object sender, EventArgs e)
        {
            Projeto_Integrado_A_v2.VerificaGravaAposta(TXTsortiados.Text);
            this.Close();
        }

        private void BUTlimp_Click(object sender, EventArgs e)
        {
            TXTsortiados.Clear();
            Sorteados.Clear();
            BUTapost.Enabled = false;

            foreach (var btn in BotoesDeNumero)
                btn.BackColor = BUTstop.BackColor;
        }

    }
}
