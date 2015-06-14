using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Projeto_Integrado_A_
{
    public partial class Sorteio2 : Form
    {
        public Sorteio2()
        {
            InitializeComponent();
        }
        
        private void BUTstar_Click(object sender, EventArgs e)
        {
            int contador = 0;

            Random rand = new Random();

            while (contador < 10)
            {
                int N = rand.Next(00, 99);
                TXTsortiados.Text = TXTsortiados.Text + "  " + N;
                
                if (B1.AccessibleName == Convert.ToString(N))
                {
                    B1.Enabled = false;
                }
                if (B2.AccessibleName == Convert.ToString(N))
                {
                    B2.Enabled = false;
                }
                if (B3.AccessibleName == Convert.ToString(N))
                {
                    B3.Enabled = false;
                }
                if (B4.AccessibleName == Convert.ToString(N))
                {
                    B4.Enabled = false;
                }
                if (B5.AccessibleName == Convert.ToString(N))
                {
                    B5.Enabled = false;
                }
                if (B6.AccessibleName == Convert.ToString(N))
                {
                    B6.Enabled = false;
                }
                if (B7.AccessibleName == Convert.ToString(N))
                {
                    B7.Enabled = false;
                }
                if (B8.AccessibleName == Convert.ToString(N))
                {
                    B8.Enabled = false;
                }
                if (B9.AccessibleName == Convert.ToString(N))
                {
                    B9.Enabled = false;
                }
                if (B10.AccessibleName == Convert.ToString(N))
                {
                    B10.Enabled = false;
                }
                contador++;
            }

        }

        private void B9_Click(object sender, EventArgs e)
        {

        }

    }
}
